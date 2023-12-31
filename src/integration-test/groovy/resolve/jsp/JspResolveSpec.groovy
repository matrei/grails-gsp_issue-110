package resolve.jsp


import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import spock.lang.Shared
import spock.lang.Specification

@Integration
class JspResolveSpec extends Specification {

    @Shared HttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client = HttpClient.create(baseUrl.toURL())
    }

    void 'test calling a controller that renders a JSP'() {
        when: 'going to the jsp controller'
            String resp = client.toBlocking().retrieve(HttpRequest.GET('/jsp/test'), String)

        then: 'the content is correct'
            resp.contains 'Hello from JSP'
    }

    void 'test direct url mapping to a JSP view'() {
        when: 'going to a jsp view directly'
            String resp = client.toBlocking().retrieve(HttpRequest.GET('/hello'), String)

        then: 'the content is correct'
            resp.contains 'Hello JSP'

    }

}
