package min.project.repository;

import min.project.dto.ScheduleResponseDto;
import min.project.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByName(String name);
}
