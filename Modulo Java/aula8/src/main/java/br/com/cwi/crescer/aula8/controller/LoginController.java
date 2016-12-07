package br.com.cwi.crescer.aula8.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login")
    public String login(Model m) {
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login?logout";
    }
}
