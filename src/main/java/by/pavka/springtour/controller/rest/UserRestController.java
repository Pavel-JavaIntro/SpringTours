package by.pavka.springtour.controller.rest;

//@RestController
//@RequestMapping("api/users")
public class UserRestController {

//    @Autowired
//    UserDaoImpl dao;
//
//    @GetMapping("")
//    public ResponseEntity<List<User>> getUsers() {
//        List<User> users = dao.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUser(@PathVariable int id) {
//        User user = dao.getUserById(id);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @PutMapping("")
//    public ResponseEntity<User> updateUser(@RequestBody User user) {
//        dao.updateUser(user);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//    @LogAnnotation
//    @PostMapping("")
//    public ResponseEntity<User> addUser(@RequestBody User user) {
//        int key = dao.addUser(user);
//        user.setId(key);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deleteUser(@PathVariable int id) {
//        int rows = dao.deleteUser(id);
//        if (rows == 0) {
//            throw new NoSuchIDException("This User id is not in the DB");
//        }
//        return HttpStatus.NO_CONTENT;
//    }
}
