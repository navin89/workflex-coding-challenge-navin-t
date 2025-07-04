package com.workflex.challenge.backend.service;

import com.workflex.challenge.backend.model.Workation;
import com.workflex.challenge.backend.repository.WorkationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class WorkationServiceTest {

    @Mock
    private WorkationRepository workationRepository;

    @InjectMocks
    private WorkationService workationService;

    public WorkationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllWorkations_returnsSortedResult() {
        Workation w1 = new Workation("w5", "Jane", "Berlin", "Lisbon", null, null, 10, "NO_RISK");
        List<Workation> workations = List.of(w1);

        when(workationRepository.findAll(Sort.by(Sort.Direction.ASC, "employee"))).thenReturn(workations);

        List<Workation> result = workationService.getAllWorkations("employee", "asc");
        assertEquals(1, result.size());
        assertEquals("Jane", result.get(0).getEmployee());
    }
}
