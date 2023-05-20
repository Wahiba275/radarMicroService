package org.sid.radarmicroservice.web;


import org.sid.radarmicroservice.entities.Radar;

import org.sid.radarmicroservice.repositories.RadarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/web")
public class RadarRestController {
    @Autowired
    private RadarRepository radarRepository;
    @GetMapping("/radars")
    public List<Radar> getAllRadars() {
        return radarRepository.findAll();
    }
    @GetMapping("/radars/{id}")
    public Radar getRadarById(@PathVariable String id) {
            return radarRepository.findById(id)
                    .orElseThrow(()->new RuntimeException(String.format("Account Not Found :)" , id)));
    }



}
