package com.app.agripulse.controller;

import com.app.agripulse.dtos.CommentDto;
import com.app.agripulse.services.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

private final CommentService commentService;

    public CommentController(CommentService commentService) {
    this.commentService = commentService;

    }

    @GetMapping("/")
    public ResponseEntity<List<CommentDto>> getAllComments() {
        List<CommentDto> dtos =  commentService.getComments();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable Long id) {
        CommentDto commentDto = commentService.getCommentById(id);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {
        CommentDto savedCommentDto = commentService.createComment(commentDto);
        return new ResponseEntity<>(savedCommentDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable Long id, @RequestBody CommentDto commentDto) {

        CommentDto UpdatedComment = commentService.updateComment(id, commentDto);
        return new ResponseEntity<>(UpdatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
