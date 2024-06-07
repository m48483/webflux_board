package com.example.webflux.controller;

import com.example.webflux.entity.Comment;
import com.example.webflux.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards/{bid}/comments")
public class CommentController {
    private final CommentService commentService;
    @GetMapping
    public Flux<Comment> getComments(@PathVariable("bid") Long boardId){
        return commentService.findAllByBoardId(boardId);
    }
    @PostMapping
    public Mono<Comment> createComment(@PathVariable("bid") Long boardId,
                                       @RequestBody Comment comment) {
        return commentService.save(boardId, comment);
    }

    @PutMapping("/{id}")
    public Mono<Comment> updateComment(@PathVariable("id") Long commentId,
                                       @RequestBody Comment comment) {
        return commentService.update(commentId, comment);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteComment(@PathVariable("id") Long commentId) {
        return commentService.delete(commentId);
    }
}
