package min.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import min.project.dto.comment.CommentCreateRequestDto;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;
    private String name;
    private String password;
    private Long scheduleId;

    public Comment(CommentCreateRequestDto dto, Long scheduleId) {
        this.contents = dto.getContents();
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.scheduleId = scheduleId;
    }
}
