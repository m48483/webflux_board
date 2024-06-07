package com.example.webflux.repository;

import com.example.webflux.entity.Comment;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CommentRepository extends ReactiveCrudRepository<Comment, Long> {
    Flux<Comment> findByBoardId(Long boardId);
    Mono<Void> deleteByBoardIdAndCommentId(Long boardId, Long id);
}
