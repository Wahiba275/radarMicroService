package org.sid.radarmicroservice.model;

import lombok.Data;

import java.util.Date;

@Data
public class Infraction {
    private String idF ;
    private Date date;
    private Double montantInfraction ;
    private String radarID;
    private String matVehicule ;
    private Double vitesse_max_radar ;
}
