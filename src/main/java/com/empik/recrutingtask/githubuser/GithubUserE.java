package com.empik.recrutingtask.githubuser;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@RequiredArgsConstructor
public class GithubUserE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private Long requestCount;

    public GithubUserE(String login, Long requestCount) {
        this.login = login;
        this.requestCount = requestCount;
    }
}
