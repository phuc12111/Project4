package com.servlets;


import com.models.Admins;
import com.models.Login;

public interface LoginDAO {
    Login login(String phone, String password);
    Admins loginadmin(String adminID, String password);
     public Login findByUser(String phone);
     public Login findPhone(String phone);
     public Admins findByAdmin(String adminID);
}
