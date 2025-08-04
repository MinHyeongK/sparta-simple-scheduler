package min.project.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationUtil {
    // Validation for schedule
    public static void validatePassword(String password, String targetPassword){
        if (!password.equals(targetPassword)) throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호 다르다.");
    }

    public static void validateTitleLength(String title){
        if (title.length() > 30) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "제목 글자 수 30자 제한");
    }

    public static void validateScheduleContentsLength(String contents){
        if (contents.length() > 200) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "내용 글자 수 200자 제한");
    }

    public static void isExistNameAndPassword(String name, String password){
        if (name == null || password == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "이름과 비밀번호는 필수");
    }

    // Validation for Comment
    public static void validateCommentContentsLength(String contents){
        if (contents.length() > 100) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "댓글 글자 수 100자 제한");
    }

    public static void validateCommentCountLimit(Long count){
        if (count > 9) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "댓글은 최대 10개다잉");
    }
}
