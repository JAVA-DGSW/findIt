package com.dgsw.findit.domain.lostItem.controller;

import com.dgsw.findit.domain.lostItem.dto.LostItemCreateRequest;
import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class LostItemController {
    private final LostItemService service;

    @PostMapping
    public ResponseEntity<LostItemEntity> createLostItem(@RequestBody LostItemCreateRequest request) {
        LostItemEntity lostItem = service.createLostItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(lostItem);
    }

    @GetMapping("/{id}")
    public LostItemEntity getLostItem(@PathVariable Long id) {
        return service.getLostItem(id);
    }
}
