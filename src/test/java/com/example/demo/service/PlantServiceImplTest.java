package com.example.demo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
class PlantServiceImplTest {

    @InjectMocks
    private PlantServiceImpl plantServiceImpl;

    @Mock
    private RestTemplate restTemplate;

    String url = "http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=Oak";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetJsonString() {
        // arrange
        String expectedJson = "Some json string";
        ResponseEntity mocResponse = new ResponseEntity(expectedJson, HttpStatus.OK);

        // act
        when(restTemplate.getForEntity(url, String.class)).thenReturn(mocResponse);
        String actualJson = plantServiceImpl.getJson();

        // assert
        assertNotNull(actualJson);
        assertSame(expectedJson, actualJson);
    }
}