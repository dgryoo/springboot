package com.example.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonIgnoreProperties(value = {"password", "ssn"})
@JsonFilter("UserInfoV2") // Controller, service class에서 사용 ex) VIP유저, Admin유저에서 보이는 값을 다르게 필터로 설정가능
public class UserV2 extends User {

    private String grade;


}
