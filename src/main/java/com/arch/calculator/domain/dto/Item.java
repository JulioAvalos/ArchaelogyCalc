package com.arch.calculator.domain.dto;

import lombok.Data;

@Data
public class Item {
    private Long id;
    private String name;
    private String icon;
    private Current current;
}
