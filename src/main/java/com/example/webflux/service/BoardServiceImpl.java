package com.example.webflux.service;

import com.example.webflux.dto.BoardRequest;
import com.example.webflux.entity.Board;
import com.example.webflux.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    @Override
    public Mono<Board> save(BoardRequest board) {
        return boardRepository.save(board.toEntity());
    }

    @Override
    public Mono<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Flux<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Mono<Board> update(Long id, Board board) {
        return boardRepository.findById(id)
                .flatMap(existingBoard ->{
                    existingBoard.setBoardTitle(board.getBoardTitle());
                    existingBoard.setBoardContent(board.getBoardContent());
                    existingBoard.setBoardUpdatedAt(LocalDateTime.now());
                    return boardRepository.save(existingBoard);
                });
    }

    @Override
    public Mono<Void> deleteById(Long id) {
        return boardRepository.deleteById(id);
    }
}
