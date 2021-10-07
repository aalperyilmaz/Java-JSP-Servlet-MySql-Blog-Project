package servlets;

import utils.DBUtil;
import utils.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "contactUpdateServlet",value = "/contact-edit")
public class ContactUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");

        boolean cidxStatus=req.getSession().getAttribute("aid")!=null;
        if (cidxStatus){
            String name=req.getParameter("name");
            String email=req.getParameter("email");
            int cidx=(int) req.getSession().getAttribute("aid");
            DBUtil util=new DBUtil();
            int status=util.updateContact(email,name,cidx);
            req.getSession().removeAttribute("aid");


        }
        resp.sendRedirect(Util.base_url1+"contact-update.jsp");

    }

}
