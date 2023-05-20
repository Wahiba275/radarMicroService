package org.sid.radarmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DtoRequest {
    private Double vitesse_max_R ;
    private Double longitude ;
    private Double latitude ;
}
