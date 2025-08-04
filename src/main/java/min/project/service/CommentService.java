package min.project.service;

import lombok.RequiredArgsConstructor;
import min.project.dto.comment.CommentCreateRequestDto;
import min.project.dto.comment.CommentResponseDto;
import min.project.entity.Comment;
import min.project.repository.CommentRepository;
import min.project.util.ValidationUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(Long scheduleId, CommentCreateRequestDto dto){

        ValidationUtil.validateCommentContentsLength(dto.getContents());
        ValidationUtil.validateCommentCountLimit(commentRepository.countAllByScheduleId(scheduleId));

        return new CommentResponseDto(commentRepository.save(new Comment(dto, scheduleId)));
    }
}
