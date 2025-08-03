package min.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleUpdateRequestDto {
    private final String title;
    private final String name;
    private final String password;

    public Schedule toUpdateEntity(){
        return new Schedule(getTitle(), getName(), getPassword());
    }
}
