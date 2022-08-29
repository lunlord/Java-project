package ru.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.project.models.Task;

import java.util.Date;
import java.util.List;

@Component
public class TaskDAO {

    private final SessionFactory sessionFactory;

    Date date = new Date();

    @Autowired
        public TaskDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Task> index(){
        Session session = sessionFactory.getCurrentSession();
        List<Task> tasks = session.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        return tasks;
    }

    @Transactional(readOnly = true)
    public Task show(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Task.class,id);
    }

    @Transactional
    public void save(Task task){
        Session session = sessionFactory.getCurrentSession();
        session.save(task);
    }

    @Transactional
    public void update(int id, Task updatedTask){
        Session session = sessionFactory.getCurrentSession();
        Task tasktobeupdated = session.get(Task.class, id);
        tasktobeupdated.setName(updatedTask.getName());
        tasktobeupdated.setDescription(updatedTask.getDescription());
        tasktobeupdated.setDateOfEnd(updatedTask.getDateOfEnd());
    }
    @Transactional
    public void delete(int id){
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Task.class, id));
    }

}
