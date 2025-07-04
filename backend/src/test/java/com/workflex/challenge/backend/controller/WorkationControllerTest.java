package com.workflex.challenge.backend.controller;

import com.workflex.challenge.backend.model.Workation;
import com.workflex.challenge.backend.service.WorkationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Collections;

import static org.mockito.Mockito.when;

@WebMvcTest(WorkationController.class)
public class WorkationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private WorkationService workationService;

    @Test
    void getWorkations_returnsOkWithJson() throws Exception {
        Workation w1 = new Workation("w1", "Jane", "Berlin", "Lisbon", null, null, 10, "NO_RISK");
        when(workationService.getAllWorkations("employee", "asc"))
                .thenReturn(Collections.singletonList(w1));

        mockMvc.perform(get("/workflex/workation")
                        .param("sortBy", "employee")
                        .param("direction", "asc"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].employee").value("Jane"));
    }
}
