package services;

import dataaccess.UserDB;
import java.util.List;
import models.Role;
import models.User;


public class UserService {
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, boolean active, String firstName, String lastName, String password,
            int roleID) throws Exception {
        Role role = new Role(roleID, null);
        User user = new User(email, active, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        userDB.insert(user);
    }
    
    public void update(String email, boolean active, String firstName, String lastName, String password,
            int roleID) throws Exception {
        Role role = new Role(roleID, null);
        User user = new User(email, active, firstName, lastName, password, role);
        UserDB userDB = new UserDB();
        
        userDB.update(user);
    }
    
    public void delete(String email) throws Exception {
        User user = new User();
        user.setEmail(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}
