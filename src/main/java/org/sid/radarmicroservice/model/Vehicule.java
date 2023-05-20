package org.sid.radarmicroservice.model;

import lombok.*;

@Data  @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    private  String id ;
    private String num_matricule ;
    private String marque ;
    private Integer puissance_fescale;
    private String modele ;
    private Double vitesse ;

}

