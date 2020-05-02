package com.arch.calculator.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
public class Artifact {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArtifact;
    private String name;
    @Lob
    private String urlImg;
}
