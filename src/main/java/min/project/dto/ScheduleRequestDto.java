package min.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String name;
    private String password;
}
