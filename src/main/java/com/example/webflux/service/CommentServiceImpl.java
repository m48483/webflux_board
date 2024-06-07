package com.example.webflux.service;

import com.example.webflux.entity.Comment;
import com.example.webflux.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    @Override
    public Mono<Comment> save(Long boardId, Comment comment) {
        Comment saveComment = Comment.builder()
                .boardId(boardId)
                .commentAuthor(comment.getCommentAuthor())
                .commentContent(comment.getCommentContent())
                .commentCreatedAt(LocalDateTime.now())
                .commentUpdatedAt(LocalDateTime.now())
                .build();
        return commentRepository.save(saveComment);
    }

    @Override
    public Flux<Comment> findAllByBoardId(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }

    @Override
    public Mono<Comment> update(Long commentId, Comment comment) {
        return commentRepository.findById(commentId)
                .flatMap(existingComment ->{
                    existingComment.setCommentContent(comment.getCommentContent());
                    existingComment.setCommentUpdatedAt(LocalDateTime.now());
                return commentRepository.save(existingComment);
                });
    }

    @Override
    public Mono<Void> delete(Long commentId) {
        return commentRepository.deleteById(commentId);
    }
}
