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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


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
    @PostMapping(path="/registered")
    public String registerUser(@Valid @ModelAttribute("user") LibraryUser user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        }
        String username = user.getUsername();
        Authority authority = new Authority();
        authority.setUsername(username);
        authority.setRole(Role.ROLE_TOURIST);
        authorityService.save(authority);
        userService.save(user);
        return "user_info";
    }
}
