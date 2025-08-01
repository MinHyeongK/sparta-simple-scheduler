# Simple Scheduler

Spring Boot 기반의 간단한 일정 관리 REST API입니다.  
Postman 컬렉션을 통해 직접 요청을 테스트할 수 있습니다.

---

## Postman Collection

- [Simple Scheduler API.postman_collection.json](./Simple%20Scheduler%20API.postman_collection.json)

---

## API Endpoints

### Create

| 메서드 | 경로                     | 설명         |
|--------|--------------------------|--------------|
| POST   | `{{baseURL}}`            | 일정 생성     |
| POST   | `/schedules/{postId}/comments/{commentId}` | 댓글 생성 *(URL만 존재, 내용 미완)* |

---

### Read

| 메서드 | 경로           | 설명         |
|--------|----------------|--------------|
| GET    | `{{baseURL}}?id=1` | 단일 일정 조회 |
| GET    | `{{baseURL}}`      | 전체 일정 조회 |
| GET    | *(URL 없음)*       | 댓글 조회 *(미완성)* |

---

### Update

| 메서드 | 경로           | 설명             |
|--------|----------------|------------------|
| PUT    | `{{baseURL}}?id=1` | 일정 전체 수정     |
| PATCH  | `{{baseURL}}?id=1` | 일정 일부 수정     |
| GET    | *(URL 없음)*       | 댓글 수정 *(미완성)* |

---

### Delete

| 메서드 | 경로           | 설명         |
|--------|----------------|--------------|
| DELETE | `{{baseURL}}?id=1` | 일정 삭제     |
| GET    | *(URL 없음)*       | 댓글 삭제 *(미완성)* |

---

## 기본 설정

| 변수     | 값               |
|----------|------------------|
| baseURL  | `localhost:8080` |

---

## 사용 예시 (Postman)

```json
POST / HTTP/1.1
Content-Type: application/json

{
  "title": "제목",
  "content": "내용",
  "name": "이름",
  "password": "password"
}
```

---

## 주의 사항
- 일부 요청 (`댓글 관련`)은 URL만 있고, body나 설명이 비어 있음
- 실제 적용 전에 Swagger 또는 문서 보강 필요

---

## Database Schema

---

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


---

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

---
