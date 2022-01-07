package com.alina.web.productproject.controllers;

import com.alina.web.productproject.Forms.UserForm;
import com.alina.web.productproject.Forms.WhineForm;
import com.alina.web.productproject.models.User;
import com.alina.web.productproject.models.Whine;
import com.alina.web.productproject.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersController {

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    private final UsersService usersService;

    @GetMapping("/profile")
    public String getUserPage(@AuthenticationPrincipal(expression = "id") Long userId, Model model){
        User user = usersService.getUser(userId);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/users/{user-id}")
    public String getWhinesByUser(@AuthenticationPrincipal(expression = "id") Long userId, Model model, @PathVariable("user-id") Long userIdUrl){
        List<Whine> whines = usersService.getWhinesByUser(userIdUrl);
        model.addAttribute("whines", whines);
        User user = usersService.getUser(userIdUrl);
        model.addAttribute("user", user);
        model.addAttribute("authenticatedUserId", userId);
        return "whines_of_user";
    }

//    @GetMapping("/users/{user-id}/whines")
//    public String getWhinesByUser(@AuthenticationPrincipal(expression = "id") Long userId, Model model, @PathVariable("user-id") Long userIdUrl){
//        List<Whine> whines = usersService.getWhinesByUser(userIdUrl);
//        model.addAttribute("whines", whines);
//        User user = usersService.getUser(userIdUrl);
//        model.addAttribute("user", user);
//        model.addAttribute("authenticatedUserId", userId);
//        return "whines_of_user";
//    }

    @GetMapping("/users")
    public String getUsersPage(Model model){
        List<User> users = usersService.getAllUser();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("/users")
    public String addUser(UserForm form, BindingResult result, RedirectAttributes forRedirectModel) {
        if (result.hasErrors()) {
            forRedirectModel.addFlashAttribute("errors", "Есть ошибки на форме!");
            return "redirect:/users";
        }
        usersService.addUser(form);
        return "redirect:/users";
    }

    @PostMapping("/profile/delete")
    public String deleteUser(@AuthenticationPrincipal(expression = "id")  Long userId){
        usersService.deleteUser(userId);
        return "redirect:/users";
    }

    @PostMapping("/profile/update")
    public String updateUser(@AuthenticationPrincipal(expression = "id")  Long userId, @Valid UserForm form){
        usersService.update(userId, form);
        return "redirect:/users/"+userId;
    }

    @PostMapping("/whine")
    public String addWhineToUser(@AuthenticationPrincipal(expression = "id") Long userId, WhineForm form){
        usersService.addWhineToUser(userId, form);
        return "redirect:/users/"+userId;
    }

    @PostMapping("/whines/{whine-id}/delete")
    public String deleteWhine(@AuthenticationPrincipal(expression = "id") Long userId, @PathVariable("whine-id") Long whineId){
        usersService.deleteWhine(whineId, userId);
        return "redirect:/users/"+userId;
    }

    @GetMapping("/whines")
    public String getAllWhines(Model model){
        List<Whine> whines = usersService.getAllWhines();
        model.addAttribute("whines", whines);
        return "whines";
    }

    @GetMapping("/home")
    public String getAllWhinesHome(@AuthenticationPrincipal(expression = "id") Long userId, Model model){
        List<Whine> whines = usersService.getAllWhines();
        User user = usersService.getUser(userId);
        model.addAttribute("user", user);
        model.addAttribute("whines", whines);
        model.addAttribute("authenticatedUserId", userId);
        return "whines_of_user";
    }

}
