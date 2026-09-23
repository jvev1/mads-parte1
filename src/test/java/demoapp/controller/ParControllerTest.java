package demoapp.controller;

import demoapp.service.ParService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ParController.class)
public class ParControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParService parService;

    @Test
    public void testMostrarFormulario() throws Exception {
        this.mockMvc.perform(get("/comprobar-par"))
                .andExpect(status().isOk())
                .andExpect(view().name("comprobar-par"));
    }

    @Test
    public void testProcesarFormularioPar() throws Exception {
        given(this.parService.esPar(4)).willReturn(true);

        this.mockMvc.perform(post("/comprobar-par").param("numero", "4"))
                .andExpect(status().isOk())
                .andExpect(view().name("resultado-par"))
                .andExpect(content().string(containsString("es <strong>PAR</strong>")));
    }
}