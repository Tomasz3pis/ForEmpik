package com.empik.recrutingtask.githubuser.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class GithubUserResponseDto {
    private String login;
    private Long id;
    private String avatarUrl;
    private String name;
    private String type;
    private Long publicRepos;
    private Long followers;
    private LocalDateTime createdAt;
}
