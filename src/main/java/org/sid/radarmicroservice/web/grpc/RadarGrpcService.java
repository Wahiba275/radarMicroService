package org.sid.radarmicroservice.web.grpc;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.sid.radarmicroservice.entities.Radar;
import org.sid.radarmicroservice.feign.ImmatriculationRestController;
import org.sid.radarmicroservice.feign.InfractionRestController;
import org.sid.radarmicroservice.model.Infraction;
import org.sid.radarmicroservice.model.Vehicule;
import org.sid.radarmicroservice.repositories.RadarRepository;
import org.sid.radarmicroservice.web.grpc.stubs.RadarGrpc;
import org.sid.radarmicroservice.web.grpc.stubs.RadarServiceGrpc;


import java.util.Date;

@GrpcService
public class RadarGrpcService extends RadarServiceGrpc.RadarServiceImplBase {

    private final RadarRepository radarRepository;
    private final InfractionRestController infractionRestController ;
    private final ImmatriculationRestController immatriculationRestController ;

    public RadarGrpcService(RadarRepository radarRepository, InfractionRestController infractionRestController, ImmatriculationRestController immatriculationRestController) {
        this.radarRepository = radarRepository;
        this.infractionRestController = infractionRestController;
        this.immatriculationRestController = immatriculationRestController;
    }


    @Override
    public void processRadar(RadarGrpc.RadarRequest request, StreamObserver<RadarGrpc.Infraction> responseObserver) {
        String radarId = request.getRadarId();
        String vehicleId = request.getVehiculeId();
        Double vehicleSpeed = request.getMaxSpeed();

        if(radarRepository.existsById(radarId) ){
            Radar radar = radarRepository.findById(radarId).get();
            Vehicule vehicle = immatriculationRestController.getVehicle(vehicleId);
            if (vehicleSpeed > radar.getVitesse_max_R()){
                Infraction infraction = Infraction.builder()
                        .idF(null)
                        .date(new Date().toString())
                        .vitesseVehicule(vehicleSpeed)
                        .vitesse_max_radar(radar.getVitesse_max_R())
                        .radarID(radar.getIdR())
                        .vehiculeID(vehicle.getId())
                        .vehicule(vehicle)
                        .radar(radar)
                        .build();
                infraction = infractionRestController.saveInfraction(infraction);
                infraction.setMatVehicule(vehicle.getNum_matricule());
                infraction.setRadarID(radar.getIdR());
                RadarGrpc.Infraction response = RadarGrpc.Infraction.newBuilder()
                        .setId(infraction.getIdF())
                        .setDate(infraction.getDate())
                        .setVehicleSpeed(infraction.getVitesseVehicule())
                        .setRadarMaxSpeed(infraction.getVitesse_max_radar())
                        .setRadarId(infraction.getRadarID())
                        .setVehicleId(infraction.getVehiculeID())
                        .setVehicle(RadarGrpc.Vehicle.newBuilder()
                                .setId(infraction.getVehicule().getId())
                                .setBrand(infraction.getVehicule().getMarque())
                                .setModel(infraction.getVehicule().getModele())
                                .build())
                        .setRadar(RadarGrpc.Radar.newBuilder()
                                .setId(infraction.getRadar().getIdR())
                                .setLongitude(infraction.getRadar().getLongitude())
                                .setLatitude(infraction.getRadar().getLatitude())
                                .setMaxSpeed(infraction.getRadar().getVitesse_max_R())
                                .build())
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        }

    }
}