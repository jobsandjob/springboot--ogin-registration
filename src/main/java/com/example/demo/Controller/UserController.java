package com.example.demo.Controller;


import com.example.demo.Entity.User;
import com.example.demo.Repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepositary userRepositary;


    //To get Register Page from portal
    @GetMapping("/register")
    String displayRegitrationPage(Model model) {
        model.addAttribute("user", new User());
        return "registration-page";
    }

    //To get a login page from portal
    @GetMapping("/login")
    String displayLoginPage() {
        return "login";
    }


    @GetMapping("/register/save/register")
    String displayRegisterPage1() {
        return "registration-page";
    }

    //To get success page from registration if data save successfully
    @PostMapping("/register/save")
    String displayConfirm1(@RequestBody String email, User user) {

        try {
            userRepositary.save(user);
        } catch (DataIntegrityViolationException e) {
            // Handle the exception raised by Spring when the email already exists
            return "user-already-present";
        }
        return "success";
    }


    @GetMapping("/getdata{email}")
    String getUserbyEmail(@RequestParam String email, @RequestParam String password, Model model) {


        User user = userRepositary.findByEmail(email);
        if (user == null)
            return "user-not-found-register-again";
        else if  (!user.getPassword().equals(password))
            return "incorrect-password";
        else{
            model.addAttribute("user",user);
            return "homepage";
        }

    }

    @GetMapping("/displaychangevaluepage")
    String displaychangevaluePage(Model model)
    {
        return"change-value-page";
    }
    @PostMapping("/changevalues{email}")
    String changeValuePage(@RequestParam String newemail,@RequestParam String newfirst_name,@RequestParam String newlast_name,
                           @RequestParam String newfull_name,@RequestParam String newphoneNumber,
                           @RequestParam String newpassword,Model model)
    {
        User user = userRepositary.findByEmail(newemail);
        if (user == null)
            return "user-not-found-register-again";
        else{
            user.setPassword(newpassword);
            user.setFirst_name(newfirst_name);
            user.setFull_name(newfull_name);
            user.setLast_name(newlast_name);
            user.setPhone(newphoneNumber);
            model.addAttribute("user",user);
            userRepositary.save(user);
            return "modified-user-data";
        }
    }

    @GetMapping("/index")
    String displayIndex()
    {
        return"index";
    }
}


//        User user = userRepositary.findByEmail(email);
//
//        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
//           model.addAttribute("user",user);
//            return "homepage";
//        } else
//            return "failed-homepage";
