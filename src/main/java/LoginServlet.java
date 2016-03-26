
import java.io.IOException;
//import java.io.PrintWriter;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{  

    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
    		throws ServletException, IOException {
        		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String n = request.getParameter("name");
        String p = request.getParameter("password");


        if(LoginDao.validate(n, p)){
        	
//            RequestDispatcher rd = request.getRequestDispatcher("todo.jsp");
//            rd.forward(request,response);
        	request.getSession().setAttribute("name",n);
        	response.sendRedirect("/homepage.do");
        }
        else{
        	
            request.setAttribute("errorMessage", "Invalid Credentials!");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
                    request, response);
        }

    }
}
