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
        return null;
    }

    public int update(User user) throws Exception {
        return 0;
    }

    public int delete(String username) throws Exception {
        return 0;
    }

    public int insert(User user) throws Exception {
        return 0;
    }

}
