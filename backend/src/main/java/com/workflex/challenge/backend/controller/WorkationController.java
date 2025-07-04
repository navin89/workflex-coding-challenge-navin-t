package com.workflex.challenge.backend.controller;

import com.workflex.challenge.backend.dto.WorkationDTO;
import com.workflex.challenge.backend.mapper.WorkationMapper;
import com.workflex.challenge.backend.service.WorkationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workflex/workation")
@CrossOrigin // If needed for CORS
public class WorkationController {

    @Autowired
    private WorkationService workationService;

    // Example endpoint: /api/workations?sortBy=employee&direction=asc
    @GetMapping
    public List<WorkationDTO> getWorkations(
            @RequestParam(defaultValue = "workationId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return workationService.getAllWorkations(sortBy, direction)
                .stream()
                .map(WorkationMapper::toDto)
                .collect(Collectors.toList());
    }
}
