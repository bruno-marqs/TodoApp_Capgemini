package model;

import java.util.Date;

public class Project {

    private int id;
    private String name;
    private String description;
    private Date createAt;
    private Date updateAt;

    // constutor //
    public Project(int id, String name, String description, Date createAt, Date updateAt){
        this.id = id;
        this.name = name;
        this.description = description;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    // getters & setters //
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    // toString //
    @Override
    public String toString() {
        return "Project {" + "id= " + id + ", name= " + name + 
        ", description= " + description + ", createAt= " + createAt + 
        ", updateAt= " + updateAt + "}";
    }

    
    

}
