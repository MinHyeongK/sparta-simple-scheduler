package min.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import min.project.entity.Schedule;

@Getter
@AllArgsConstructor
public class ScheduleRequestDto {
    private String title;
    private String contents;
    private String name;
    private String password;

    public Schedule toEntity(ScheduleRequestDto dto){
        return new Schedule(dto.getTitle(), dto.getContents(), dto.getName(), dto.getPassword());
    }

    public String fromJason(String password){
        return getPassword();
    }
}
