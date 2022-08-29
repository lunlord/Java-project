//package ru.project.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import ru.project.models.Task;
//
//import java.util.Date;
//import java.util.List;
//
//public class CategoryDAO {
//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public TaskDAO(JdbcTemplate jdbcTemplate){
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    Date date = new Date();
//
//    public List<Task> index(){
//        return jdbcTemplate.query("SELECT * FROM Task", new BeanPropertyRowMapper<>(Task.class));
//    }
//
//    public Task show(int id){
//        return jdbcTemplate.query("SELECT * FROM Task WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Task.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void save(Task task){
//        jdbcTemplate.update("INSERT INTO Task(name, description, dateOfStart, dateOfEnd) VALUES (?,?,?,?)", task.getName(),task.getDescription(), new Date(),new java.util.Date(task.getDateOfEnd().getTime()));
//    }
//
//    public void update(int id, Task updatedTask){
//        jdbcTemplate.update("UPDATE Task SET name=?, description=?, dateOfEnd=? WHERE id = ?",updatedTask.getName(),updatedTask.getDescription(),new java.sql.Date(updatedTask.getDateOfEnd().getTime()), id);
//    }
//
//    public void delete(int id){
//        jdbcTemplate.update("DELETE FROM Task WHERE id=?",id);
//    }
//}
