package com.empik.recrutingtask.githubuser;

import com.empik.recrutingtask.githubuser.dto.GithubUserDto;
import com.empik.recrutingtask.githubuser.dto.GithubUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GithubUserService {

    private final GithubUserRepository repository;
    private final GithubClientService clientService;

    public GithubUserDto getOne(String login) {
        GithubUserResponseDto result = clientService.getByLogin(login);
        saveRequestCount(login);
        GithubUserDto dto = mapResults(result);
        dto.setCalculations(calculate(result.getFollowers(), result.getPublicRepos()));
        return dto;
    }

    private GithubUserDto mapResults(GithubUserResponseDto result) {
        GithubUserDto dto = new GithubUserDto();
        if (result.getId() != null) {
            dto.setId(result.getId());
        }
        if (result.getLogin() != null) {
            dto.setLogin(result.getLogin());
        }
        if (result.getName() != null) {
            dto.setName(result.getName());
        }
        if (result.getType() != null) {
            dto.setType(result.getType());
        }
        if (result.getAvatarUrl() != null) {
            dto.setAvatarUrl(result.getAvatarUrl());
        }
        if (result.getCreatedAt() != null) {
            dto.setCreatedAt(result.getCreatedAt());
        }
        return dto;
    }

    private Double calculate(Long followers, Long publicRepos) {
        if (followers <= 0 || publicRepos == null) {
            return 0.0;
        }
        return (6.0 / followers * (2.0 + publicRepos));
    }

    private void saveRequestCount(String login) {
        GithubUserE user = repository.findByLogin(login);
        if (user != null) {
            user.setRequestCount(user.getRequestCount() + 1);
            repository.save(user);
        } else {
            GithubUserE githubUserE = new GithubUserE(login, 1L);
            repository.save(githubUserE);
        }
    }
}
