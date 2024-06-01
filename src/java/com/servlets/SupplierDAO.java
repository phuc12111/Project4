/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servlets;

import com.models.Supplier;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SupplierDAO {
    public List<Supplier> findAll();
    public void add(Supplier supplier);
    public void update(Supplier supplier);
    public Supplier get(int id);
    public void delete(int id);
    public List<Supplier> find(String keyword);
}
