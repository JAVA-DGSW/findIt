package com.dgsw.findit.domain.lostItem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LostItemCreateRequest {
    private String itemName;
    private String foundLocation;
    private String description;
}
