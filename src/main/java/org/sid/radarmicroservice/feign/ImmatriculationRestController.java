package org.sid.radarmicroservice.feign;


import org.sid.radarmicroservice.model.Proprietaire;
import org.sid.radarmicroservice.model.Vehicule;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@FeignClient(name = "IMMATRICULATION-SERVICE")
public interface ImmatriculationRestController {

    @GetMapping("/web/owners/{id}")
    Proprietaire getOwner(@PathVariable("id") Long id);

    @GetMapping("/web/vehicles/{id}")
    Vehicule getVehicle(@PathVariable("id") String id);
}
