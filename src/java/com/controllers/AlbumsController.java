package com.controllers;

import com.models.Albumdetails;
import com.models.Albums;
import com.models.Categories;
import com.models.Favourites;
import com.models.Product;
import com.servlets.AlbumdetailsDAO;
import com.servlets.AlbumdetailsDAOiml;
import com.servlets.AlbumsDAO;
import com.servlets.CartDAO;
import com.servlets.CategoryDAO;
import com.servlets.LoginDAO;
import com.servlets.ProductDAO;
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
    private ProductDAO productDAO;
    @Autowired
    private ProductDAO productsDAO;
    @Autowired
    private AlbumsDAO albumsDAO;

    @Autowired
    private LoginDAO loginDAO;

    @Autowired
    private AlbumdetailsDAO albumdetailsDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private CartDAO cartDAO;

    @GetMapping("view/{phone}")
    public String viewAllAlbums(ModelMap mm, HttpSession session, @PathVariable("phone") String phone) {
        try {
            com.models.Login user = loginDAO.findByUser(phone);
            if (user == null) {
                mm.addAttribute("message", "You are have not yet login!");
                return "albums"; // Redirect to the favourites page with a message
            } else {
                List<com.models.Categories> cate = categoryDAO.findAll();
                mm.addAttribute("cate", cate);
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
    public String viewDetailAlbums(ModelMap model, HttpSession session, @PathVariable("albumID") int albumID) {
        List<Albumdetails> albumsListde = albumdetailsDAO.selectAlbumDetails(albumID);
        model.addAttribute("albumsListde", albumsListde);
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);
            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            model.addAttribute("albumsList", albumsList);
            model.addAttribute("login", login);
            List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
        }

        return "albumsde";
    }

    @PostMapping("add")
    public String addAlbum(Model model, @ModelAttribute("album") Albums album, HttpSession session) {
        albumsDAO.addAlbum(album);

        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);
            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            model.addAttribute("albumsList", albumsList);
            model.addAttribute("login", login);
            List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
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

            List<com.models.Product> listPro = productDAO.findAll();
            model.addAttribute("listPro", listPro);

            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            model.addAttribute("albums", albumsList);

            model.addAttribute("login", login);

            List<com.models.Categories> cate = categoryDAO.findAll();
            model.addAttribute("cate", cate);
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
    @GetMapping("delete/{phone}/{albumID}")
    public String deleteAlbum(ModelMap mm, @PathVariable("phone") String phone, @PathVariable("albumID") int albumID) {
        com.models.Login user = loginDAO.findByUser(phone);
        if (user == null) {
            mm.addAttribute("message", "User not found. Please log in.");
            return "albums";
        }

        albumsDAO.deleteAlbum(albumID);
        // After deletion, retrieve the updated list of favourites
        List<Albums> albumsList = albumsDAO.selectAlbums(phone);
        mm.addAttribute("albumsList", albumsList);
        mm.addAttribute("successfully", "Album item deleted successfully!");
        List<com.models.Categories> cate = categoryDAO.findAll();
        mm.addAttribute("cate", cate);

        return "albums";
    }

    // Find an album by ID
    @GetMapping("/find/{albumID}")
    public String findAlbumById(@PathVariable("albumID") int albumID, Model model) {
        Albums album = albumsDAO.findAlbumById(albumID);
        model.addAttribute("album", album);
        return "viewAlbum";
    }

    @RequestMapping(value = "viewProducts/{albumID}", method = RequestMethod.GET)
    public String viewProducts(@PathVariable("albumID") int albumID, ModelMap model) {
        List<Albumdetails> products = productsDAO.getProductDetails(albumID);
        model.addAttribute("products", products);
        List<com.models.Categories> cate = categoryDAO.findAll();
        model.addAttribute("cate", cate);
        return "albumsde"; // Tên của trang JSP để hiển thị danh sách sản phẩm
    }

    @PostMapping("adddetailcate")
    public String addAlbumDetailcate(Model model, @ModelAttribute("albumdetails") Albumdetails albumdetails, @RequestParam("categoryID") int categoryID, HttpSession session) {
        albumdetailsDAO.addAlbumDetails(albumdetails);

        // Retrieve login information from session
        com.models.Login sessionLogin = (com.models.Login) session.getAttribute("login");
        if (sessionLogin != null) {
            String phone = sessionLogin.getPhone();
            com.models.Login login = loginDAO.findByUser(phone);

            List<com.models.Product> listPro = productDAO.findAll();
            model.addAttribute("listPro", listPro);

            List<Albums> albumsList = albumsDAO.selectAlbums(phone);
            model.addAttribute("albums", albumsList);

            model.addAttribute("login", login);
 List<Product> pro = categoryDAO.findAllpro(categoryID);
        model.addAttribute("pro", pro);
        }
        
        return "detailCategory"; // Redirect to albums page after adding album details
    }
}
