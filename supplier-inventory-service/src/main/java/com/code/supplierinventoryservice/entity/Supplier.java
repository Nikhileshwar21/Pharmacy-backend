package com.code.supplierinventoryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Supplier")
public class Supplier {

    @Id
    private String id;
    private String name;
    private String email;
    @JsonIgnore
    private boolean deleted=Boolean.FALSE;

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Supplier(){

    }

    public Supplier(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
