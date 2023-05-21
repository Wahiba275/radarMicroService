package org.sid.radarmicroservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.sid.radarmicroservice.model.Infraction;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class Radar {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idR ;
    private Double vitesse_max_R ;
    private Double longitude ;
    private Double latitude ;
    private String num_matricule ;
    @Transient
    private List<Infraction> infractions;


}
