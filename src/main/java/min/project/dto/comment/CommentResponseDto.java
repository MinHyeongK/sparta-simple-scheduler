package min.project.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Comment;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private final String comments;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public CommentResponseDto(Comment comment){
        this.comments = comment.getContents();
        this.name = comment.getName();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
    }
}
