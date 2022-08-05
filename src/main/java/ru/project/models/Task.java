package ru.project.models;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

public class Task {
    private int id;
    @NotEmpty(message = "the field cannot be empty")
    private String name;
    private String description;
    private String dateOfStart;
    @NotEmpty(message = "the field cannot be empty")
    private String dateOfEnd;

    public Task(int id, String name, String description, String dateOfStart, String dateOfEnd){
        this.id = id;
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

    public String getDateOfStart() {
        return dateOfStart;
    }

    public void setDateOfStart(String dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getDateOfEnd() {
        return dateOfEnd;
    }

    public void setDateOfEnd(String dateOfEnd) {
        this.dateOfEnd = dateOfEnd;
    }
}
