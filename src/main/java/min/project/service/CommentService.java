package min.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import min.project.dto.comment.CommentCreateRequestDto;
import min.project.dto.comment.CommentCreateResponseDto;
import min.project.entity.Comment;
import min.project.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentCreateResponseDto createComment(Long scheduleId, CommentCreateRequestDto dto){

        if(commentRepository.countAllByScheduleId(scheduleId) > 9) {
            throw new IllegalStateException("댓글은 최대 10개다잉");
        }

        return new CommentCreateResponseDto(commentRepository.save(new Comment(dto, scheduleId)));
    }
}
