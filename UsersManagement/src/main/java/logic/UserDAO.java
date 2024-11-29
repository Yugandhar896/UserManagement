package logic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserDAO {

	 public static String url = "jdbc:mysql://localhost:3306/trx_jfsd_03"; // Change "mydatabase" to your database name
     public static String user = "root"; // Replace with your database username
     public static String password = "Yogi@2002"; // Replace with your database password

//	public static void main(String[] args) {
//		// System.out.println(UserJDBCDemo.getUserByIdUser(102));
//		// System.out.println(getAllUsersDetails());
//		//updateUsers();
//		//System.out.println(getUserByIdUser(105));
//	    // addUser();
//		UserDAO	g =new UserDAO();
//		System.out.println(g.getAllUsersDetails());
//		System.out.println(g.getUserByIdUser(2));
//		System.out.println(g.searchUser("yugandhar@gmail.com", "yugandhar@896",g.getAllUsersDetails()));
//		
//
//		
//	}
	
	// To get all users list
	public  static List<User> getAllUsersDetails() {
    	
    	List<User> sl =  new ArrayList<>();
    	// Try to connect to the database and fetch student data
    	Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // Step 1: Establish a connection
        	connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

         // Step 2: Create a statement
            statement  = connection.createStatement();

            // Step 3: Execute a query to retrieve all students
            String sql = "SELECT * FROM user";
            resultSet  = statement.executeQuery(sql);
            User s =null;
            // Step 4: Process the result set
            while (resultSet.next()) {
                 int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                s = new User(id,name,username,password);
                sl.add(s);
            }return sl ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	if (resultSet != null) resultSet.close();
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
		return null ;
    }



	//For getting user by id in tostring format 
	public static  User getUserById(int userId) {
    	// JDBC URL, username, and password of MySQL server
       
        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // 1. Open a connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String query = "SELECT * FROM user  where user_id="+userId;
            
            resultSet = statement.executeQuery(query);
            
            // 4. Process the ResultSet object
            User u = null ;
            if(resultSet.next()) {
                // Assume mytable has columns id (int) and name (String)
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String username= resultSet.getString("username");
                String Password= resultSet.getString("password");
                
                u= new User(id ,name,username,Password);
                
            }return u ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	if (resultSet != null) resultSet.close();
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
		return null ;
    }
	
	 //For adding user
    public static boolean addUser(String name,String username,String pass) {
//    	Scanner sc =new Scanner(System.in);
//    	System.out.println("Enter user id ");
//    	int id= sc.nextInt();
//    	System.out.println("Enter a new name");
//    	String name = sc.next();
//    	System.out.println("Enter a new username");
//    	String username = sc.next();
//    	System.out.println("Enter a new password");
//    	String pass = sc.next();
    	
        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        int rows =0 ;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query                                                                                                              
            String sql = "INSERT INTO user (name,username,password)  VALUES ('"+ name +"','"+ username +"','"+pass+"')";
            
            
            rows = statement.executeUpdate(sql);

            // 4. Process the ResultSet object
            if(rows!=0) {
            	return true;
            }else {
            	return false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 5. Close the resources
            try {
            	
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		return false;
    }
    
    
    //For updating user from db
    public  static boolean updateUsers(int id, String name, String username, String pass) {
    	
    	 
//    	Scanner sc =new Scanner(System.in);
//    	System.out.println("Enter user id of user to update");
//    	int Id= sc.nextInt();
//    	System.out.println("Enter a new password");
//    	String Pass = sc.next();
    	

        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        int rows = 0 ;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            // 1. Open a connection
            connection = DriverManager.getConnection(url, user, password);
            //System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String sql = "update user set name='"+name+"',username='"+username+"',password='"+pass+"' where user_id="+id;
            
            
            rows = statement.executeUpdate(sql);

            // 4. Process the ResultSet object
            if(rows!=0) {
            	return true;
            }else {
            	return false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
            
    }
	public  static boolean deleteUser(int id) {
		Connection connection = null;
        Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, password); 
			statement = connection.createStatement();
			String query = "Delete from user where user_id=" + id;
			int rows = statement.executeUpdate(query);
			if (rows != 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public static boolean validateUser(String username, String pass) {
	    Connection connection = null;
	    Statement statement = null;
	   // boolean isValid = false;
	    
	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection(url, user, password); 
	        statement = connection.createStatement();
	        
	        // Concatenate the username and password directly in the SQL query
	        String query = "SELECT * FROM user WHERE username = '" + username + "' and password = '" + pass + "'";
	        
	        ResultSet resultSet = statement.executeQuery(query);
	        
	        if (resultSet.next()) {
	            return true; // User found with matching username and password
	        }
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return false;
	}
	public  static User getUserByEmail(String username,String pass) {
    	// JDBC URL, username, and password of MySQL server
       
        // JDBC variables for opening and managing connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null ;
        try {
            // 1. Open a connection
        	Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established!");

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute a query
            String query = "SELECT * FROM user  where username='"+username+"' AND password='"+pass+"'";
            
            resultSet = statement.executeQuery(query);
            
            // 4. Process the ResultSet object
            User u = null ;
            if(resultSet.next()) {
                // Assume mytable has columns id (int) and name (String)
                int id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                 username= resultSet.getString("username");
                String Password= resultSet.getString("password");
                
                u= new User(id ,name,username,Password);
                
            }return u ;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5. Close the resources
            try {
            	if (resultSet != null) resultSet.close();
            	if (statement != null) statement.close();
                if (connection != null) connection.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
		return null ;
    }
	
	
	
}