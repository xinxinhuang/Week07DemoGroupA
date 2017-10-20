package dataaccess;

import domainmodel.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {
    private static String username="root";
    private static String password="password";
    private static String dbURL="jdbc:mysql://localhost:3306/";
    private Connection connection=null;
    
    public UserDB()
    {
        try {
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int insert(User user) throws NotesDBException, SQLException {
        
        String query = "UPDATE Users SET " +
        "id = '" + user.getId() + "', " +
        "firstname = '" + user.getFirstname()+ "', " +
         "lastname = '" + user.getLastname()+ "', " + 
                "email = '" + user.getEmail()+ "', " +
                 "password = '" + user.getPassword()+ "', " +
                 "SIN = '" + user.getSIN()+ "', " ;
               
        Statement statement = connection.createStatement();
        int rowCount = statement.executeUpdate(query);
        
        return rowCount;
    }

    public int update(User user) throws NotesDBException {
        return 0;
    }

    public List<User> getAll() throws NotesDBException {
        return null;
    }

    public User getUser(String username) throws NotesDBException {
        return null;
    }

    public User getUserById(int id) throws NotesDBException {
        return null;
    }
    
    public int delete(User user) throws NotesDBException, SQLException {
        String deleteQuery = "DELETE FROM USERS " 
                               +  "WHERE ID = ?";
        
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        
        ps.setInt(1, user.getId());
        int rowAffected = ps.executeUpdate();
        return rowAffected;
    }
}
