package com.ztkmkoo.board.frontend.service;

import com.ztkmkoo.board.frontend.entity.BoardContent;
import com.ztkmkoo.board.frontend.entity.BoardSummary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class BoardServiceImpl implements BoardService {

    private final List<BoardSummary> list = new ArrayList<>();

    @Override
    public List<BoardSummary> loadBoardSummaryList(final int page, final int size) {
        if (list.isEmpty())
            return Collections.emptyList();

        if (page < 1 || size < 1)
            return Collections.emptyList();

        final int startIndex = (page - 1) * size;
        if (list.size() <= startIndex)
            return Collections.emptyList();

        final int expectedEndIndex = startIndex + size;
        final int endIndex = (expectedEndIndex < list.size()) ? expectedEndIndex : list.size();
        return IntStream
                .range(startIndex, endIndex)
                .mapToObj(i -> list.get(i))
                .collect(Collectors.toList());
    }

    @Override
    public BoardContent saveBoardContent(final BoardContent boardContent) {
        list.add(boardContent);
        return boardContent;
    }
}
