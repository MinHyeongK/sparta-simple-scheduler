package min.project.dto.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import min.project.entity.Schedule;

@Getter
@NoArgsConstructor
public class ScheduleCreateRequestDto {
    private String title;
    private String contents;
    private String name;
    private String password;

    public Schedule toCreateEntity(){
        return new Schedule(getTitle(), getContents(), getName(), getPassword());
    }
}
