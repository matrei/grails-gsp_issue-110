# Using JSP in Grails
• JSPs must be located in `src/main/webapp/WEB-INF/grails-app/views`

• View paths must be explicitly declared `render(view: '/book/edit')`

Dependencies needed:
```groovy
implementation("org.grails.plugins:gsp:6.0.3") // At least 6.0.1
runtimeOnly("jstl:jstl:1.2")
runtimeOnly("org.apache.tomcat.embed:tomcat-embed-jasper")
runtimeOnly("org.grails:grails-web-jsp:6.0.3") // At least 6.0.1
```