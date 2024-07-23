package com.app.agripulse.serviceImpl;

import com.app.agripulse.dtos.CommentDto;
import com.app.agripulse.exceptions.CommentNotFoundException;
import com.app.agripulse.exceptions.SomethingWentWrongException;
import com.app.agripulse.models.Comment;
import com.app.agripulse.repository.CommentRepository;
import com.app.agripulse.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

private final CommentRepository commentRepository;

public CommentServiceImpl(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
}

    @Override
    public List<CommentDto> getComments() {
        List<Comment> comments = commentRepository.findAll();

        if(comments.isEmpty()){
            throw new CommentNotFoundException("comments not found", null);
        }else{

            List<CommentDto> commentDtos = new ArrayList<>();

            for( Comment comment : comments){
                commentDtos.add(CommentDto.toDto(comment));
            }

            return commentDtos;
        }

    }

    @Override
    public CommentDto getCommentById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);

        if(comment.isPresent()){

            return CommentDto.toDto(comment.get());
        }else{
            throw new CommentNotFoundException("comment not found", id);
        }

    }



    @Override
    public CommentDto createComment(CommentDto commentDto) {

            Comment comment = CommentDto.toComment(commentDto);

            try {
                Comment savedComment = commentRepository.save(comment);
                return CommentDto.toDto(savedComment);
            }catch (Exception ex){
                throw new SomethingWentWrongException("Something went wrong while saving the comment. Please try again");
            }
    }

    @Override
    public CommentDto updateComment(Long id, CommentDto commentDto) {

        Optional<Comment> commentOpt = commentRepository.findById(id);
        if(commentOpt.isPresent()){
            Comment comment = commentOpt.get();
            comment.setComment(commentDto.getComment());

            try{
                Comment savedComment = commentRepository.save(comment);
                return CommentDto.toDto(savedComment);
            }catch (Exception ex) {
                throw new SomethingWentWrongException("Something went wrong while saving the comment. Please try again");
            }

        }else{
            throw new CommentNotFoundException("Comment not found", id);
        }
    }

    @Override
    public void deleteComment(Long id) {

    try{
        commentRepository.deleteById(id);
    }catch (Exception ex) {
        throw new SomethingWentWrongException("Something went wrong while deleting the comment. Please try again");
    }

    }
}
