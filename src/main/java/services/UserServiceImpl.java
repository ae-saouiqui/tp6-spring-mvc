package services;

import dao.UserDAO;
import entities.User;

public class UserServiceImpl  implements UserService{
    private UserDAO dao;

    
    public UserServiceImpl(UserDAO dao) {
        this.dao = dao;
    }


    @Override
    public User login(String username, String password) {
            User user = dao.findByUsernameAndPassword(username, password);
            return user;
}
}
