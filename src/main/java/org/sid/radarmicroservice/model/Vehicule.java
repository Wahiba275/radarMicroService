package org.sid.radarmicroservice.model;

import lombok.Data;

@Data
public class Vehicule {
    private String num_matricule ;
    private String marque ;
    private Integer puissance_fescale;
    private String modele ;
    private Double vitesse ;

}

