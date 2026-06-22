package com.dgsw.findit.domain.lostItem.controller;

import com.dgsw.findit.domain.lostItem.dto.LostItemCreateRequest;
import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.service.LostItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LostItemController {
    private final LostItemService lostItemService;

    @PostMapping("/items")
    public ResponseEntity<LostItemEntity> createLostItem(@RequestBody LostItemCreateRequest request) {
        LostItemEntity lostItem = lostItemService.createLostItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(lostItem);
    }
}
