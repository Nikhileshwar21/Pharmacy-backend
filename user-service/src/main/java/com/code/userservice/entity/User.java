package com.code.userservice.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
@Document(collection="users")
public class User{

    @Id
    private String id;
    @NotBlank
    @Size(max = 20)
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String username;

    @JsonIgnore
    @NotBlank
    @Size(max = 20)
    private String password;

    @DBRef
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    private boolean deleted=Boolean.FALSE;

    //constructor
    public User() {
    }

    public User(String id,String name, String email, String username, String mobile, String password) {
        this.id=id;
        this.email = email;
        this.username = username;
        this.password = password;

    }
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
