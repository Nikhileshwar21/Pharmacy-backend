package com.code.userservice;

import com.code.userservice.controller.UserController;
import com.code.userservice.entity.Drugs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
public class RestTemplateTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private UserController userController = new UserController();

    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Drugs drug = new Drugs("drug4", 6,"A4","05/05/2022",25);
        Mockito
                .when(restTemplate.getForEntity("http://localhost:9091/user/getdrugs/4",Drugs.class))
          .thenReturn(new ResponseEntity(drug, HttpStatus.OK));

        Drugs drugs = userController.getdrugs("4");
        Assertions.assertEquals(drug, drugs);
    }


}