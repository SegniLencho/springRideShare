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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


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
    public String editpost(@PathVariable Integer id, Post post, ModelMap model) {
        model.addAttribute("post", postService.getPostById(id));
        model.addAttribute("ids", id);
        System.out.println("Post id  is" + id);
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
    public String createridePost(Post post1, ModelMap model) {
        //  THIS IS ABOUT CREATING POST NOT CREATING NEW USER sO USER MUST BE UPDATED
        Post post = (Post) model.get("post");

        User user = (User) model.get("name");
        post1.setUser(user);

        if (post1.getPostType() == null)
            post1.setPostType("askRide");


        //set date for post
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calobj = Calendar.getInstance();
        post1.setDateCreated(calobj.getTime());
        postService.savePost(post1);
        System.out.println("Update is Done ! ----->");
        model.addAttribute("posts", postService.listAllPost());
        return "redirect:/post";
    }


    //Display list of post
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public String getallPost(Post post, Comment comment, ModelMap model, Principal principal) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userdetails = (UserDetails) auth.getPrincipal();
        Post postwithComment = new Post();

        for (Post p : postService.listAllPost()) {
            List<Comment> commentList = new ArrayList<>();

            for (Comment c : postService.findcommentByPostId(p)) {
                commentList.add(c);
            }
            postwithComment.setComments(commentList);
        }

        //
// System.out.println("Comment "+);
//

        User user = userService.findByUsername(userdetails.getUsername());
        model.addAttribute("name", user);
        model.addAttribute("posts", postService.listAllPost());

        model.addAttribute("comment", new Comment());
        return "posts";
    }


    //Lists of Asked for Ride
    @RequestMapping(value = "/askedRide", method = RequestMethod.GET)
    public String askedRide(Post post, ModelMap model) {
        String post_type = "askRide";
        model.addAttribute("posts", postService.findByPostType(post_type));
        return "askedRide";
    }

    //Lists of offered Ride
    @RequestMapping(value = "/offeredRide", method = RequestMethod.GET)
    public String offeredRide(Post post, ModelMap model) {
        String post_type = "giveRide";
        model.addAttribute("posts", postService.findByPostType(post_type));
        return "offeredRide";
    }

    //Lists of Post Posted By Owner
    @RequestMapping(value = "/myPost", method = RequestMethod.GET)
    public String myPost(Post post, ModelMap model) {
        User user = (User) model.get("name");
        model.addAttribute("posts", postService.listOfPost(user));
        return "myPost";

    }

//create Comment

    @RequestMapping(value = "/createcomment", method = RequestMethod.POST)
    public String createComment(@RequestParam(name = "id") int postId, @RequestParam(name = "comment") String content, ModelMap modelMap) {
        User user = (User) modelMap.get("name");
        Post post1 = postService.getPostById(postId);
        Comment comment = new Comment();
        comment.setComment(content);
        comment.setPost(post1);
        comment.setUser(user);
        //set time for comment
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calobj = Calendar.getInstance();
        post1.setDateCreated(calobj.getTime());
        comment.setDateCreated(calobj.getTime());
        comment.setDateUpdated(calobj.getTime());
        Comment comment1 = postService.saveComment(comment);
        return "redirect:/post";
    }

    //Create User
    @RequestMapping(value = "/givecomment", method = RequestMethod.GET)
    public String signUp(User user, Address address, ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "register";
    }

    //This is big issue about comment
    @RequestMapping("post/seeComments/{id}")
    public String displayComment(@PathVariable Integer id, Post post, ModelMap model) {

        Post mypost = postService.getPostById(id);
        List<Comment> commentList = postService.findcommentByPostId(mypost);
        mypost.setComments(commentList);
        model.addAttribute("posts", mypost);
        model.addAttribute("ids", id);
  return "displayComment";
    }

    @RequestMapping("post/deleteComment/{id}")
    public String deleteComment(@RequestParam(name = "id") int commentId, Post post, ModelMap model) {
        System.out.println("Complire Reaches HERE!");
        Comment mycomment=postService.finduserBycommentId(commentId);
        User user=mycomment.getUser();
        User loggedInuser = (User) model.get("name");
        System.out.println("User Who comment this comment is  ==>"+user.getFirstName());
        System.out.println("Current User from session i s ==>"+loggedInuser.getFirstName());

        return "displayComment";
    }


}