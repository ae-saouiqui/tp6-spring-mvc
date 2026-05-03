package controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entities.User;
import services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }


    @PostMapping("/login")
    public String login(@ModelAttribute("user") User userForm, HttpSession session){
        User user = service.login(userForm.getUsername(), userForm.getPassword());
        if(user != null){
            session.setAttribute("user", user);
            return "redirect:/views/home.jsp";
        }
        return "redirect:/index.jsp";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }
}
