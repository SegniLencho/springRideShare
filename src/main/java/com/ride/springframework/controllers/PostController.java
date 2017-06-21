package com.ride.springframework.controllers;

import com.ride.springframework.domain.Address;
import com.ride.springframework.domain.Comment;
import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.User;
import com.ride.springframework.services.PostService;
import com.ride.springframework.services.UserService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;


@Controller
@SessionAttributes(names = "name")
public class PostController {
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
    //Edit post
    @RequestMapping("post/edit/{id}")
    public String editpost(@PathVariable Integer id,Post post, ModelMap model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("ids",id);
        System.out.println("Post id  is"+ id);
        System.out.println(post);
        return "posts";
    }

    //Delete post
    @RequestMapping("post/delete/{id}")
    public String deletepost(@PathVariable Integer id, Principal principal) {
        postService.deletePost(id);
        return "redirect:/post";
    }

    //Ride application
    @RequestMapping("/askRide")
    public String veiwride(Model model) {
        model.addAttribute("post", new Post());
        return "askRide";
    }


    @RequestMapping(value = "/reloadPost", method = RequestMethod.POST)
    public String createridePost(Post post1,ModelMap model) {
        //  THIS IS ABOUT CREATING POST NOT CREATING NEW USER sO USER MUST BE UPDATED
        Post post=(Post)model.get("post");
        System.out.println("post id is=====> if tih" +post);
        User user=(User)model.get("name");
        post1.setUser(user);

        System.out.println("This user is "+ user.getId());

        postService.savePost(post1);
        System.out.println("Update is Done ! ----->");
        model.addAttribute("posts", postService.listAllPost());
        return "redirect:/post";
    }


    //Display list of post
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String getallPost(Post post,Comment comment, ModelMap model,Principal principal) {
        comment=new Comment();
        comment.setComment("");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userdetails=(UserDetails) auth.getPrincipal();

     User user=userService.findByUsername(userdetails.getUsername());
        model.addAttribute("name",user);
        model.addAttribute("posts", postService.listAllPost());
        model.addAttribute("comment",comment);
        return "posts";
    }



    //Lists of Asked for Ride
    @RequestMapping(value = "/askedRide", method = RequestMethod.GET)
    public String askedRide(Post post, ModelMap model) {
        String post_type="askRide";
        model.addAttribute("posts", postService.findByPostType(post_type));
        // User users=userService.findByUsernameAndPassword("admin","admin");
        ///   System.out.println(users.toString());
        return "askedRide";
    }
    //Lists of offered Ride
    @RequestMapping(value = "/offeredRide", method = RequestMethod.GET)
    public String offeredRide(Post post, ModelMap model) {
        String post_type="giveRide";
        model.addAttribute("posts", postService.findByPostType(post_type));
        return "offeredRide";
    }

    //Lists of Post Posted By Owner
    @RequestMapping(value = "/myPost", method = RequestMethod.GET)
    public String myPost(Post post, ModelMap model) {
        User user=(User) model.get("name");
        System.out.println("===User Still available on Session====>"+user.toString());
        model.addAttribute("posts", postService.listOfPost(user));
        return "myPost";

    }

//create Comment

    @RequestMapping(value = "/createcomment", method = RequestMethod.POST)
    public String createUser(Post post, ModelMap modelMap) {
        //    comment.setPost_id(post);
        //comment.setPost(post);
        System.out.println("Post Id is=== "+post.getId());
        System.out.println("Received comment is====="+post.getPostText());
        System.out.println("Received Post Id is  is====="+ post.getId());
//    Comment comment1 = postService.saveComment(comment);
        //  modelMap.addAttribute("name", users);
        return "redirect:/post";
    }
    //Create User
    @RequestMapping(value = "/givecomment", method = RequestMethod.GET)
    public String signUp(User user, Address address, ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "register";
    }


}