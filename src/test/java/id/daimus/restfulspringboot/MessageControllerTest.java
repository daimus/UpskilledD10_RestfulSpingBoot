package id.daimus.restfulspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void expectGetMessageResponseIsHelloWorld(){
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/v1/messages", HttpMethod.GET, HttpEntity.EMPTY, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello World", response.getBody());
    }

    @Test
    public void expectPostMessageResponseIsHelloWorld(){
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/v1/messages", HttpMethod.POST, HttpEntity.EMPTY, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello World", response.getBody());
    }

    @Test
    public void expectDeleteMessageResponseIsHelloWorld(){
        ResponseEntity<String> response = testRestTemplate.exchange("http://localhost:" + port + "/v1/messages", HttpMethod.DELETE, HttpEntity.EMPTY, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Hello World", response.getBody());
    }
}
