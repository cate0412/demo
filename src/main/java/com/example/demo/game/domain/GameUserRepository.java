package com.example.demo.game.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GameUserRepository extends JpaRepository<GameUser, Integer> {
}
