package com.dgsw.findit.domain.lostItem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="lost_item")
public class LostItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 물건 고유 아이디
    private String itemName; // 물건명
    private String foundLocation; // 발견 장소
    private String description; // 설명
    private String status; // 물건 상태
}
