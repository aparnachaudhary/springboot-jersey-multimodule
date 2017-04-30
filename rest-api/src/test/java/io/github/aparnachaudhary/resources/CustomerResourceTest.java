package io.github.aparnachaudhary.resources;

import io.github.aparnachaudhary.CoreApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by aparna on 4/30/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerResourceTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testFindAll(){
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/rest-test/customers/", String.class);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}