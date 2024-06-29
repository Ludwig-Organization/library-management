package com.example.ludwig.libraryP.dto;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class CateDTO {
    @NotNull
    private int id;
    private String cate_name;
    private Map<Integer, String> bookList = new HashMap<>();
}
