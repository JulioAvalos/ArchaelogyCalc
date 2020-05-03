package com.arch.calculator.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document
public class Recipe {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ObjectId _id;
    //    @ManyToOne
//    @JoinColumn(name = "id_artifact", nullable = false,
//            foreignKey = @ForeignKey(name= "fk_art_recipe"))
    @DBRef
    private Artifact artifact;
    //    @ManyToOne
//    @JoinColumn(name = "id_material", nullable = false,
//            foreignKey = @ForeignKey(name= "fk_mat_recipe"))
    @DBRef
    private Material material;
    private Integer amount;
}
