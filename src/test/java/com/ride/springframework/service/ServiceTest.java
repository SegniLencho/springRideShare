package com.ride.springframework.service;

/**
 * Created by OD on 6/21/2017.
 */


import com.ride.springframework.controllers.PostController;
import com.ride.springframework.services.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    private PostService service;

    @Test
    public void contexLoads() throws Exception {
        assertThat(service).isNotNull();
    }

    @Test
    public void methodreturntrue() throws Exception {
        assertThat(service).isNotNull();
    }
}