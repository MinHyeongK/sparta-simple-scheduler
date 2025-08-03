package min.project.controller;

import lombok.RequiredArgsConstructor;
import min.project.dto.comment.CommentCreateRequestDto;
import min.project.dto.comment.CommentResponseDto;
import min.project.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{id}")
    public ResponseEntity<CommentResponseDto> createComment(@PathVariable Long id,
                                                            @RequestBody CommentCreateRequestDto dto){

        return new ResponseEntity<>(commentService.createComment(id, dto), HttpStatus.CREATED);
    }
}
