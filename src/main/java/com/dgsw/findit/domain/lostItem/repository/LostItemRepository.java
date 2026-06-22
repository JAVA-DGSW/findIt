package com.dgsw.findit.domain.lostItem.repository;

import com.dgsw.findit.domain.lostItem.entity.LostItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostItemRepository extends JpaRepository<LostItemEntity, Long> {
}
