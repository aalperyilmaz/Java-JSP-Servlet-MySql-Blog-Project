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

@WebServlet(name = "passwordChangeServlet" , value = "/pass-change")
public class PasswordChangeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cidx=Integer.parseInt(req.getParameter("cidx"));
        req.getSession().setAttribute("updateCidx",cidx);
        DBUtil util=new DBUtil();
        Admin blog=util.singleAdmin(cidx);
        req.setAttribute("blog",blog);
        RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Pchange.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        boolean cidxStatus=req.getSession().getAttribute("updateCidx")!=null;
        if (cidxStatus){
            String oldPass=req.getParameter("oldPass");
            String newPass=req.getParameter("newPass");
            int aid=(int) req.getSession().getAttribute("updateCidx");
            DBUtil util=new DBUtil();
            boolean status=util.changePassword(oldPass,newPass,aid);
            req.getSession().removeAttribute("updateCidx");


        }
        resp.sendRedirect("password-change.jsp");

    }
}

