package com.workflex.challenge.backend.config;

import com.workflex.challenge.backend.exception.CsvImportException;
import com.workflex.challenge.backend.model.Workation;
import com.workflex.challenge.backend.repository.WorkationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Component
public class WorkationCsvImporter implements ApplicationRunner {

    @Autowired
    private WorkationRepository workationRepository;

    @Override
    public void run(ApplicationArguments args) {
        if (workationRepository.count() == 0) {
            try (
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(Objects.requireNonNull(getClass().getResourceAsStream("/data/workations.csv")))
                    )
            ) {
                String line;
                boolean isHeader = true;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }
                    String[] parts = line.split(",");
                    if (parts.length < 8) continue;

                    Workation w = new Workation(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            LocalDate.parse(parts[4], formatter),
                            LocalDate.parse(parts[5], formatter),
                            Integer.parseInt(parts[6]),
                            parts[7]
                    );
                    workationRepository.save(w);
                }
                System.out.println("Imported " + workationRepository.count() + " workations from CSV into H2 In-Memory-DB.");
            } catch (Exception e) {
                throw new CsvImportException("Failed to import workations from CSV", e);
            }
        }
    }
}

