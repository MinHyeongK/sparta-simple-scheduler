package min.project.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ValidationService {

    public static void validate(String password, String targetPassword){
        if (!password.equals(targetPassword)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "비밀번호 다르다.");
        }
    }
}
