package com.dgsw.findit.domain.lostItem.exception;

import com.dgsw.findit.global.exception.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LostItemErrorCode implements ErrorCode {

    LOST_ITEM_NOT_FOUND(404, "분실물을 찾을 수 없습니다.");

    private final int status;
    private final String message;
}
