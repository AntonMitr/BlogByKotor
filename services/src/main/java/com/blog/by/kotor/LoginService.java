package com.blog.by.kotor;

public class LoginService {

    public boolean loginBool(String email, String password) {
        boolean result = true;
        UserDAO userDAO = new UserDAO();

        if (userDAO.findByEmail(email) && userDAO.findByPassword(password)) {
            System.out.println("Добро пожаловать!");
        } else {
            System.out.println("Неправильный логин или пароль!");
            result = false;
        }
        return result;
    }

}
