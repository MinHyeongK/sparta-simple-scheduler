# 프로젝트 개요
- 프로젝트 목적: 공부
- 주요 학습 목표: 3 Layer Architecture, CRUD, JPA 학습

---

## 기술 스택
- Language: Java 17
- Framework: Spring Boot 3.5.4
- Web Framework: Spring Web
- ORM: Spring Data JPA, Hibernate
- Build Tool: Gradle
- DATABASE: MySQL
- IDE: Intellij IDEA
- Annotation: Lombok
---

## 주요 기능
- 일정 생성
- 일정 조회(단건, 전체)
- 일정 수정
- 일정 삭제
- 댓글 작성

---

## 디렉터리 구조
```
src/
└── main/
├── java/
│   └── min/project/
│       ├── controller/              # REST API 컨트롤러
│       │   ├── CommentController.java
│       │   └── ScheduleController.java
│       ├── dto/                     # 요청/응답 DTO
│       │   ├── comment/
│       │   │   ├── CommentCreateRequestDto.java
│       │   │   └── CommentResponseDto.java
│       │   └── schedule/
│       │       ├── ScheduleCreateRequestDto.java
│       │       ├── ScheduleDeleteRequestDto.java
│       │       ├── ScheduleFindResponseDto.java
│       │       ├── ScheduleResponseDto.java
│       │       └── ScheduleUpdateRequestDto.java
│       ├── entity/                  # JPA 엔티티
│       │   ├── BaseTimeEntity.java
│       │   ├── Comment.java
│       │   └── Schedule.java
│       ├── repository/              # JPA 레포지토리 인터페이스
│       │   ├── CommentRepository.java
│       │   └── ScheduleRepository.java
│       ├── service/                 # 비즈니스 로직
│       │   ├── CommentService.java
│       │   └── ScheduleService.java
│       ├── util/                    # 유틸리티 클래스
│       │   └── ValidationUtil.java
│       └── ProjectApplication.java  # SpringBoot 애플리케이션 실행 클래스
└── resources/
├── static/                      # 정적 리소스 (js, css 등)
├── templates/                   # 템플릿 (html 등)
└── application.yml              # 환경 설정 파일
```
---

## 실행 방법
- ProjectApplication 클래스 main 메서드 실행

---

## 트러블 슈팅
- https://studyroom-kmh.tistory.com/79

---

## API 명세서
| 기능       | Method | URL 형식                        | URL 예시                       | Request 예시                                                                                                  | Response 예시                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| -------- | ------ |-------------------------------|------------------------------|-------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 일정 등록    | POST   | `/api/schedules`| `/api/schedules`| <pre>{<br>  "title": "제목",<br>  "contents": "내용",<br>  "name": "작성자 이름",<br>  "password": "비밀번호"<br>}</pre> | <pre>{<br>  "id": 1,<br>  "title": "제목",<br>  "contents": "내용",<br>  "name": "작성자 이름",<br>  "createdAt": "2025-08-04T12:49:21.7473327",<br>  "updatedAt": "2025-08-04T12:49:21.7473327"<br>}</pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               |
| 단건 일정 조회 | GET    | `/api/schedules/{id}`| `/api/schedules/1`| ...                                                                                                         | <pre>{<br>&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;"title": "제목",<br>&nbsp;&nbsp;"contents": "내용",<br>&nbsp;&nbsp;"name": "작성자 이름",<br>&nbsp;&nbsp;"createdAt": "2025-08-04T12:52:34.401981",<br>&nbsp;&nbsp;"updatedAt": "2025-08-04T12:52:34.401981",<br>&nbsp;&nbsp;"comments": [<br>&nbsp;&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"createdAt": "2025-08-04T12:52:54.768512",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"updatedAt": "2025-08-04T12:52:54.768512",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"contents": "내용",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "작성자 이름",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "비밀번호",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"scheduleId": 1<br>&nbsp;&nbsp;&nbsp;&nbsp;},<br>&nbsp;&nbsp;&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"createdAt": "2025-08-04T12:52:55.689511",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"updatedAt": "2025-08-04T12:52:55.689511",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"id": 2,<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"contents": "내용",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"name": "작성자 이름",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"password": "비밀번호",<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"scheduleId": 1<br>&nbsp;&nbsp;&nbsp;&nbsp;}<br>&nbsp;&nbsp;]<br>}</pre> |
| 전체 일정 조회 | GET    | `/api/schedules?name={name}`| `/api/schedules?name=작성자 이름` | `?name=작성자 이름`                                                                                              | <pre>[<br>&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 2,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "제목",<br>&nbsp;&nbsp;&nbsp;&nbsp;"contents": "내용",<br>&nbsp;&nbsp;&nbsp;&nbsp;"name": "작성자 이름",<br>&nbsp;&nbsp;&nbsp;&nbsp;"createdAt": "2025-08-04T12:58:52.787925",<br>&nbsp;&nbsp;&nbsp;&nbsp;"updatedAt": "2025-08-04T12:58:52.787925"<br>&nbsp;&nbsp;},<br>&nbsp;&nbsp;{<br>&nbsp;&nbsp;&nbsp;&nbsp;"id": 1,<br>&nbsp;&nbsp;&nbsp;&nbsp;"title": "제목",<br>&nbsp;&nbsp;&nbsp;&nbsp;"contents": "내용",<br>&nbsp;&nbsp;&nbsp;&nbsp;"name": "작성자 이름",<br>&nbsp;&nbsp;&nbsp;&nbsp;"createdAt": "2025-08-04T12:52:34.401981",<br>&nbsp;&nbsp;&nbsp;&nbsp;"updatedAt": "2025-08-04T12:52:34.401981"<br>&nbsp;&nbsp;}<br>]</pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| 일정 수정    | PATCH  | `/api/schedules/{id}`| `/api/schedules/1`| <pre>{<br>  "title": "수정한 제목",<br>  "name": "수정한 작성자 이름",<br>  "password": "비밀번호"<br>}</pre>                | <pre>{<br>  "id": 1,<br>  "title": "수정한 제목",<br>  "contents": "내용",<br>  "name": "수정한 작성자 이름",<br>  "createdAt": "2025-08-04T12:52:34.401981",<br>  "updatedAt": "2025-08-04T13:11:10.0923244"<br>}</pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| 일정 삭제    | DELETE | `/api/schedules/{id}`| `/api/schedules/1`| <pre>{<br>  "password": "password"<br>}</pre>                                                               | ...                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| 댓글 등록    | POST   | `/api/schedules/{scheduleId}` | `/api/schedules/1`| <pre>{<br>  "contents": "내용",<br>  "name": "작성자 이름",<br>  "password": "비밀번호"<br>}</pre>                     | <pre>{<br>  "id": 1,<br>  "comments": "내용",<br>  "name": "작성자 이름",<br>  "createdAt": "2025-08-04T12:52:55.6895111",<br>  "updatedAt": "2025-08-04T12:52:55.6895111"<br>}</pre>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |

---

## ERD

### schedule
| 컬럼명          | 타입           | 제약조건                | 설명    |
| ------------ | ------------ | ------------------- | ----- |
| id           | BIGINT       | PK, AUTO\_INCREMENT | 식별자   |
| name         | VARCHAR(255) | NOT NULL            | 작성자명  |
| password     | VARCHAR(255) | NOT NULL            | 비밀번호  |
| title        | VARCHAR(500) | NOT NULL            | 일정 제목 |
| contents     | TEXT         | NOT NULL            | 일정 내용 |
| created\_at  | TIMESTAMP    | NOT NULL            | 작성일   |
| modified\_at | TIMESTAMP    | NOT NULL            | 수정일   |

### comment
| 컬럼명          | 타입           | 제약조건                       | 설명       |
| ------------ | ------------ | -------------------------- | -------- |
| id           | BIGINT       | PK, AUTO\_INCREMENT        | 댓글 식별자   |
| schedule\_id | BIGINT       | FK (schedule.id), NOT NULL | 일정 참조 ID |
| name         | VARCHAR(255) | NOT NULL                   | 작성자명     |
| password     | VARCHAR(255) | NOT NULL                   | 비밀번호     |
| contents     | TEXT         | NOT NULL                   | 댓글 내용    |
| created\_at  | TIMESTAMP    | NOT NULL                   | 작성일      |
| modified\_at | TIMESTAMP    | NOT NULL                   | 수정일      |
