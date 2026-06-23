package com.dgsw.findit.domain.lostItem.service;

import com.dgsw.findit.domain.lostItem.dto.LostItemCreateRequest;
import com.dgsw.findit.domain.lostItem.dto.LostItemUpdateRequest;
import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.entity.LostItemStatus;
import com.dgsw.findit.domain.lostItem.exception.LostItemErrorCode;
import com.dgsw.findit.domain.lostItem.repository.LostItemRepository;
import com.dgsw.findit.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class LostItemService {
    private final LostItemRepository repository;

    @Transactional
    public LostItemEntity createLostItem(LostItemCreateRequest request) {
        LostItemEntity lostItem = new LostItemEntity();
        lostItem.setItemName(request.getItemName());
        lostItem.setFoundLocation(request.getFoundLocation());
        lostItem.setDescription(request.getDescription());
        lostItem.setStatus(LostItemStatus.STORED);

        return repository.save(lostItem);
    }

    public LostItemEntity getLostItem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new CustomException(LostItemErrorCode.LOST_ITEM_NOT_FOUND));
    }

    @Transactional
    public void deleteLostItem(Long id) {
        LostItemEntity item = repository.findById(id)
                .orElseThrow(() -> new CustomException(LostItemErrorCode.LOST_ITEM_NOT_FOUND));
        repository.delete(item);
    }

    @Transactional
    public LostItemEntity updateLostItem(Long id, LostItemUpdateRequest request) {
        LostItemEntity item = repository.findById(id)
                .orElseThrow(() -> new CustomException(LostItemErrorCode.LOST_ITEM_NOT_FOUND));
        item.setItemName(request.getItemName());
        item.setFoundLocation(request.getFoundLocation());
        item.setDescription(request.getDescription());
        item.setStatus(request.getStatus());
        return repository.save(item);
    }
}
