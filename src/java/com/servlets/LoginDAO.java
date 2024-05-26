package com.servlets;

import com.models.Login;

public interface LoginDAO {
    Login login(String phone, String password);
     public Login findByUser(String phone);
     public Login findPhone(String phone);
}
