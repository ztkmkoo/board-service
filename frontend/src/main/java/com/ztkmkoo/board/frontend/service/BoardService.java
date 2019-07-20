package com.ztkmkoo.board.frontend.service;

import com.ztkmkoo.board.frontend.entity.BoardContent;
import com.ztkmkoo.board.frontend.entity.BoardSummary;

import java.util.List;

public interface BoardService {

    List<BoardSummary> loadBoardSummaryList(final int page, final int size);

    BoardContent saveBoardContent(final BoardContent boardContent);
}
