package min.project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ScheduleDeleteRequestDto {
    private String password;

    public ScheduleDeleteRequestDto(String password) {
        this.password = password;
    }
}
