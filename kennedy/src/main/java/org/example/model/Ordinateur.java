package org.example.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ordinateur implements Objet {
    private String macAddress;
    private String marque;
    private double frequenceProcesseur; // en GHz

    @Override
    public String getSerialNumber() {
        return macAddress;
    }

    @Override
    public String getType() {
        return "Ordinateur";
    }
}