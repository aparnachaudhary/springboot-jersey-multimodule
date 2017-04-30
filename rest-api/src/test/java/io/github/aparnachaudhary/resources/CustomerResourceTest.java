package io.github.aparnachaudhary.resources;

import io.github.aparnachaudhary.CoreApplication;
import io.github.aparnachaudhary.entities.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 */
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerResourceTest {

    public static final String CUSTOMER_RESOURCE_PATH = "/rest/customers/";

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testCreate() {

        URI url = testRestTemplate.postForLocation(CUSTOMER_RESOURCE_PATH, new Customer("Foo", "Bar"));

        assertThat(url.getPath()).contains(CUSTOMER_RESOURCE_PATH);
        Customer customer = testRestTemplate.getForObject(url, Customer.class);
        assertThat(customer.getFirstname()).isEqualTo("Foo");
        assertThat(customer.getLastname()).isEqualTo("Bar");
    }

    @Test
    public void testFindAll() {
        ResponseEntity<String> responseEntity = testRestTemplate.getForEntity(CUSTOMER_RESOURCE_PATH, String.class);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful());
    }
}