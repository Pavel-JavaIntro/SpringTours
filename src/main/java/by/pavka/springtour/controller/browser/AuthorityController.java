package by.pavka.springtour.controller.browser;

import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Role;
import by.pavka.springtour.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("springauthorities")
public class AuthorityController {
  @Autowired AuthorityService authorityService;

  @GetMapping
  public String showAllAuthorities(@Nullable @RequestParam String[] authId, ModelMap map) {
    List<Authority> authorities = authorityService.getAll();
    if (authId != null) {
      List<String> authIds = Arrays.asList(authId);
      for (Authority a : authorities) {
        if (a.getRole() != Role.ROLE_ADMIN) {
          if (authIds.contains(a.getId() + "")) {
            a.setRole(Role.ROLE_MANAGER);
          } else {
            a.setRole(Role.ROLE_TOURIST);
          }
          authorityService.save(a);
        }
      }
    }
    map.addAttribute("authorities", authorities);
    return "authority_listing";
  }
}
