package com.example.webflux.repository;

import com.example.webflux.entity.Board;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BoardRepository extends ReactiveCrudRepository<Board, Long> {
}
