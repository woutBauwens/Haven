package com.example.peter.domain;

import org.greenrobot.greendao.annotation.Entity;

/**
 * Created by Wout on 26/10/2017.
 */

@Entity
public class BrandstofType {

    private static double cal;
    private static double verbruik;
    private static double uitstoot;

    public enum LCV{
        DIESEL(35.8,30,3.5),
        BIODIESEL_B7(35.6, 30.2, 3.4),
        LNG(45, 28, 3.08),
        CNG(38, 0,0),
        HGAS(120, 0,0),
        ELEC(0, 0,0);

        LCV(double cal, double verbruik, double uitstoot){
            BrandstofType.cal = cal;
            BrandstofType.verbruik = verbruik;
            BrandstofType.uitstoot = uitstoot;
        }
    }

    public enum MCV{
        DIESEL(35.8,18,3.5),
        BIODIESEL_B7(35.6, 18.1, 3.4),
        LNG(45, 16,3.08),
        CNG(38, 18.9,3.08),
        HGAS(120, 12,0.417),
        ELEC(0,80,0.031);

        MCV(double cal, double verbruik, double uitstoot){
            BrandstofType.cal = cal;
            BrandstofType.verbruik = verbruik;
            BrandstofType.uitstoot = uitstoot;
        }
    }

    public BrandstofType(){

    }

    public LCV getLCV(String btype){
        return LCV.valueOf(btype);
    }

    public MCV getMCV(String btype){
        return MCV.valueOf(btype);
    }

    public double getJaarlijkseCO2Uitstoot(VoertuigType voertuigType){
        if(voertuigType.equals(VoertuigType.LCV)) {
            return uitstoot * verbruik * 10;
        }
        return 0;
    }
}
