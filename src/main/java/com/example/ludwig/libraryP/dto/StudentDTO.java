package com.example.ludwig.libraryP.dto;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class StudentDTO {
    private int id;
    private Map<Integer, String> bookMap = new HashMap<>();
}
