package by.pavka.springtour.controller.rest;


import by.pavka.springtour.model.Authority;
import by.pavka.springtour.model.LibraryUser;
import by.pavka.springtour.model.Role;
import by.pavka.springtour.service.AuthorityService;
import by.pavka.springtour.service.LibraryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("authorities")
public class AuthorityRestController {
    @Autowired
    LibraryUserService userService;
    @Autowired
    AuthorityService service;

    @GetMapping
    public List<Authority> getAll() {
        List<Authority> authorities = service.getAll();
        return authorities;
    }

    @GetMapping("/{id}")
    public Authority get(@PathVariable int id) {
        return service.get(id).get();
    }


    @PutMapping
    public Authority update(@RequestBody Authority authority) {
        return service.save(authority);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Authority authority = get(id);
        userService.deleteByUsername(authority.getUsername());
        service.delete(id);
    }
}