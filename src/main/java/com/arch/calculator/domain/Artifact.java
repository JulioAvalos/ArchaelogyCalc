package com.arch.calculator.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Document
public class Artifact {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId _id;
    private String name;
    @Lob
    private String url_image;
}
