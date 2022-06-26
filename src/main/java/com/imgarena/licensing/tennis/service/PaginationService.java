package com.imgarena.licensing.tennis.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class PaginationService<T> {
    private final JpaRepository<T, ?> repository;

    public List<T> getPaginatedRecords(int pageNumber, int pageSize, JpaRepository<T, ?> repository) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<T> pagedResult = repository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
