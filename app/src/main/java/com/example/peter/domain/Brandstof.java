package com.example.peter.domain;

/**
 * Created by Wout on 26/10/2017.
 */

public class Brandstof {
    protected String naam;
    protected double verbruik;
    protected double uitstoot;
    protected double brandstoftank;
    protected double uitstootKm;
    protected BrandstofType type;

    public Brandstof(String vtype, String btype){
        if(vtype.equals(VoertuigType.LCV.name())){
            type = new BrandstofType();
        } else {

        }
    }

    public double getJaarlijkseCO2Uitstoot(VoertuigType voertuigType){
        return  type.getJaarlijkseCO2Uitstoot(voertuigType);
    }

    public double getJaarlijkseCO2Uitstoot(BrandstofType brandstofType){
        //if(brandstofType.getLCV().equals(VoertuigType.LCV))
            return uitstoot*verbruik*10;
    }
}
