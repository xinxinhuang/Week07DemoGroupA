package dataaccess;

import domainmodel.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {

    public int insert(User user) throws NotesDBException, SQLException {
       ConnectionPool cp= ConnectionPool.getInstance();
       Connection connection = cp.getConnection();
        String query = "UPDATE Users SET " +
        "id = '" + user.getId() + "', " +
        "firstname = '" + user.getFirstname()+ "', " +
         "lastname = '" + user.getLastname()+ "', " + 
                "email = '" + user.getEmail()+ "', " +
                 "password = '" + user.getPassword()+ "', " +
                 "SIN = '" + user.getSIN()+ "', " ;
               
        Statement statement = connection.createStatement();
        
        int rowCount = statement.executeUpdate(query);
        cp.freeConnection(connection);
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
    
    public int delete(User user) throws NotesDBException {
        return 0;
    }
}
