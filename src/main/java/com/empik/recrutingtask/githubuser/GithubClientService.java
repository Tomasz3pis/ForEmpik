package com.empik.recrutingtask.githubuser;

import com.empik.recrutingtask.githubuser.dto.GithubUserResponseDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Component
public class GithubClientService {

    private static final String GITHUB_URL = "https://api.github.com/users";
    private final RestTemplate restTemplate = new RestTemplate();

    public GithubUserResponseDto getByLogin(String login) {
        String uriString = UriComponentsBuilder.fromUriString(GITHUB_URL)
                .path("/{login}")
                .buildAndExpand(Map.of("login", login))
                .toUriString();

        return restTemplate.getForObject(uriString, GithubUserResponseDto.class);
    }
}
