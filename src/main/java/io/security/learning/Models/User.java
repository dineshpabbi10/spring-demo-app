package io.security.learning.Models;

import io.security.learning.MyUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user",schema = "security")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @NonNull
    @Column(name="username")
    String username;

    @NonNull
    @Column(name="password")
    String password;

    @NonNull
    @Column(name = "role")
    String role;

    public MyUserDetails toUserDetails(){
        return new MyUserDetails(this);
    }


}
