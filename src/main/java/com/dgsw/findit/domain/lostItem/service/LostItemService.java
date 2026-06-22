package com.dgsw.findit.domain.lostItem.service;

import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import com.dgsw.findit.domain.lostItem.repository.LostItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LostItemService {
    private final LostItemRepository repository;

    public LostItemEntity getLostItem(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("분실물을 찾을 수 없습니다."));
    }
}
