package com.arch.calculator.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Document
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    private ObjectId _id;
    private Long ge_id;
    private String name;
    @Lob
    private String url_image;
    private String price;

}
