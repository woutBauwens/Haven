package com.example.peter.domain;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Transient;

import java.util.List;

/**
 * Created by Wout on 26/10/2017.
 */

@Entity
public class Voertuig {
    @Id
    private String nummerplaat;
    private int bouwjaar;
    private int aantalKm;
    private int maxTon;
    @Transient
    private BrandstofType type;
    @ToMany
    private List<Rit> ritten;
    private int brandstoftank;
    @Transient
    private Brandstof brandstof;

    public Voertuig(String nummerplaat, int bouwjaar, int aantalKm, int maxTon, BrandstofType type, List<Rit> ritten) {
        this.nummerplaat = nummerplaat;
        this.bouwjaar = bouwjaar;
        this.aantalKm = aantalKm;
        this.maxTon = maxTon;
        this.type = type;
        this.ritten = ritten;
    }

    public void startRit(int aantalTon){
        if(aantalTon < maxTon)
            ritten.add(new Rit(aantalTon));
        else {

        }
    }

    public void updateLocation(Locatie locatie){
        //ritten.stream().forEach(r -> {if(r.isOnderweg()){update(r, locatie);}});
    }

    private void update(Rit huidigeRit, Locatie locatie){
        huidigeRit.updateLocation(locatie);
    }

    public double berekenDuurzaamheid(int tonnageVloot){
        return brandstof.getJaarlijkseCO2Uitstoot(type)/tonnageVloot;
    }

    public double getAantalTankbeurtenPerRit(){
        int aantalTankbeurten = 0;
        for(Rit rit: ritten){
            aantalTankbeurten += rit.getAantalTankbeurten();
        }
        return  aantalTankbeurten/ritten.size();
    }
}
