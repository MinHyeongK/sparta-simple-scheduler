package min.project.controller;

import lombok.RequiredArgsConstructor;
import min.project.dto.ScheduleRequestDto;
import min.project.dto.ScheduleResponseDto;
import min.project.dto.SchedulesResponseDto;
import min.project.entity.Schedule;
import min.project.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){

        Schedule createdSchedule = scheduleService.createSchedule(scheduleRequestDto);

        return new ResponseEntity<>(new ScheduleResponseDto(createdSchedule), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findSchedule(@PathVariable Long id){

        return new ResponseEntity<>(new ScheduleResponseDto(scheduleService.findSchedule(id)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<SchedulesResponseDto> findAllScheduleByName(@RequestParam(required = false) String name){

        SchedulesResponseDto schedulesResponseDto = scheduleService.findAllScheduleByName(name);

        return new ResponseEntity<>(schedulesResponseDto, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,
                                                               @RequestBody ScheduleRequestDto dto){

        ScheduleResponseDto responseDto = scheduleService.updateSchedule(id, dto.getTitle(), dto.getName(), dto.getPassword());

        return new ResponseEntity<>(new ScheduleResponseDto(responseDto.getTitle(),responseDto.getName(), responseDto.getUpdatedAt()), HttpStatus.OK);
    }
}
