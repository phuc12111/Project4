package com.servlets;

import com.models.Admins;
import java.util.List;

public interface AdminDAO {
    void add(Admins admin);
    void change(Admins admin);
    Admins get(String id);
    void delete(String id);
    List<Admins> findAll();
    List<Admins> find(String keyword);
     public void update(Admins admin);
}