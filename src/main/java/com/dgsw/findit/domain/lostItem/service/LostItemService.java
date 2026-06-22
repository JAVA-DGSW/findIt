package com.dgsw.findit.domain.lostItem.service;

import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.exception.LostItemErrorCode;
import com.dgsw.findit.domain.lostItem.repository.LostItemRepository;
import com.dgsw.findit.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LostItemService {
    private final LostItemRepository repository;

    public LostItemEntity getLostItem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException(LostItemErrorCode.LOST_ITEM_NOT_FOUND));
    }

    public void deleteLostItem(Long id) {
        LostItemEntity item = repository.findById(id)
                .orElseThrow(() -> new CustomException(LostItemErrorCode.LOST_ITEM_NOT_FOUND));
        repository.delete(item);
    }
}
