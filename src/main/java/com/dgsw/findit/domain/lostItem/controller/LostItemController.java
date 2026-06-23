package com.dgsw.findit.domain.lostItem.controller;

import com.dgsw.findit.domain.lostItem.dto.LostItemCreateRequest;
import com.dgsw.findit.domain.lostItem.dto.LostItemUpdateRequest;
import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.service.LostItemService;
import com.dgsw.findit.global.common.ApiResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class LostItemController {
    private final LostItemService lostItemService;

    @PostMapping
    public ResponseEntity<ApiResponse<LostItemEntity>> createLostItem(@RequestBody LostItemCreateRequest request) {
        LostItemEntity lostItem = lostItemService.createLostItem(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(lostItem));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<LostItemEntity>>> getLostItems() {
        return ResponseEntity.ok(ApiResponse.success(lostItemService.getLostItems()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LostItemEntity>> getLostItem(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(lostItemService.getLostItem(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteLostItem(@PathVariable Long id) {
        lostItemService.deleteLostItem(id);
        return ResponseEntity.ok(ApiResponse.success());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LostItemEntity>> updateLostItem(
            @PathVariable Long id,
            @RequestBody LostItemUpdateRequest request
    ) {
        return ResponseEntity.ok(ApiResponse.success(lostItemService.updateLostItem(id, request)));
    }

    @PatchMapping("/{id}/return")
    public ResponseEntity<ApiResponse<LostItemEntity>> returnLostItem(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(lostItemService.returnLostItem(id)));
    }
}
