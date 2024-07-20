package com.alljobs.meetings; // Adjust the package to match your application's structure

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MeetingsApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    public void contextLoads() {
        assertThat(context).isNotNull();
    }
}
