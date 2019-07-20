package com.ztkmkoo.board.frontend.entity;

import lombok.*;

import java.util.Date;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class BoardSummary {

    private Long seq;
    private String tag;
    private String title;
    private String author;
    private Date opened;
    private Date modified;
}
