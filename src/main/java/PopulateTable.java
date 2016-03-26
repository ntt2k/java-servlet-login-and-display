import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
 
 
@WebServlet("/PopulateTable")
public class PopulateTable extends HttpServlet {
 private static final long serialVersionUID = 1L;
 
    public PopulateTable() {
         
    }
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
      System.out.println("DEBUG 1");
      ArrayList<Employee> employees = new ArrayList<Employee>();
      employees = LoginDao.getAllEmployees();
      Gson gson = new Gson();
      JsonElement element = gson.toJsonTree(employees, new TypeToken<List<Employee>>() {}.getType());
       
      JsonArray jsonArray = element.getAsJsonArray();
      response.setContentType("application/json");
      response.getWriter().print(jsonArray);
      System.out.println("DEBUG 2");
 }
 
  
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// nothing here
    }
 
}