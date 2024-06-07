package com.example.webflux.service;

import com.example.webflux.entity.Comment;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentService {
    Mono<Comment> save(Long boardId, Comment comment);
    Flux<Comment> findAllByBoardId(Long boardId);
    Mono<Comment> update(Long commentId, Comment comment);
    Mono<Void> delete(Long commentId);
}
