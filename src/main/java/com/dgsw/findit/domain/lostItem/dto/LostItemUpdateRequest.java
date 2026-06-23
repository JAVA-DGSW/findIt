package com.dgsw.findit.domain.lostItem.dto;

import com.dgsw.findit.domain.lostItem.entity.LostItemStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LostItemUpdateRequest {
    private String itemName;
    private String foundLocation;
    private String description;
    private LostItemStatus status;
}
