package com.example.restfulwebservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
// @JsonIgnoreProperties(value = {"password", "ssn"})
@NoArgsConstructor // default constructer
//@JsonFilter("UserInfo") // Controller, service class에서 사용 ex) VIP유저, Admin유저에서 보이는 값을 다르게 필터로 설정가능
//@ApiModel(description = "사용자 상세 정보를 위한 도메인객체")
@Entity

public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Past(message = "과거의 값만 올 수 있습니다.") //미래데이터는 올 수 없고 과거의 데이터만 올 수 있음
//    @ApiModelProperty(notes = "사용자 등록일을 입력해 주세요.")
    private Date joinDate;
    @Size(min = 2, message = "Name은 2글자 이상 입력해 주세요.")
//    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요.")
    private String name;
//    @ApiModelProperty(notes = "사용자 패스워드를 입력해 주세요.")
    private String password;
//    @ApiModelProperty(notes = "사용자 주민번호를 입력해 주세요.")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int id, Date joinDate, String name, String password, String ssn) {
        this.id = id;
        this.joinDate = joinDate;
        this.name = name;
        this.password = password;
        this.ssn = ssn;
    }
}
