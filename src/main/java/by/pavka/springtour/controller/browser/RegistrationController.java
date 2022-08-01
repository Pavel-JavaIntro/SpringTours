package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Role;
import by.pavka.springtour.service.AuthorityService;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.SecureRandom;

@Controller
public class RegistrationController {
  @Autowired LibraryUserService userService;
  @Autowired AuthorityService authorityService;

  @GetMapping("/register")
  public String startRegistration(ModelMap map) {
    map.put("user", new LibraryUser());
    return "registration";
  }

  @Transactional
  @PostMapping(path = "/registered")
  public String registerUser(
      @Valid @ModelAttribute("user") LibraryUser user, BindingResult result) {
    if (result.hasErrors() || (!user.getPassword().equals(user.getCheckPassword()))) {
      System.out.println("Pass: " + user.getPassword());
      System.out.println("CheckPass: " + user.getCheckPassword());
      return "registration";
    }
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(
            12, new SecureRandom());
    String encodedPassword = "{bcrypt}" + encoder.encode(user.getPassword());
    user.setPassword(encodedPassword);
    user.setEnabled(1);
    String username = user.getUsername();
    Authority authority = new Authority();
    authority.setUsername(username);
    authority.setRole(Role.ROLE_TOURIST);
    authorityService.save(authority);
    userService.save(user);
    return "redirect:/springtours";
  }
}
