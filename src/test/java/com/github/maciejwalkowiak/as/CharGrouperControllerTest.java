package com.github.maciejwalkowiak.as;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest("server.port:0")
public class CharGrouperControllerTest {
    @Value("${local.server.port}")
    private int serverPort;

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void shouldReturnCorrectResultViaHttpCall() {
        // given
        String input = "abzuaaissna";
        String expected = "a4bins2uz";

        // when
        String result = restTemplate.getForObject("http://localhost:" + serverPort + "/group?input={input}", String.class, input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}
