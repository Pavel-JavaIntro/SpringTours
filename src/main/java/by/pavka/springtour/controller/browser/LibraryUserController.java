package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.repository.LibraryUserRepository;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("users")
public class LibraryUserController {

  @Autowired LibraryUserService userService;

  @GetMapping
  public String showAllLibraryUsers(ModelMap map) {
    System.out.println("DONE!");
    List<LibraryUser> users = userService.getAll();
    map.addAttribute("users", users);
    return "user_info";
  }

  @PostMapping
  public String registerNewTourist(LibraryUser tourist, ModelMap map) {
    // TODO
    //    List<LibraryUser> users = userService.findAll();
    //    map.addAttribute("users", users);
    System.out.println("DOING!!");
    return "user_info";
  }

  @GetMapping("register")
  public String startRegistration(ModelMap map) {
    map.put("user", new LibraryUser());
    return "registration";
  }
}
