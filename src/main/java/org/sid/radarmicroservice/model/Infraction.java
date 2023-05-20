package org.sid.radarmicroservice.model;

import lombok.*;
import org.sid.radarmicroservice.entities.Radar;

import java.util.Date;

@Data  @ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Infraction {
    private String idF ;
    private String date;
    private Double montantInfraction ;
    private String radarID;
    private String matVehicule ;
    private Double vitesse_max_radar ;
    private Double vitesseVehicule ;
    private String vehiculeID ;
    private Radar radar ;
    private Vehicule vehicule ;
}
