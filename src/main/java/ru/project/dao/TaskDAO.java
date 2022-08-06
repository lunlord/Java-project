package ru.project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.project.models.Task;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TaskDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    Date date = new Date();

    public List<Task> index(){
        return jdbcTemplate.query("SELECT * FROM Task", new BeanPropertyRowMapper<>(Task.class));
    }

    public Task show(int id){
        return jdbcTemplate.query("SELECT * FROM Task WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Task.class))
                .stream().findAny().orElse(null);
    }

    public void save(Task task){
        jdbcTemplate.update("INSERT INTO Task VALUES (1,?,?,?,?)", task.getName(),task.getDescription(), new java.sql.Date(date.getTime()),new java.sql.Date(task.getDateOfEnd().getTime()));
    }

    public void update(int id, Task updatedTask){
        jdbcTemplate.update("UPDATE Task SET name=?, description=?, dateOfEnd=? WHERE id = ?",updatedTask.getName(),updatedTask.getDescription(),new java.sql.Date(updatedTask.getDateOfEnd().getTime()), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Task WHERE id=?",id);
    }
}
