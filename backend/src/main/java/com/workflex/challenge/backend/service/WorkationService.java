package com.workflex.challenge.backend.service;

import com.workflex.challenge.backend.model.Workation;
import com.workflex.challenge.backend.repository.WorkationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkationService {

    @Autowired
    private WorkationRepository workationRepository;

    public List<Workation> getAllWorkations(String sortBy, String direction) {
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sortBy);
        return workationRepository.findAll(sort);
    }
}
