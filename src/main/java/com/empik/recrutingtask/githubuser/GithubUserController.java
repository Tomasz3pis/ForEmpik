package com.empik.recrutingtask.githubuser;

import com.empik.recrutingtask.githubuser.dto.GithubUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GithubUserController {

    private final GithubUserService githubUserService;

    @GetMapping(value = "/users/{login}")
    public GithubUserDto getOne(@PathVariable String login) {
        return githubUserService.getOne(login);
    }
}
