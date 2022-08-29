package ru.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "the field cannot be empty")
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "dateOfStart")
    private Date dateOfStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dateOfEnd")
    private Date dateOfEnd;

    public Task(String name, String description, Date dateOfStart, Date dateOfEnd){
        this.name = name;
        this.description = description;
        this.dateOfStart = dateOfStart;
        this.dateOfEnd = dateOfEnd;
    }

    public Task(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(Date dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public Date getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(Date dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}
