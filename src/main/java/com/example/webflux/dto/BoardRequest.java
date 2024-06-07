package com.example.webflux.dto;

import com.example.webflux.entity.Board;

import java.time.LocalDateTime;

public record BoardRequest(
        String boardTitle,
        String boardContent,
        String boardAuthor
) {
    public Board toEntity(){
        return Board.builder()
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .boardAuthor(boardAuthor)
                .boardCreatedAt(LocalDateTime.now())
                .boardUpdatedAt(LocalDateTime.now())
                .build();
    }
}
