package org.sid.radarmicroservice.feign;


import org.sid.radarmicroservice.model.Infraction;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "INFRACTION-SERVICE")
public interface InfractionRestController {

    @GetMapping("/infractions/{id}")
    Infraction getInfractionByID(@PathVariable(name = "id") String id);

    @GetMapping("/web/infractions/radar/{id}")
    List<Infraction> getInfractionsByRadarID(@PathVariable("id") Long id);

    @PostMapping("/web/infractions")
    Infraction saveInfraction(@RequestBody Infraction infraction);
}
