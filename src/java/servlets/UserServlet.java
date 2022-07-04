package servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.UserService;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserService userService = new UserService();
            try {
                request.setAttribute("userlist", userService.getAll());
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String password = request.getParameter("password");
        
        
       if(email != null && fname != null && lname != null && password != null) {
           UserService userService = new UserService();
            try {
                int roleID = Integer.parseInt(request.getParameter("roleID"));
                userService.insert(email, true, fname, lname, password, roleID);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
        String email2 = request.getParameter("email2");
        String fname2 = request.getParameter("fname2");
        String lname2 = request.getParameter("lname2");
        String password2 = request.getParameter("password2");
        
        
       if(email2 != null && fname2 != null && lname2 != null && password2 != null) {
           UserService userService = new UserService();
            try {
                int roleID2 = Integer.parseInt(request.getParameter("roleID2"));
                userService.update(email2, true, fname2, lname2, password2, roleID2);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       
        String email3 = request.getParameter("email3");

        
       if(email3 != null) {
           UserService userService = new UserService();
            try {
                userService.delete(email3);
            } catch (Exception ex) {
                Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
       UserService userService = new UserService();
       try {
            request.setAttribute("userlist", userService.getAll());
        } catch (Exception ex) {
            Logger.getLogger(UserServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request,response);
      
    }

}
