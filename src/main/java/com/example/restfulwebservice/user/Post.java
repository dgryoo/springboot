package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Post {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    // User : Post -> 1: (0~N), Main : Sub -> Parent : Child

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore // 해당값 표시가되지않음 ex) 주민번호
    private User user;


}
