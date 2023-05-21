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
        String radarId = request.getRadarId();//id radar
        String vehicleId = request.getVehiculeId();//id vehicule
        Double vehicleSpeed = request.getMaxSpeed();//vitesse de la vehicule

        if(radarRepository.findById(radarId).isPresent()){//vérifier si l'id du radar non null
            Radar radar = radarRepository.findById(radarId).get();//si oui on récupére ce radar
            Vehicule vehicle = immatriculationRestController.getVehicle(vehicleId);//récupére la véhicule avec id
            if (vehicleSpeed > radar.getVitesse_max_R()){// on test si la véhicule a dépassée la vitesse du radar
                Infraction infraction = Infraction.builder()// créer une infraction
                        .idF(null)
                        .date(new Date().toString())
                        .vitesseVehicule(vehicleSpeed)
                        .vitesse_max_radar(radar.getVitesse_max_R())
                        .radarID(radar.getIdR())
                        .vehiculeID(vehicle.getId())
                        .vehicule(vehicle)
                        .radar(radar)
                        .build();
                infraction = infractionRestController.saveInfraction(infraction);//ajouter l'infraction
                infraction.setVehicule(vehicle);
                infraction.setRadar(radar);
                RadarGrpc.Infraction response = RadarGrpc.Infraction.newBuilder()
                        .setId(infraction.getIdF())
                        .setDate(infraction.getDate())
                        .setVehicleSpeed(infraction.getVitesseVehicule())
                        .setRadarMaxSpeed(infraction.getVitesse_max_radar())
                        .setRadarId(infraction.getRadarID())
                        .setVehicleId(infraction.getVehiculeID())
                        .setVehicle(RadarGrpc.Vehicle.newBuilder()
                                .setId(infraction.getVehicule().getId())
                                .setRegNumber(infraction.getVehicule().getNum_matricule())
                                .setBrand(infraction.getVehicule().getMarque())
                                .setModel(infraction.getVehicule().getModele())
                                .setOwner(RadarGrpc.Owner.newBuilder()
                                        .setId(infraction.getVehicule().getProprietaire().getIdp())
                                        .setName(infraction.getVehicule().getProprietaire().getNom())
                                        .setBirthDate(infraction.getVehicule().getProprietaire().getDate_Naissance())
                                        .setEmail(infraction.getVehicule().getProprietaire().getEmail())
                                        .build())
                                .build())
                        .setRadar(RadarGrpc.Radar.newBuilder()
                                .setId(infraction.getRadar().getIdR())
                                .setLongitude(infraction.getRadar().getLongitude())
                                .setLatitude(infraction.getRadar().getLatitude())
                                .setMaxSpeed(infraction.getRadar().getVitesse_max_R())
                                .build())
                        .build();
                responseObserver.onNext(response);
            }
        }
        else {
            responseObserver.onNext(null);
        }
        responseObserver.onCompleted();
    }
}