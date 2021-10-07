package servlets;

import props.Blog;
import utils.DBUtil;
import utils.Util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="blogServlet", value = "/blog-insert")
public class BlogServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String title= req.getParameter("title");
        String detail=req.getParameter("detail");

        Blog blog=new Blog();
         blog.setDetail(detail);
         blog.setTitle(title);
         int aid=(int) req.getSession().getAttribute("aid");
        DBUtil util=new DBUtil();
        int status=util.BlogInsert(blog,aid);
      if (status>0){
          resp.sendRedirect(Util.base_url1+"dashboard.jsp");

      }else {
          String errorMessage="";
          if (status==0){
              errorMessage="ekleme sırasında hata oluştu";
          }
          if (status==-1){
              errorMessage="bu title kullanılmış";

          }
          req.setAttribute("blogServlet error",errorMessage);
          RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/dashboard.jsp");
          dispatcher.forward(req,resp);
      }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cidx= req.getParameter("cidx");
        try {
           int cidxx= Integer.parseInt(cidx);
           int aid=(int)req.getSession().getAttribute("aid");
           DBUtil util=new DBUtil();
           if ((util.blogIsValid(cidxx,aid))){
               int status= util.blogDelete(cidxx);
               if (status>0){
                   resp.sendRedirect(Util.base_url1+"dashboard.jsp");
               }

           }
        } catch (NumberFormatException e) {
            System.out.println("delete item error");
            resp.sendRedirect(Util.base_url1+"dashboard.jsp");

        }


    }
}
