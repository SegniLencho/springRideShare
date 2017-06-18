package guru.springframework.controllers;

import guru.springframework.domain.*;
import guru.springframework.repositories.PostDao;
import guru.springframework.services.PostService;
import guru.springframework.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;
 private PostService postService;
 private PostDao dao;

 @Autowired
    public void setDao(PostDao dao) {
        this.dao = dao;
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

    @RequestMapping("/askRide")
    public String veiwride(Model model) {
        model.addAttribute("post", new Post());
        return "askRide";
    }

    @RequestMapping(value = "/askRide", method = RequestMethod.POST)
    public String createridePost(Post post1) {
//        model.addAttribute("posts", new  Post());
        Date date = new Date(12 / 12 / 1234);
        post1.setDateCreated(date);
        post1.setPostText("some text");
        post1.setPostType("d");
        Post post12=new Post("sefni","Name of k");

//        Iterable<Post> daopos=dao.findAll();
//        System.out.println(daopos.iterator().next().getId()+"----<");
        Post post=postService.savePost(post12);
        System.out.println("Post if "+ post.getPostText());

        System.out.println("Post is created Successfully------<>");
        return "askRide";
    }

    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {

        productService.saveProduct(product);

        return "redirect:/product/" + product.getId();
    }
}