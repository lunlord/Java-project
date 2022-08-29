//package ru.project.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import ru.project.dao.UserDAO;
//import ru.project.models.User;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/users")
//public class UsersController {
//
//    private final UserDAO userDAO;
//
//    public UsersController(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @GetMapping()
//    public String index(Model model){
//        model.addAttribute("users", userDAO.index());
//        return "users/index";
//    }
//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model){
//        model.addAttribute("user", userDAO.show(id));
//        return "users/show";
//    }
//    @GetMapping("/register")
//    public String newUser(Model model){
//        model.addAttribute("user", new User());
//        return "users/registration";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("user") @Valid User user,
//                         BindingResult bindingResult){
//        if(bindingResult.hasErrors())
//            return "users/registration";
//
//        userDAO.register(user);
//        return "redirect:/users";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String edit(Model model, @PathVariable("id") int id){
//        model.addAttribute("user", userDAO.show(id));
//        return "users/edit";
//    }
//
//    @PatchMapping("/{id}")
//    public String update(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,
//                         @PathVariable("id") int id){
//        if (bindingResult.hasErrors())
//            return "users/edit";
//
//        userDAO.update(id, user);
//        return "redirect:/users";
//    }
//    @DeleteMapping("/{id}")
//    public String delete(@PathVariable("id") int id){
//        userDAO.delete(id);
//        return "redirect:/users";
//    }
//
//}
