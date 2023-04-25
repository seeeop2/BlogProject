package com.inseop.web.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.inseop.web.user.model.UserVO;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
  
  @RequestMapping(value = "/login" , method = RequestMethod.GET)
  public String loginForm(Model model) {
    model.addAttribute("userVO", new UserVO());
    return "login/login";
  }
  
  
  
  
}
