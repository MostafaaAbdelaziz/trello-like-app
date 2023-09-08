package com.csci3130_group11.group11_spring_boot.boards.controller;
import com.csci3130_group11.group11_spring_boot.boards.model.Boards;
import com.csci3130_group11.group11_spring_boot.boards.serviceImpl.BoardsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static java.util.Objects.isNull;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("board")
@CrossOrigin("*")
public class BoardsController {
    public static final String ID = "id";


    @Autowired
    private BoardsServiceImpl boardsService;

        @PostMapping("")
        public ResponseEntity<Map<String, Integer>> createBoard(@RequestBody Boards board) {
            Integer id = boardsService.createBoard(board);
            HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
            return status(status).body(singletonMap(ID, id));
        }
         @PostMapping(value = "/addBoard", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Boards> addBoards(@RequestBody Boards board){
        return new ResponseEntity<Boards>(boardsService.saveBoards(board), HttpStatus.OK);
    }


    @PutMapping("")
        public ResponseEntity<Map<String, Integer>> updateBoard (@RequestBody Boards board){
            Integer id = boardsService.createBoard(board);
            HttpStatus status = isNull(id) ? HttpStatus.CONFLICT : HttpStatus.CREATED;
            return status(status).body(singletonMap(ID, id));
        }

        @GetMapping("")
        public List<Boards> getBoard() {
            return boardsService.getBoards();
        }


        @DeleteMapping("/delete")
        @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
        public ResponseEntity<Boards> deleteBoards(@RequestParam int id){
            return new ResponseEntity<Boards>(boardsService.deleteBoardById(id), HttpStatus.OK);
        }
         @GetMapping("/getBoardById")
         @CrossOrigin(origins = "http://localhost:9001", allowedHeaders = "*")//to allow cross origin requests
        public ResponseEntity<Boards> getBoardById(@RequestParam int id){
             return new ResponseEntity<Boards> (boardsService.getBoardById(id), HttpStatus.OK);
        }

    @PutMapping(value = "/updateBoard/{id}", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Boards> updateBoard (@RequestBody Boards boards, @PathVariable("id") Integer id){
            return new ResponseEntity<Boards>(boardsService.updateBoard(boards, id), HttpStatus.OK);
        }

        @GetMapping(value = "/getAll")
        public List<Boards> getBoards () {
            return boardsService.getBoards();
        }
    }
