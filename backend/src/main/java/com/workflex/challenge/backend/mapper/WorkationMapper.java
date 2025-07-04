package com.workflex.challenge.backend.mapper;

import com.workflex.challenge.backend.dto.WorkationDTO;
import com.workflex.challenge.backend.model.Workation;

import java.time.format.DateTimeFormatter;

public class WorkationMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static WorkationDTO toDto(Workation w) {
        WorkationDTO dto = new WorkationDTO();
        dto.setWorkationId(w.getWorkationId());
        dto.setEmployee(w.getEmployee());
        dto.setOrigin(w.getOrigin());
        dto.setDestination(w.getDestination());
        dto.setStart(w.getStart() != null ? w.getStart().format(FORMATTER) : null);
        dto.setEnd(w.getEnd() != null ? w.getEnd().format(FORMATTER) : null);
        dto.setWorkingDays(w.getWorkingDays());
        dto.setRisk(w.getRisk());
        return dto;
    }
}
