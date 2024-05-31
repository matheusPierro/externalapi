package com.matheuspierro.externalapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ShipMovement {
    private String shipName;
    private String movementType; // "ballast" or "deballast"
    private String timestamp;
    private double latitude;
    private double longitude;
    private double waterAmount;
}
