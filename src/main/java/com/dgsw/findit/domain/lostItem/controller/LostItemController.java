package com.dgsw.findit.domain.lostItem.controller;

import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.service.LostItemService;
import com.dgsw.findit.global.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class LostItemController {
    private final LostItemService lostItemService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LostItemEntity>> getLostItem(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(lostItemService.getLostItem(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLostItem(@PathVariable Long id) {
        lostItemService.deleteLostItem(id);
        return ResponseEntity.ok(ApiResponse.success());
    }
}
