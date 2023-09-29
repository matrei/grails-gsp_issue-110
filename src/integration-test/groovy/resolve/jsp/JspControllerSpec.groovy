package resolve.jsp


import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import spock.lang.Shared
import spock.lang.Specification

@Integration
class JspControllerSpec extends Specification {

    @Shared HttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client = HttpClient.create(baseUrl.toURL())
    }

    void 'test something'() {
        when: 'going to the jsp controller'
            String resp = client.toBlocking().retrieve(HttpRequest.GET('/jsp/test'), String)

        then: 'The title is correct'
            resp.contains 'Hello from JSP'
    }

}
