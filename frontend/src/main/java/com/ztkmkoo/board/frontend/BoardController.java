package com.ztkmkoo.board.frontend;

import com.ztkmkoo.board.frontend.entity.BoardContent;
import com.ztkmkoo.board.frontend.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "")
    public String board() {
        return "board";
    }

    @GetMapping(value = "/page/{page}/size/{size}")
    @ResponseBody
    public Object list(@PathVariable final int page, @PathVariable final int size){
        return boardService.loadBoardSummaryList(page, size);
    }

    @GetMapping(value = "/save")
    @ResponseBody
    public Object save() {
        return boardService.saveBoardContent(BoardContent
                .contentsBuilder()
                .author("Kebron")
                .tag("humor")
                .title("제목")
                .opened(new Date())
                .modified(new Date())
                .content("Test")
                .build());
    }
}
