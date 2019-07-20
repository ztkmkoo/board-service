package com.ztkmkoo.board.frontend.entity;

import lombok.*;

import java.util.Date;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BoardContent extends BoardSummary {

    private String content;

    @Builder(builderMethodName = "contentsBuilder")
    public BoardContent(String content, Long seq, String tag,String title,String author,Date opened,Date modified) {
        super(seq, tag, title, author, opened, modified);
        this.content = content;
    }
}
