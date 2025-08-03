package min.project.dto.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentCreateRequestDto {
    private final String contents;
    private final String name;
    private final String password;
}
