package com.workflex.challenge.backend.model;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "workation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Workation {

    @Id
    @Column(name = "workation_id")
    private String workationId; // Primary key from CSV

    @Column(name = "employee")
    private String employee;

    @Column(name = "origin")
    private String origin;

    @Column(name = "destination")
    private String destination;

    @Column(name = "start")
    private LocalDate start;

    @Column(name = "\"end\"")
    private LocalDate end;

    @Column(name = "working_days")
    private Integer workingDays;

    @Column(name = "risk")
    private String risk;
}
