package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class Login {
  @PreAuthorize("hasRole('ADMIN') and authentication.name=='admin'")
  @RequestMapping("/helloword1")
  public String hello1(){
    return "111!";
  }

  @PreAuthorize("hasRole('ADMIN') and authentication.name=='aaa'")
  @RequestMapping("/helloword2")
  public String hello2(){
    return "222!";
  }

  @PreAuthorize("hasRole('TEST') and authentication.name=='xgt'")
  @RequestMapping("/helloword3")
  public String hello3(){
    return "333!";
  }
}
