package by.pavka.springtour.service;

import by.pavka.springtour.repository.UserDao;

//@Service
public class UserDaoImpl implements UserDao {
//    private JdbcTemplate jdbcTemplate;
//    private UserMapper userMapper;
//
//    @Autowired
//    public UserDaoImpl(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userMapper = userMapper;
//    }
//
//    @Override
//    public User getUserById(int id) {
//        try {
//            User user =  jdbcTemplate.queryForObject("SELECT * FROM lib_users WHERE id=?", userMapper, id);
//            return user;
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            throw new NoSuchIDException("User with id = " + id + " is not found in the DB");
//        }
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return jdbcTemplate.query("SELECT * FROM lib_users", userMapper);
//    }
//
//    @Override
//    public int addUser(User user) {
//        String sql = "INSERT INTO lib_users (\"name\", surname, email, role_Id, login, password) "
//                + "VALUES (?, ?, ?, ?, ?, ?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(connection -> {
//            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, user.getName());
//            ps.setString(2, user.getSurname());
//            ps.setString(3, user.getEmail());
//            ps.setInt(4, user.getRoleId());
//            ps.setString(5, user.getLogin());
//            ps.setInt(6, user.getPassword());
//            return ps;}, keyHolder);
//        return (int)keyHolder.getKeys().get("id");
//    }
//
//    @Override
//    public int updateUser(User user) {
//        return jdbcTemplate.update("UPDATE lib_users SET \"name\"=?, surname=?, email=?, role_Id=?, login=?, password=?"
//                        + "WHERE id=?", user.getName(), user.getSurname(), user.getEmail()
//                , user.getRoleId(), user.getLogin(), user.getPassword(), user.getId());
//    }
//
//    @Override
//    public int deleteUser(int id) {
//        return jdbcTemplate.update("DELETE FROM lib_users WHERE id=?", id);
//    }
}
