package guru.springframework.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import guru.springframework.domain.*;
import guru.springframework.repositories.PostDao;
import guru.springframework.services.PostService;
import guru.springframework.services.ProductService;
import guru.springframework.services.UserService;
import javafx.geometry.Pos;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes(names = "name")
public class ProductController {

    private ProductService productService;
    private PostService postService;
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("products", productService.listAllProducts());
        System.out.println("Returning rpoducts:");
        return "products";
    }

    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productshow";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "productform";
    }

    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {

        //productService.saveProduct(product);

        return "redirect:/product/" + product.getId();
    }

    //Ride application
    @RequestMapping("/askRide")
    public String veiwride(Model model) {
        model.addAttribute("post", new Post());
        return "askRide";
    }


    @RequestMapping(value = "/askRide", method = RequestMethod.POST)
    public String createridePost(Post post1, Model model) {
        Date date = new Date(12 / 12 / 1234);
        post1.setDateCreated(date);
        post1.setPostText(post1.getPostText());
        post1.setPostType("d");
        Post post = postService.savePost(post1);
        System.out.println("Post is created Successfully------<>");
        model.addAttribute("posts", postService.listAllPost());
        return "redirect:/post";
    }

    //Display list of post
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String getallPost(Post post, Model model) {
        model.addAttribute("posts", postService.listAllPost());
        System.out.println("Returning Allpost:");
        return "posts";
    }
    @RequestMapping("/register")
    public String signUp(User user,Address address, Model model) {
//        System.out.println(user.getFirstName()+ "---First Name is gotten");
        model.addAttribute("user", new User());
        model.addAttribute("address",new Address());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(User user, Address address, ModelMap modelMap) {
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("address",address);
        user.setAddress(address);

      List<Post> posts=new ArrayList<Post>();
        posts.add(new Post());
        posts.add(new Post());

        user.setPosts(posts);

        userService.saveUser(user);
        System.out.println("USer registered successfully-----END" +user.getUsername());
        modelMap.addAttribute("name",user.getUsername());


        return "redirect:/post";
    }
}