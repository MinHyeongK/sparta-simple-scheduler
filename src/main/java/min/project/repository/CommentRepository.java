package min.project.repository;

import min.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Long countAllByScheduleId(Long scheduleId);

    List<Comment> findAllByScheduleId(Long scheduleId);
}
