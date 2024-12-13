package com.java.square_games_services.controllers;


import com.java.square_games_services.sensors.HeartbeatSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Indique que cette classe est un contrôleur REST
public class HeartbeatController {

    @Autowired // Injecte automatiquement une implémentation de HeartbeatSensor
    private HeartbeatSensor heartbeatSensor;

    /**
     * Endpoint HTTP GET
     * @return une valeur entière
     */
    @GetMapping("/heartbeat")
    public int getHeartbeat() {
        return heartbeatSensor.get();
    }
}
