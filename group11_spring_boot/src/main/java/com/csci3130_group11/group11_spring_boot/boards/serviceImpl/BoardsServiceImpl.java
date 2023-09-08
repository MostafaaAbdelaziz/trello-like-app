package com.csci3130_group11.group11_spring_boot.boards.serviceImpl;


import com.csci3130_group11.group11_spring_boot.boards.model.Boards;
import com.csci3130_group11.group11_spring_boot.boards.repository.BoardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardsServiceImpl {

    @Autowired
    BoardsRepository boardsRepository;

    public Boards updateBoard(Boards board, int id) {
        Optional<Boards> findBoard = boardsRepository.findById(id);
        if(findBoard.isPresent()) {
            findBoard.get().setName(board.getName());
            findBoard.get().setDescription(board.getDescription());
            boardsRepository.save(findBoard.get());
            return findBoard.get();
        }
        return new Boards();
    }

    public Boards saveBoards(Boards boards) {
        boards.setName(boards.getName());
        boards.setDescription(boards.getDescription());
        return boardsRepository.save(boards);
    }

    public Boards deleteBoardById(int id){
        Optional<Boards> board = boardsRepository.findById(id);
        if(board.isPresent()){
            boardsRepository.deleteById(id);
            return board.get();
        }
        return new Boards();
    }
    public Boards getBoardById(int id) {
        return boardsRepository.findById(id).get();
    }

    public Integer createBoard(Boards board) {
        return boardsRepository.save(board).getId();
    }

    public List<Boards> getBoards() {
        return boardsRepository.findAll();
    }

}

