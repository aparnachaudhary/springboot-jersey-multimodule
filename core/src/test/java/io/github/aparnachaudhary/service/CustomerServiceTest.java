package io.github.aparnachaudhary.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testFindAll(){
        assertEquals(0, customerService.list().size());
    }
}