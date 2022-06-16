package com.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class StudentDTO {

    private Long id;
    private String name;
    private String rollno;
    private List<String> courses = new ArrayList<>();
}
