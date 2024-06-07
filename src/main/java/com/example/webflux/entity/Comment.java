package com.example.webflux.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("COMMENTS")
public class Comment {
    @Id
    private Long commentId;
    private String commentAuthor;
    @Setter
    private String commentContent;
    private LocalDateTime commentCreatedAt;
    @Setter
    private LocalDateTime commentUpdatedAt;
    @Column("board_id")
    private Long boardId;
}
