package com.ride.springframework.controllers;

import com.ride.springframework.domain.Address;
import com.ride.springframework.domain.Post;
import com.ride.springframework.domain.Role;
import com.ride.springframework.domain.User;
import com.ride.springframework.services.SecurityService;
import com.ride.springframework.services.UserService;
import com.ride.springframework.validator.UserValidator;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by OD on 6/20/2017.
 */
@Controller
@SessionAttributes(names = "user")
public class UserController {

@Autowired
private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, User user, String error, String logout) {
        model.addAttribute("user", new User());
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");
       if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");
        return "login";
    }
    //Create User
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String signUp(User user, Address address, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "register";
    }
   //Create User
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String createUser(User user, Address address, ModelMap modelMap) {
        modelMap.addAttribute("user", user);
        modelMap.addAttribute("address", address);
        address.setUser(user);
        user.setAddress(address);

        Set<Role> userrole=new HashSet<>();

//        Role role1=new Role();
//        role1.setName("ADMIN");
        Role role2=new Role();
        role2.setName("USER");
          userrole.add(role2);

        user.setRole(userrole);
        for(Role role:userrole){
            userService.saveRole(role);
        }

       // System.out.println("Role is regitered"+savedRole.getName());
        User users = userService.save(user);
        modelMap.addAttribute("name", users);
        return "redirect:/post";
    }
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout( ModelMap model) {
        User user=new User();
        model.addAttribute("name",user);
        return "redirect:/login";
    }
    @RequestMapping("/profile/edit/{id}")
    public String displayComment(@PathVariable Integer id, User user, ModelMap model) {
        User myuser = userService.findUserbyId(id);
        Address address=myuser.getAddress();
        model.addAttribute("user", myuser);
        model.addAttribute("address", address);
           return "register";
    }
@RequestMapping("/admin")
    public String adminPage(){
        return "adminPage";
}

@GetMapping("/international")
    public String getInternationalPage() {
        return "login";
    }

}
