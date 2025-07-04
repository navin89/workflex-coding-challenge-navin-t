package com.workflex.challenge.backend.dto;

import lombok.Data;

@Data
public class WorkationDTO {

    private String workationId;
    private String employee;
    private String origin;
    private String destination;
    private String start;
    private String end;
    private Integer workingDays;
    private String risk;
}
