package com.matheuspierro.externalapi.controller;

import com.matheuspierro.externalapi.model.ShipMovement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/movements")
public class ShipMovementController {

    private static final String[] SHIP_NAMES = {"Ship A", "Ship B", "Ship C"};
    private static final String[] MOVEMENT_TYPES = {"ballast", "deballast"};
    private static final Random RANDOM = new Random();

    @GetMapping
    public List<ShipMovement> getAllMovements() {
        List<ShipMovement> movements = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            movements.add(generateRandomMovement());
        }

        return movements;
    }

    private ShipMovement generateRandomMovement() {
        ShipMovement movement = new ShipMovement();
        movement.setShipName(SHIP_NAMES[RANDOM.nextInt(SHIP_NAMES.length)]);
        movement.setMovementType(MOVEMENT_TYPES[RANDOM.nextInt(MOVEMENT_TYPES.length)]);
        movement.setTimestamp(String.valueOf(LocalDateTime.now().minusHours(RANDOM.nextInt(100))));
        movement.setLatitude(-90 + (90 - (-90)) * RANDOM.nextDouble());
        movement.setLongitude(-180 + (180 - (-180)) * RANDOM.nextDouble());
        movement.setWaterAmount(500 + (1500 - 500) * RANDOM.nextDouble());
        return movement;
    }
}
