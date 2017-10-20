package businesslogic;

import dataaccess.NotesDBException;
import domainmodel.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    
    public User get(String username) throws Exception {
        return null;
    }

    public List<User> getAll() throws NotesDBException, SQLException {
        List<User> userList = null;
        
        int id;
        String firstname;
        String lastname;
        String email;
        String password;
        String sin;
        
        String preparedSql="SELECT * FROM Users";
        PreparedStatement ps =connection.prepareStatement(preparedSql);
        
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
           
            id=Integer.parseInt(rs.getString("id"));
            firstname=rs.getString("firstname");
            lastname=rs.getString("lastname");
            email=rs.getString("email");
            password=rs.getString("password");
            sin=rs.getString("SIN");
            User u = new User(id,firstname,lastname,email,password,sin);
           
            userList.add(u);
        }
        
        return userList;
    }

    public int update(String username, String password, ... [more parameters]) throws Exception {
        return 0;
    }

    public int delete(String username) throws Exception {
        return 0;
    }

    public int insert(String username, String password, ... [more parameters]) throws Exception {
        return 0;
    }

}
