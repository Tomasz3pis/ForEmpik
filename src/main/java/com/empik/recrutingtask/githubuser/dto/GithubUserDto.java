package com.empik.recrutingtask.githubuser.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class GithubUserDto {

    private Long id;
    private String login;
    private String name;
    private String type;
    private String avatarUrl;
    private LocalDateTime createdAt;
    private Double calculations;
}
