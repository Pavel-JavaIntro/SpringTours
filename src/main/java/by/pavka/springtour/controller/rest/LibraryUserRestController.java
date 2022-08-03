package by.pavka.springtour.controller.rest;

import by.pavka.springtour.exception.NoSuchIDException;
import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Role;
import by.pavka.springtour.service.AuthorityService;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("api/users")
public class LibraryUserRestController {
  @Autowired LibraryUserService service;
  @Autowired AuthorityService authorityService;

  @GetMapping
  public List<LibraryUser> getAll() {
    List<LibraryUser> users = service.getAll();
    return users;
  }

  @GetMapping("/{id}")
  public LibraryUser get(@PathVariable int id) {
    return service.get(id).orElseThrow(() -> new NoSuchIDException("No such element present"));
  }

  @Transactional
  @PostMapping
  public LibraryUser add(@RequestBody LibraryUser user) {
    String username = user.getUsername();
    Authority authority = new Authority();
    authority.setUsername(username);
    authority.setRole(Role.ROLE_TOURIST);
    authorityService.save(authority);
    return service.save(user);
  }

  @PutMapping
  public LibraryUser update(@RequestBody LibraryUser user) {
    return service.save(user);
  }

  @Transactional
  @DeleteMapping("/{id}")
  public void delete(@PathVariable int id) {
    LibraryUser user = get(id);
    service.delete(id);
    authorityService.deleteByUsername(user.getUsername());
  }
}
