package com.example.webflux.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("BOARDS")
public class Board {
    @Id
    private Long boardId;
    private String boardAuthor;
    @Setter
    private String boardTitle;
    @Setter
    private String boardContent;
    private LocalDateTime boardCreatedAt;
    @Setter
    private LocalDateTime boardUpdatedAt;
}
