import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoginDao {
	
	private static Connection connection = null;
    
	public static boolean validate(String name, String pass) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost/";
        String dbName = "COMPOSITEAPPS";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "mysqluser";
        String password = "mysqlpassword";

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("SELECT * FROM EMPLOYEES WHERE USERNAME=? and PASSWORD=?");
            pst.setString(1, name);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            status = rs.next();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
        	if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return status;
    }
	
	// Create permanent connection
	public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
            	String url = "jdbc:mysql://localhost/";
                String dbName = "COMPOSITEAPPS";
                String driver = "com.mysql.jdbc.Driver";
                String userName = "mysqluser";
                String password = "mysqlpassword";
                
                Class.forName(driver);
                connection = DriverManager.getConnection(url + dbName, userName, password);
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
    }
	
	public static ArrayList<Employee> getAllEmployees() {
	     
		 connection = LoginDao.getConnection();   
	     ArrayList<Employee> employeeList = new ArrayList<Employee>();
	        
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet rs = statement.executeQuery("SELECT * FROM EMPLOYEES LIMIT 100");

	            while(rs.next()) {
	             
	            	Employee empl = new Employee();             
	                empl.setEmployeeID(rs.getInt("EMPLOYEE_ID"));
	                empl.setName(rs.getString("NAME"));
	                empl.setPhone(rs.getString("PHONE_NUMBER"));
	                empl.setSupervisor(rs.getString("SUPERVISORS"));
	                empl.setUsername(rs.getString("USERNAME"));
	                empl.setPassword(rs.getString("PASSWORD"));
	                employeeList.add(empl);
	            }
	        } 
	        
	        catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return employeeList;
	    }
}