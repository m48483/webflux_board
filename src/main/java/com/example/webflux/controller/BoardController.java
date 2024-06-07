package com.example.webflux.controller;

import com.example.webflux.dto.BoardRequest;
import com.example.webflux.entity.Board;
import com.example.webflux.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public Flux<Board> getBoards() {
        return boardService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Board> getBoard(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PostMapping
    public Mono<Board> createBoard(@RequestBody BoardRequest board) {
        return boardService.save(board);
    }

    @PutMapping("/{id}")
    public Mono<Board> updateBoard(@PathVariable Long id, @RequestBody Board board) {
        return boardService.update(id, board);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteBoard(@PathVariable Long id) {
        return boardService.deleteById(id);
    }
}
