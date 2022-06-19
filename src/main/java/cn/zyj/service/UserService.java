package cn.zyj.service;

import cn.zyj.bean.User;
import cn.zyj.dao.UserDao;

public class UserService {

    UserDao userDao = new UserDao();

    public User login(String username, String password) {

        User login = userDao.login(username, password);

        return login;

    }
}
