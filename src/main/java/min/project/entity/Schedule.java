package min.project.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Schedule extends BaseTimeEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private String name;
    private String password;

    public Schedule(String title, String contents, String name, String password) {
        this.title = title;
        this.contents = contents;
        this.name = name;
        this.password = password;
    }

    public void updateSchedule(String name, String title) {
        this.name = name;
        this.title = title;
    }
}
