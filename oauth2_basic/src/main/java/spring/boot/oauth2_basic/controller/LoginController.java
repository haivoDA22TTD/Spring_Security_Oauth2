package spring.boot.oauth2_basic.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")

    public String login(){

        return "login"; // trả về file login.html
    }

    @GetMapping("/dashboard")

    public String dashboard(@AuthenticationPrincipal OAuth2User principal, Model model) {

        model.addAttribute("name", principal.getAttribute("login"));

        return "dashboard"; // Trả về file dashboard.html
    }
}
