package com.dgsw.findit.domain.lostItem.service;

import com.dgsw.findit.domain.lostItem.dto.LostItemCreateRequest;
import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.repository.LostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LostItemService {
    private final LostItemRepository lostItemRepository;

    public LostItemEntity createLostItem(LostItemCreateRequest request) {
        LostItemEntity lostItem = new LostItemEntity();
        lostItem.setItemName(request.getItemName());
        lostItem.setFoundLocation(request.getFoundLocation());
        lostItem.setDescription(request.getDescription());
        lostItem.setStatus("보관중");

        return lostItemRepository.save(lostItem);
    }
}
