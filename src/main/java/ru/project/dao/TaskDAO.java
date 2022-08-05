package ru.project.dao;

import org.springframework.stereotype.Component;
import ru.project.models.Task;

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

    {
        tasks = new ArrayList<>();
        tasks.add(new Task(++TASK_COUNT,"Wash the dishes", "Its simple",
                formater.format(date),formater.format(date)));
        tasks.add(new Task(++TASK_COUNT,"Wash car", "Its hard",
                formater.format(date),"2022-09-01 21:22:33"));
        tasks.add(new Task(++TASK_COUNT,"Clean house","Its hard",
                formater.format(date),"2022-09-03 21:13:24"));
    }

    public List<Task> index(){
        return tasks;
    }

    public Task show(int id){
        return tasks.stream().filter(task -> task.getId() == id).findAny().orElse(null);

    }

    public void save(Task task){
        task.setId(++TASK_COUNT);
        task.setDateOfStart(formater.format(date));
        tasks.add(task);
    }

    public void update(int id, Task updatedTask){
        Task taskToBeUpdated = show(id);
        taskToBeUpdated.setName(updatedTask.getName());
        taskToBeUpdated.setDateOfEnd(updatedTask.getDateOfEnd());
        taskToBeUpdated.setDescription(updatedTask.getDescription());

    }

    public void delete(int id){
        tasks.removeIf(p -> p.getId() == id);
    }
}
