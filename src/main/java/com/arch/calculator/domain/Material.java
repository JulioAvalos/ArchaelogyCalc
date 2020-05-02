package com.arch.calculator.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Document
public class Material {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;
    private String name;
    @Lob
    private String urlImg;
    private BigDecimal price;

}
