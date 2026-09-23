package demoapp;

import demoapp.service.ParService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ParServiceTest {

    @Autowired
    private ParService parService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(parService).isNotNull();
    }

    @Test
    public void testNumeroEsPar() throws Exception {
        assertThat(parService.esPar(4)).isTrue();
    }

    @Test
    public void testNumeroEsImpar() throws Exception {
        assertThat(parService.esPar(7)).isFalse();
    }
}