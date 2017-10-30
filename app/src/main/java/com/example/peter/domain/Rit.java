package com.example.peter.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Wout on 26/10/2017.
 */

@Entity
public class Rit {
    // @id nog toe te voegen
    private Date begin;
    private Date end;
    private int aantalTon;
    private int aantalStops;
    private int aantalTankbeurten;
    @ToMany
    private List<Locatie> locaties;

    public Rit(int aantalTon){
        begin = new Date();
        this.aantalTon = aantalTon;
        locaties = new ArrayList<>();
        aantalStops = 0;
    }

    public void neemPauze(boolean tanken){
        //automatiseren met locaties?
        aantalStops++;
        if(tanken){
            aantalTankbeurten++;
        }
    }

    public void updateLocation(Locatie loc){
        locaties.add(loc);
    }

    public boolean isOnderweg(){
        return end==null;
    }

    public int getAantalTankbeurten(){
        return aantalTankbeurten;
    }
}
