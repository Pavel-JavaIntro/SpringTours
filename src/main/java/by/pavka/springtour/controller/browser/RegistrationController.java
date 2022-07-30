package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Role;
import by.pavka.springtour.service.AuthorityService;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegistrationController {
    @Autowired
    LibraryUserService userService;
    @Autowired
    AuthorityService authorityService;

    @GetMapping("/register")
    public String startRegistration(ModelMap map) {
        map.put("user", new LibraryUser());
        return "registration";
    }

    @Transactional
    @PostMapping(path="/register")
    public String registerUser(@ModelAttribute LibraryUser user) {
        String username = user.getUsername();
        Authority authority = new Authority();
        authority.setUsername(username);
        authority.setRole(Role.ROLE_TOURIST);
        authorityService.save(authority);
        userService.save(user);
        return "user_info";
    }
}
