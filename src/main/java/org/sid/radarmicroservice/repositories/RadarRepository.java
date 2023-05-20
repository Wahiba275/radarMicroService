package org.sid.radarmicroservice.repositories;


import org.sid.radarmicroservice.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface RadarRepository extends JpaRepository<Radar, String> {
}
