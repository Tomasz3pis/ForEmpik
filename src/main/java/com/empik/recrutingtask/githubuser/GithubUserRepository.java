package com.empik.recrutingtask.githubuser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GithubUserRepository extends JpaRepository<GithubUserE, Long> {

    GithubUserE findByLogin(String login);
}