package com.headacheIT.todoList.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "headache_user")
public class HeadacheUser extends ResponseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String nickname;
    @Column(name = "registered_at")
    private LocalDateTime registeredAt;
    @Column(name = "profile_image")
    private String profileImage;
}
