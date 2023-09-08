package com.csci3130_group11.group11_spring_boot.boards.repository;

import com.csci3130_group11.group11_spring_boot.boards.model.Boards;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardsRepository extends JpaRepository<Boards, Integer> {

}

