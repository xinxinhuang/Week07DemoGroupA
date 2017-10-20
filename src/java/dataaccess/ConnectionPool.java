package dataaccess;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;


/**
 * Creates a connection for the user.
 * Once the connection is finished free itself to allow
 *  another user to connect to database.
 * @author Meda, Bao
 */
public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;

    /**
     * Default constructor for opening the connection to the database.
    */
    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) 
                ic.lookup("java:/comp/env/jdbc/NoteDB.sql");
        } catch (NamingException e) {
            System.out.println(e);
        }

    }

    /**
     * Creates a new ConnectionPool object if there isn't one already initialized.
     * @return pool initialized ConnectionPool
     */
    public static synchronized ConnectionPool getInstance() {
        if(pool==null)
        {
            pool = new ConnectionPool();
        }
        return pool;
    }

    /**
     * Attempts to establish a connection with the data source that
     * this {@code DataSource} object represents
     * @return DataSource object to the database if possible, returns null if unable to connect.
     */
    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        }

    }

    /**
     * Releases Connection object's database and JDBC resources
     * immediately instead of waiting for them to be automatically released.
     * @param c ConnectionPool Object to be released
     */
    public void freeConnection(Connection c) {
                try {
            c.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}