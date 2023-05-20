package org.sid.radarmicroservice.model;

import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class Proprietaire {
    private Long idp ;
    private String nom ;
    private String date_Naissance ;
    private String email ;
    private List<Vehicule> vehiculeList ;
}
