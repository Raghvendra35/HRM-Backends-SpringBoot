package com.employee.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.employee.entities.AccessTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenResponse 
{
	private String message;
    private String token;
    private String role;
  //  private String urls;
    private List<Map<String,Object>> navs;
}
