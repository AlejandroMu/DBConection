package com.appmoviles.organizador.model.entity;

import java.util.Date;

public class Task {
    private String id;
    private String name;
    private String description;
    private boolean complete;
    private String fk;

    public Task() {
    }

    public Task(String id, String name, String description, boolean complete, String fk) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.complete = complete;
        this.fk = fk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getFk() {
        return fk;
    }

    public void setFk(String fk) {
        this.fk = fk;
    }
}
