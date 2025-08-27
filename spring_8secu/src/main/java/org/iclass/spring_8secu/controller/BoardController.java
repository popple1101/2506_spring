package org.iclass.spring_8secu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class BoardController {
  // @PreAuthorize("hasRole('ADMIN')") // role 값이 없으므로 참고만!! 
  // 요청 처리 전에 권한 확인. getAuthorities() 에서 'ADMIN' 있으면 응답
  @GetMapping("/board/list")
  public String list(Authentication authentication) {
    log.info("username : {}", authentication.getName()); // 인증
    log.info("authorities : {}", authentication.getAuthorities()); // 인가, 권한
      return "board/list";
  }
  
}
