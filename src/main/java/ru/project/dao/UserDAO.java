//package ru.project.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//import ru.project.models.Task;
//import ru.project.models.User;
//
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class UserDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public UserDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<User> index(){
//        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper<>(User.class));
//    }
//
//    public User show(int id){
//        return jdbcTemplate.query("SELECT * FROM User WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(User.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void register(User user){
//        jdbcTemplate.update("INSERT INTO User(name, surname, email, address) VALUES (?,?,?,?)", user.getName(),user.getSurname(), user.getEmail(), user.getAddress());
//    }
//
//    public void update(int id, User updatedUser){
//        jdbcTemplate.update("UPDATE User SET name=?, surname=?, email=?, address=? WHERE id = ?",updatedUser.getName(),updatedUser.getSurname(),updatedUser.getEmail(),updatedUser.getAddress(), id);
//    }
//
//    public void delete(int id){
//        jdbcTemplate.update("DELETE FROM User WHERE id=?",id);
//    }
//
//}
