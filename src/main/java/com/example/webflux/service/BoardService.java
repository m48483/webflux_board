package com.example.webflux.service;


import com.example.webflux.dto.BoardRequest;
import com.example.webflux.entity.Board;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BoardService {
    Mono<Board> save(BoardRequest board);
    Mono<Board> findById(Long id);
    Flux<Board> findAll();
    Mono<Board> update(Long id, Board board);
    Mono<Void> deleteById(Long id);
}
