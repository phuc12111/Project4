package com.controllers;

import com.models.Albumdetails;
import com.models.Albums;
import com.models.Favourites;
import com.servlets.AlbumdetailsDAO;
import com.servlets.AlbumdetailsDAOiml;
import com.servlets.AlbumsDAO;
import com.servlets.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.dao.EmptyResultDataAccessException;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping(value = "albums")
public class AlbumsController {

    @Autowired
    private AlbumsDAO albumsDAO;

    @Autowired
    private LoginDAO loginDAO;
    
    @Autowired
    private AlbumdetailsDAO  albumdetailsDAO;

    @GetMapping("view/{phone}")
    public String viewAllAlbums(ModelMap mm, HttpSession session, @PathVariable("phone") String phone) {
        try {
            com.models.Login user = loginDAO.findByUser(phone);
            if (user == null) {
                mm.addAttribute("message", "You are have not yet login!");
                return "albums"; // Redirect to the favourites page with a message
            } else {
                List<Albums> albumsList = albumsDAO.selectAlbums(phone);
                mm.addAttribute("albumsList", albumsList);
                session.setAttribute("login", user);
                return "albums";
            }
        } catch (EmptyResultDataAccessException e) {
            mm.addAttribute("message", "User not found or no album found.");
            return "albums"; // Redirect to the favourites page with an error message
        }
    }
    
     @GetMapping("viewdeatail/{albumID}")
    public String viewDetailAlbums(ModelMap mm, HttpSession session, @PathVariable("albumID") int albumID) {
        List<Albumdetails> albumsListde = albumdetailsDAO.selectAlbumDetails(albumID);
                mm.addAttribute("albumsListde", albumsListde);
                return "albumsde";
    }

    
    @PostMapping("add")
    public String addAlbum(Model model, @ModelAttribute("album") Albums album, HttpSession session) {
        albumsDAO.addAlbum(album);
        List<Albums> albums = albumsDAO.findAllAlbums();
        model.addAttribute("albums", albums);
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);

            model.addAttribute("login", login);

        }
        return "albums";
    }

    
    @PostMapping("adddetail")
public String addAlbumDetail(Model model, @ModelAttribute("albumdetails") Albumdetails albumdetails, HttpSession session) {
    albumdetailsDAO.addAlbumDetails(albumdetails);

    // Retrieve login information from session
    com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
    if (sessionLogin != null) {
        String phone = sessionLogin.getPhone();
        com.models.Login login = loginDAO.findByUser(phone);
        model.addAttribute("login", login);
    }
    return "index"; // Redirect to albums page after adding album details
}


    // Show form to update an existing album
    @GetMapping("/update/{albumID}")
    public String showUpdateAlbumForm(@PathVariable("albumID") int albumID, Model model) {
        Albums album = albumsDAO.findAlbumById(albumID);
        model.addAttribute("album", album);
        return "updateAlbum";
    }

    // Update an existing album
    @PostMapping("/update")
    public String updateAlbum(@ModelAttribute("album") Albums album) {
        albumsDAO.updateAlbum(album);
        return "redirect:/albums/view";
    }

    // Delete an album
    @GetMapping("/delete/{albumID}")
    public String deleteAlbum(@PathVariable("albumID") int albumID) {
        albumsDAO.deleteAlbum(albumID);
        return "redirect:/albums/view";
    }

    // Find an album by ID
    @GetMapping("/find/{albumID}")
    public String findAlbumById(@PathVariable("albumID") int albumID, Model model) {
        Albums album = albumsDAO.findAlbumById(albumID);
        model.addAttribute("album", album);
        return "viewAlbum";
    }
}
