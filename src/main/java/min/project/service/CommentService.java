package min.project.service;

import lombok.RequiredArgsConstructor;
import min.project.dto.comment.CommentCreateRequestDto;
import min.project.dto.comment.CommentResponseDto;
import min.project.entity.Comment;
import min.project.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(Long scheduleId, CommentCreateRequestDto dto){

        if(commentRepository.countAllByScheduleId(scheduleId) > 9) {
            throw new IllegalStateException("댓글은 최대 10개다잉");
        }

        return new CommentResponseDto(commentRepository.save(new Comment(dto, scheduleId)));
    }
}
