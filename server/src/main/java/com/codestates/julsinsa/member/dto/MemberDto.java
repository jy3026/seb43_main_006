package com.codestates.julsinsa.member.dto;

import com.codestates.julsinsa.member.entity.Member;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class MemberDto {
    @Getter
    public static class Post {

        @NotBlank
        private String realName;

        @NotBlank
        private String displayName;

        @NotBlank
        @Email
        private String email;

        @NotBlank
        private String password;

        @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
                message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
        private String phone;


        @JsonFormat(pattern = "yyyy-MM-dd")
        private LocalDate birthDate;

        @NotBlank
        private String mailKey;

    }

    @Getter
    public static class Patch {

    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Response {
        private long memberId;
        private String realName;

        private String displayName;
        private String email;
        private String name;
        private String phone;
        private Member.MemberStatus userStatus;

        private LocalDate birthDate;
    }
}