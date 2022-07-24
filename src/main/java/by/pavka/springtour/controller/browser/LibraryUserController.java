package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.repository.LibraryUserRepository;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class LibraryUserController {

    @Autowired
    LibraryUserService userService;

    @GetMapping
    public String showAllLibraryUsers(ModelMap map) {
        List<LibraryUser> users = userService.findAll();
        map.addAttribute("users", users);
        return "user_info";
    }
}
