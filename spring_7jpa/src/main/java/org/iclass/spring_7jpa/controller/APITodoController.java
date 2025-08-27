package org.iclass.spring_7jpa.controller;

import java.util.Map;

import org.iclass.spring_7jpa.dto.TodoDto;
import org.iclass.spring_7jpa.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class APITodoController {

  private TodoService todoService;

  // POST /api/todos
  @PostMapping("/api/todos") // @ResponseBody 로 처리된 문자열과 응답 상태 코드
  public ResponseEntity<?> write(@RequestBody TodoDto dto) {
      // TodoDto result = todoService.write(dto);
      return ResponseEntity.status(HttpStatus.CREATED)
      .body(Map.of("success", todoService.write(dto)));
  }
  

  // GET /api/todos/{username}
  @GetMapping("/api/todos/{username}")
  public ResponseEntity<?> userList(@PathVariable String username) {
    if (!todoService.validUser(username)) { // respository 에 existByUsername 추가하세요.
      return ResponseEntity.badRequest().body(Map.of("message", "존재하지 않는 username 입니다."));
    }
      return ResponseEntity
      .ok()
      .body(todoService.userList(username));
  }
  

}
