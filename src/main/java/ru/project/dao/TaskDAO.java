package ru.project.dao;

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
    private static int TASK_COUNT;
    private List<Task> tasks;
    SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = new Date();

    private static final String URL = "jdbc:mysql://localhost:3306/java_cp_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Task> index(){
        List<Task> tasks = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Task";
            ResultSet resultSet = statement.executeQuery(SQL);
            //Сдвигаем итератор на следущую запись
            while (resultSet.next()){
                Task task = new Task();

                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDateOfStart(resultSet.getDate("dateOfStart"));
                task.setDateOfEnd(resultSet.getDate("dateOfEnd"));

                tasks.add(task);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tasks;
    }

    public Task show(int id){
        Task task = null; //указатель
        try {

            PreparedStatement preparedStatement =connection.prepareStatement("SELECT * FROM Task WHERE id = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            task = new Task();

            task.setId(resultSet.getInt("id"));
            task.setName(resultSet.getString("name"));
            task.setDescription(resultSet.getString("description"));
            task.setDateOfStart(resultSet.getDate("dateOfStart"));
            task.setDateOfEnd(resultSet.getDate("dateOfEnd"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return task;

    }

    public void save(Task task){

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Task VALUES (1,?,?,?,?)");

            preparedStatement.setString(1,task.getName());
            preparedStatement.setString(2,task.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(date.getTime()));
            preparedStatement.setDate(4, new java.sql.Date(task.getDateOfEnd().getTime()));

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void update(int id, Task updatedTask){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Task SET name=?,description=?, dateOfEnd=? WHERE id=?");

            preparedStatement.setString(1,updatedTask.getName());
            preparedStatement.setString(2,updatedTask.getDescription());
            preparedStatement.setDate(3, new java.sql.Date(updatedTask.getDateOfEnd().getTime()));

            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Task WHERE id = ?");
            preparedStatement.setInt(1,id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
