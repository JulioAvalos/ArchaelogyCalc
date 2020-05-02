package com.arch.calculator.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Data
@Document
public class Recipe {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecipe;
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
