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

@WebServlet(name = "blog-update",value = "/blog-update")
public class BlogUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cidx=Integer.parseInt(req.getParameter("cidx"));
        req.getSession().setAttribute("updateCidx",cidx);
        DBUtil util=new DBUtil();
        Blog blog=util.singBlog(cidx);
        req.setAttribute("blog",blog);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/blog-update.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        boolean cidxStatus=req.getSession().getAttribute("updateCidx")!=null;
        if (cidxStatus){
            String title=req.getParameter("title");
            String detail=req.getParameter("detail");
            int cidx=(int) req.getSession().getAttribute("updateCidx");
            DBUtil util=new DBUtil();
            int status=util.updateBlog(title,detail,cidx);
            req.getSession().removeAttribute("updateCidx");


        }
        resp.sendRedirect(Util.base_url1+"dashboard.jsp");

    }
}
