/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.controllers;

import com.models.Albums;
import com.models.Artists;
import com.models.ProductWithArtist;
import com.servlets.AlbumsDAO;
import com.servlets.ArtistDAO;
import com.servlets.CategoryDAO;
import com.servlets.LoginDAO;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("artists")
public class ArtistController {
    @Autowired
    private CategoryDAO categoryDAO;
     @Autowired
    private AlbumsDAO albumsDAO;
     @Autowired
    private LoginDAO loginDAO;
    @Autowired
    private ArtistDAO artistDAO;
    

 @GetMapping("/list")
public String listArtists(ModelMap mm, HttpSession session) {
     List<Artists> artists = artistDAO.getAllArtists();
     mm.addAttribute("artists", artists);
     List<com.models.Categories> categories = categoryDAO.findAll();
     mm.addAttribute("cate", categories);
    
        return "artist"; // Redirect to the artist page with an error message
    
}


    @GetMapping("add")
    public String showAddForm(ModelMap model) {
        model.addAttribute("artist", new Artists());
        return "artist_form"; // Name of the JSP page to display the form for adding a new artist
    }

    @PostMapping("add")
    public String addArtist(@ModelAttribute("artist") Artists artist) {
        artistDAO.addArtist(artist);
        return "redirect:/artists/list";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") int artistID, ModelMap model) {
        Artists artist = artistDAO.getArtistById(artistID);
        model.addAttribute("artist", artist);
        return "artist_form"; // Reuse the same form for editing an artist
    }

    @PostMapping("edit")
    public String editArtist(@ModelAttribute("artist") Artists artist) {
        artistDAO.updateArtist(artist);
        return "redirect:/artists/list";
    }

    @GetMapping("delete/{id}")
    public String deleteArtist(@PathVariable("id") int artistID) {
        artistDAO.deleteArtist(artistID);
        return "redirect:/artists/list";
    }
    
     @GetMapping("artists/{artistID}")
    public String getProductsByArtistId(@PathVariable int artistID, Model model) {
         List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
        List<ProductWithArtist> products = artistDAO.getProductsByArtistId(artistID);
        model.addAttribute("products", products);
        Artists as = artistDAO.getArtistById(artistID);
        model.addAttribute("as", as);
        return "artistde"; // Assuming you have a view named "products.jsp" to display the products
        
    }
    
}
