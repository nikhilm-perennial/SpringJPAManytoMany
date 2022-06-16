package com.jpa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    List<String> students = new ArrayList<>();
}
