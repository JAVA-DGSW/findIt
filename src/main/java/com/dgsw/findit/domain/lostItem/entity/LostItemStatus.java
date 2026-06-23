package com.dgsw.findit.domain.lostItem.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LostItemStatus {

    STORED("보관중"),
    RETURNED("반환완료");

    private final String displayName;
}
