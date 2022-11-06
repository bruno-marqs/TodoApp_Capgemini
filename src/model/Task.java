package model;

import java.util.Date;

public class Task {
    
    private int id;
    private int idproject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Date deadline;
    private Date createAt;
    private Date updateAt;

    // Construtores //
    public Task(int id, int idproject, String name, String description, String notes, boolean isCompleted, Date deadline, Date createAt, Date updateAt){
        this.id = id;
        this.idproject = idproject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Task(){
        this.createAt = new Date();
    }

    // getters & setters // 

    public int getId() {
        return id;
    }
    public int getIdproject() {
        return idproject;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getNotes() {
        return notes;
    }
    public boolean isIsCompleted() {
        return isCompleted;
    }
    public Date getDeadline() {
        return deadline;
    }
    public Date getCreateAt() {
        return createAt;
    }
    public Date getUpdateAt() {
        return updateAt;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setIdproject(int idproject) {
        this.idproject = idproject;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
    
    @Override
    public String toString() {
        return "Tasks {" + "id= " + id + "idproject= " + idproject + 
        ", name= " + name + ", description= " + description + 
        ", notes= " + notes + ", isCompleted= " + isCompleted +
        ", deadline= " + deadline + ", createAt= " + createAt +
        ", updateAt= " + updateAt + "}";
    }

}
