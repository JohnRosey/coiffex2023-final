package com.coiffex.backend.dto;

import lombok.Data;

@Data
public class LoginDTO {
  private String username = "";
  private String password = "";
}