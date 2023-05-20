package org.sid.radarmicroservice.web;

import org.sid.radarmicroservice.dto.DtoRequest;
import org.sid.radarmicroservice.entities.Radar;
import org.sid.radarmicroservice.repositories.RadarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Controller
public class RadarGraphqlController {
    @Autowired
    private RadarRepository radarRepository ;
    @QueryMapping
    public List<Radar> radarList (){
       return radarRepository.findAll();
    }
    @QueryMapping
    public Radar radarById(@Argument String idR){
        return  radarRepository.findById(idR).orElseThrow();
    }
    @MutationMapping
    public Radar updateRadar(@Argument String idR, @RequestBody DtoRequest dtoRequest) {
        Radar radar = radarRepository.findById(idR)
                .orElseThrow(() -> new RuntimeException(String.format("Account Not Found :)", idR)));
        if (dtoRequest.getLatitude() != null) {
            radar.setLatitude(dtoRequest.getLatitude());
        }
        if (dtoRequest.getLongitude() != null) {
            radar.setLongitude(dtoRequest.getLongitude()); // Corrected the property name here
        }
        if (dtoRequest.getVitesse_max_R() != null) {
            radar.setVitesse_max_R(dtoRequest.getVitesse_max_R());
        }
        radarRepository.save(radar);
        return radar;
    }

    @MutationMapping
    public void deleteRadar(@Argument  String idR ){
         radarRepository.deleteById(idR);
    }
}
