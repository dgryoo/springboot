package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor

public class User {

    private Integer id;
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    @Past(message = "과거의 값만 올 수 있습니다.") //미래데이터는 올 수 없고 과거의 데이터만 올 수 있음
    private Date joinDate;

}
