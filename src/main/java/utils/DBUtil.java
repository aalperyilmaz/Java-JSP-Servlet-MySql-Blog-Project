package utils;

import org.jcp.xml.dsig.internal.dom.Utils;
import props.Admin;
import props.Blog;
import props.Contact;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {


        public boolean login(String email, String password, String remember, HttpServletRequest req, HttpServletResponse resp) {
            boolean status = false;
            DB db = new DB();
            try {
                String sql = "select * from admin where email = ? and password = ?";
                PreparedStatement pre = db.conn.prepareStatement(sql);
                pre.setString(1, email);
                pre.setString(2, Util.MD5(password) );
                ResultSet rs = pre.executeQuery();
                status = rs.next();

                if ( status ) {
                    // session create
                    int aid = rs.getInt("aid");
                    String name = rs.getString("name");

                    req.getSession().setAttribute("aid", aid);
                    req.getSession().setAttribute("name", name);

                    // cookie create - 10_ali
                    if ( remember != null && remember.equals("on")) {
                        name = name.replaceAll(" ", "_");
                        String val = aid+"_"+name;
                        Cookie cookie = new Cookie("user", val);
                        cookie.setMaxAge( 60*60 );
                        resp.addCookie(cookie);
                    }


                }

            } catch (Exception e) {
                System.err.println("login Error : " + e);
            }finally {
                db.close();
            }
            return status;
        }


    public int BlogInsert(Blog blog, int cidx) {
        int status = 0;
        DB db = new DB();

        try {
            String sql = "insert into content values(null,?,?,?)";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, blog.getTitle());
            pre.setString(2, blog.getDetail());
            pre.setInt(3, cidx);
            status = pre.executeUpdate();


        } catch (Exception e) {
            if (e.toString().contains("SQLIntegrityConstraintViolationException")) {
                status = -1;
            }
            System.err.println("productInsert Error : " + e);
        } finally {
            db.close();
        }

        return status;
    }

    //blog list
    public List<Blog> blogList(int aid) {
        List<Blog> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from content where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int cidx = rs.getInt("cidx");
                String title = rs.getString("title");
                String detail = rs.getString("detail");
                Blog blog = new Blog(cidx, title, detail);
                ls.add(blog);
            }


        } catch (Exception e) {
            System.out.println("list error" + e);
        } finally {
            db.close();
        }

        return ls;
    }

    //////////// Content için blog list
    public List<Blog> allBlogList() {
        List<Blog> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from content ";
            PreparedStatement pre = db.conn.prepareStatement(sql);

            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int cidx = rs.getInt("cidx");
                String title = rs.getString("title");
                String detail = rs.getString("detail");
                Blog blog = new Blog(cidx, title, detail);
                ls.add(blog);
            }


        } catch (Exception e) {
            System.out.println("list error" + e);
        } finally {
            db.close();
        }

        return ls;
    }


    //////////

    public int blogDelete(int cidx) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "delete from content where cidx=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, cidx);
            status = pre.executeUpdate();

        } catch (Exception e) {
            System.err.println("blogDelete Error :  " + e);
        } finally {
            db.close();
        }
        return status;
    }

    public boolean blogIsValid(int cidx, int aid) {
        boolean status = false;

        DB db = new DB();

        try {
            String sql = "select*from content where cidx=? and aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, cidx);
            pre.setInt(2, aid);
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            System.out.println("isBlogVaild Error :" + e);
        } finally {
            db.close();
        }

        return status;

    }

    public Blog singBlog(int cidx) {
        Blog blog = new Blog();
        DB db = new DB();


        try {
            String sql = "select * from content where cidx=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, cidx);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int cidxx = rs.getInt("cidx");
                String title = rs.getString("title");
                String detail = rs.getString("detail");
                blog = new Blog(cidxx, title, detail);
                return blog;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return blog;
    }

    public int updateBlog(String title, String detail, int cidx) {
        int status = 0;
        DB db = new DB();
        System.out.println("update çalıştı ");

        try {
            String sql = "update content set title= ?,detail= ?  where cidx= ? ";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, title);
            pre.setString(2, detail);
            pre.setInt(3, cidx);
            status = pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("Update Error" + e);
        } finally {
            db.close();
        }
        return status;

//////////////////////////////////////////----Contact-Db-Connections----///////////////////////////////////////////////////////////////
    }

    public int adminInsert(Admin admin, int cid) {
        int status = 0;
        DB db = new DB();

        try {
            String sql = "insert into contact values(null,?,?)";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, admin.getName());
            pre.setString(2, admin.getEmail());
            status = pre.executeUpdate();


        } catch (Exception e) {
            if (e.toString().contains("SQLIntegrityConstraintViolationException")) {
                status = -1;
            }
            System.err.println("contact Insert Error : " + e);
        } finally {
            db.close();
        }

        return status;
    }


    public List<Admin> adminList(int aid) {
        List<Admin> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from admin where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                aid = rs.getInt("aid");

                String name = rs.getString("name");
                String email = rs.getString("email");
                Admin admin = new Admin(aid, name, email);
                ls.add(admin);
            }


        } catch (Exception e) {
            System.out.println("Admin list error" + e);
        } finally {
            db.close();
        }

        return ls;
    }


    public int adminDelete(int aid) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "delete from admin where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            status = pre.executeUpdate();

        } catch (Exception e) {
            System.err.println("contactDelete Error :  " + e);
        } finally {
            db.close();
        }
        return status;
    }


    public Admin singleAdmin(int aid) {
        Admin admin = new Admin();
        DB db = new DB();


        try {
            String sql = "select * from admin where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                aid = rs.getInt("aid");
                String name = rs.getString("name");
                String email = rs.getString("email");

                admin = new Admin(aid, name, email);
                return admin;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return admin;
    }

    public int updateContact(String email, String name, int aid) {
        int status = 0;
        DB db = new DB();
        System.out.println("Contentupdate çalıştı ");

        try {
            String sql = "update contact set  name= ?, email= ?  where aid= ? ";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, name);
            pre.setString(2, email);
            pre.setInt(3, aid);
            status = pre.executeUpdate();

        } catch (Exception e) {
            System.out.println("content Update Error" + e);
        } finally {
            db.close();
        }
        return status;


    }


    public List<Contact> contactList(int aid) {
        List<Contact> ls = new ArrayList<>();
        DB db = new DB();
        try {
            String sql = "select * from contact where  aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int cid = rs.getInt("aid");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Contact cnt = new Contact(name, email, cid,aid);
                ls.add(cnt);
            }


        } catch (Exception e) {
            System.out.println("list error" + e);
        } finally {
            db.close();
        }

        return ls;
    }
//////////////////////fulll contact list
public List<Contact> fullContactList() {
    List<Contact> ls = new ArrayList<>();
    DB db = new DB();
    try {
        String sql = "select * from contact ";
        PreparedStatement pre = db.conn.prepareStatement(sql);

        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            int cid = rs.getInt("aid");
            String name = rs.getString("name");
            String email = rs.getString("email");
            Contact cnt = new Contact(name, email, cid);
            ls.add(cnt);
        }


    } catch (Exception e) {
        System.out.println("list error" + e);
    } finally {
        db.close();
    }

    return ls;
}




    ///////////////////////////////////////// Change Passs/////////////////////////////////////////////
    //Change Pass
    public boolean changePassword( String oldPass, String newPass,int aid) {
        DB db = new DB();
        boolean status = false;
          int st=0;
        try {
            String sql1 = "update admin set password =? where password = ? and  aid=?";
            PreparedStatement prep = db.conn.prepareStatement(sql1);
            prep.setString(1, Util.MD5(newPass));
            prep.setString(2, Util.MD5(oldPass));
            prep.setInt(3, aid);
            st = prep.executeUpdate();
            System.out.println(prep);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return status;
    }








    public Contact singleContact( int aid) {
       Contact cnt=new Contact();
        DB db = new DB();


        try {
            String sql = "select * from contact where aid=?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setInt(1, aid);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                int cid=rs.getInt("cid");
                aid = rs.getInt("aid");
                 String name = rs.getString("name");
                 String email = rs.getString("email");

                 cnt = new Contact(name, email,aid);
                return cnt;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return cnt;
    }

}
