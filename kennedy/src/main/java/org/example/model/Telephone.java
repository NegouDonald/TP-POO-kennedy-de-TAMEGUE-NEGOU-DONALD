package org.example.model;

import lombok.*;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telephone implements Objet {
    private int id;
    private String imei;
    private String marque;
    private String description;
    private boolean vole;

    @Override
    public String getSerialNumber() {
        return imei;
    }

    @Override
    public String getType() {
        return "Téléphone";
    }
}