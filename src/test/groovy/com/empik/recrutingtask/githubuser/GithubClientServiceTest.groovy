package com.empik.recrutingtask.githubuser

import com.empik.recrutingtask.githubuser.dto.GithubUserResponseDto
import spock.lang.Specification


class GithubClientServiceTest extends Specification {

    private GithubClientService service

    def setup() {
        service = new GithubClientService()
    }

    def "test"() {
        given:
        def login = "Tomasz3pis" //existing login

        when:
        def user = service.getByLogin(login)

        then:
        assertUser(user)
    }

    void assertUser(GithubUserResponseDto user) {
        assert user.id
        assert user.login
        assert user.type
    }
}
