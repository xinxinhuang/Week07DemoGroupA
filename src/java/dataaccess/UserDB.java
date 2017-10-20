package dataaccess;

import domainmodel.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDB {

    public int insert(User user) throws NotesDBException, SQLException {

       ConnectionPool cp= ConnectionPool.getInstance();
       Connection connection = cp.getConnection();        
        String query = "INSERT INTO Users (id,firstname,lastname,email,password,SIN) " +
                    "VALUES ('" + user.getId() + "', " +
                    "'" + user.getFirstname() + "', " +
                    "'" + user.getLastname() + "', " +
                    "'" + user.getEmail()+ "', " +
                    "'" + user.getPassword() + "', " +
                    "'" + user.getSIN() + "')";

        Statement statement = connection.createStatement();

        int rowCount = statement.executeUpdate(query);
        cp.freeConnection(connection);
        return rowCount;
    }

    public int update(User user) throws NotesDBException {

        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        String preparedSQL = "UPDATE USERS SET "
                + "firstname=?,"
                + "lastname=?,"
                + "email=?,"
                + "password=?,"
                + "SIN=?"
                + "WHERE id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(preparedSQL);
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            ps.setString(1, user.getFirstname());
            ps.setString(2, user.getLastname());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getSIN());
            ps.setInt(6, user.getId());
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        int rows = -1;
        try {
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        pool.freeConnection(connection);

        return rows;

    }

    public List<User> getAll() throws NotesDBException {
        return null;
    }

 /**
     * An accessor method to retrieve a User object from the database with a
     * specified email address
     * 
     * @param email email address of the user to use for search
     * @return the User object with the specified email
     * @throws NotesDBException throws when the SQL query is not executed 
     * successfully
     */
    public User getUser(String email) throws NotesDBException 
    {
        String preparedSQL = "SELECT id, firstname, lastname, " 
                   + "email, password, sin "
                   + "FROM users WHERE email = ?";
        try 
        {
            ConnectionPool cp= ConnectionPool.getInstance();
            Connection connection = cp.getConnection();
            PreparedStatement ps = connection.prepareStatement(preparedSQL);
            ps.setString(1, email);
            ResultSet user = ps.executeQuery();
            cp.freeConnection(connection);
            return (User)user;
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User getUserById(int id) throws NotesDBException, SQLException {
        ConnectionPool cp= ConnectionPool.getInstance();
        Connection connection = cp.getConnection();
        User user;
        String searchById = "SELECT * FROM USERS "
                + "WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(searchById);
        ps.setInt(1, id);
        ResultSet user1 = ps.executeQuery();
        user = (User) user1;
        cp.freeConnection(connection);
        return user;
    }
   public int delete(User user) throws NotesDBException, SQLException {
        ConnectionPool cp= ConnectionPool.getInstance();
       Connection connection = cp.getConnection();
        String deleteQuery = "DELETE FROM USERS "
                + "WHERE ID = ?";
        PreparedStatement ps = connection.prepareStatement(deleteQuery);
        ps.setInt(1, user.getId());
        int rowAffected = ps.executeUpdate();
        cp.freeConnection(connection);
        return rowAffected;
    }
}
