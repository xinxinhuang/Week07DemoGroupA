package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/users.jsp").forward(request, response);
        
            HttpSession sess = request.getSession();
            String action = (String) sess.getAttribute("action");
            
            if(action != null && action.equals("view")){
                //TODO what the hell is view
            }
            
             if(action != null && action.equals("delete")){
                
            }
             
              if(action != null && action.equals("add")){
                
            }
              
               if(action != null && action.equals("edit")){
                
            }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }
}
