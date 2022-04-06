package com.empik.recrutingtask.githubuser

import com.empik.recrutingtask.githubuser.dto.GithubUserResponseDto
import spock.lang.Specification

class GithubUserServiceTest extends Specification {

    private GithubUserService service
    private GithubUserRepository repository
    private GithubClientService clientService

    def setup() {
        repository = Mock(GithubUserRepository)
        clientService = Mock(GithubClientService)
        service = new GithubUserService(repository, clientService)
    }

    def "should add calculation to dto"(followers, publicRepos, calculationResult) {
        given:
        def login = "login"
        def resultDto = new GithubUserResponseDto(followers: followers, publicRepos: publicRepos, login: login)
        def count = 6
        def user = new GithubUserE(login: login, requestCount: count)
        1 * clientService.getByLogin(login) >> resultDto
        1 * repository.findByLogin(login) >> user

        when:
        def responseUserDto = service.getOne(login)

        then:
        responseUserDto.login == login
        responseUserDto.calculations == calculationResult
        1 * repository.save(user)

        where:
        followers | publicRepos | calculationResult
        0         | 1           | 0.0
        12        | null        | 0.0
        5         | 5           | 8.4
        8         | 0           | 1.5
    }
}
