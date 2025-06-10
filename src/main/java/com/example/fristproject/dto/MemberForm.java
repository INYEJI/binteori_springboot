package com.example.fristproject.dto;

import com.example.fristproject.entity.Article;
import com.example.fristproject.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MemberForm {
    private String email;
    private String password;

    public Member toEntity() {
        return new Member(null, email, password);
    }
}
