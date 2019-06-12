package kr.ac.jejunu.educom.yechankim.dto;

import lombok.Data;

@Data
public class BoardDto {
    private int boardIdx;
    private String title;
    private String contents;
    private int hitCnt;
    private String creatorId;
    private String createdDatetime;
    private String updatedDatetime;
}
