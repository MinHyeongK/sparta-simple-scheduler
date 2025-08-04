package min.project.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import min.project.dto.schedule.*;
import min.project.entity.Comment;
import min.project.entity.Schedule;
import min.project.repository.CommentRepository;
import min.project.repository.ScheduleRepository;
import min.project.util.ValidationUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleCreateRequestDto dto){

        ValidationUtil.validateTitleLength(dto.getTitle());
        ValidationUtil.validateScheduleContentsLength(dto.getContents());
        ValidationUtil.isExistNameAndPassword(dto.getName(), dto.getPassword());

        Schedule schedule = scheduleRepository.save(dto.toCreateEntity());

        return new ScheduleResponseDto(schedule);
    }

    @Transactional(readOnly = true)
    public ScheduleFindResponseDto findSchedule(Long id){

        List<Comment> comments = commentRepository.findAllByScheduleId(id);

        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new NoSuchElementException("존재하지 않는 id값"));

        return new ScheduleFindResponseDto(schedule, comments);
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAllScheduleByName(String name){

        List<Schedule> fetchedSchedules = scheduleRepository.findAllByName(name);

        fetchedSchedules.sort(Comparator.comparing(Schedule::getCreatedAt).reversed());

        List<ScheduleResponseDto> schedules = new ArrayList<>();
        for (Schedule schedule : fetchedSchedules) {
            schedules.add(new ScheduleResponseDto(schedule));
        }

        return schedules;
    }

    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleUpdateRequestDto dto){
        ValidationUtil.isExistNameAndPassword(dto.getName(), dto.getPassword());
        ValidationUtil.validateTitleLength(dto.getTitle());

        Schedule schedule = scheduleRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id 없다고"));

        ValidationUtil.validatePassword(schedule.getPassword(), dto.getPassword());

        schedule.updateSchedule(dto.getName(), dto.getTitle());

        return new ScheduleResponseDto(scheduleRepository.saveAndFlush(schedule));
    }

    @Transactional
    public void deleteSchedule(Long id, String password){
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if(optionalSchedule.isPresent()){
            ValidationUtil.validatePassword(optionalSchedule.get().getPassword(), password);
            scheduleRepository.deleteById(id);
        }else throw new NoSuchElementException("해당 id를 찾을 수 없습니다.");
    }
}
