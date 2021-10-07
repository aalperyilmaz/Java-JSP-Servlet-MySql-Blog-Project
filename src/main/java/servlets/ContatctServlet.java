package servlets;

import props.Admin;
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

@WebServlet(name = "contatctServlet",value = "/contact-update")
public class ContatctServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cidx=Integer.parseInt(req.getParameter("cidx"));
        req.getSession().setAttribute("updateCidx",cidx);
        DBUtil util=new DBUtil();
        Admin admin=util.singleAdmin(cidx);
        req.setAttribute("admin",admin);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/contact-update.jsp");
        dispatcher.forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        boolean cidxStatus=req.getSession().getAttribute("updateCidx")!=null;
        if (cidxStatus){
            String title=req.getParameter("name");
            String detail=req.getParameter("email");
            int cidx=(int) req.getSession().getAttribute("updateCidx");
            DBUtil util=new DBUtil();
            int status=util.updateContact(title,detail,cidx);
            req.getSession().removeAttribute("updateCidx");


        }
        resp.sendRedirect(Util.base_url1+"contact-edit.jsp");
    }
}
