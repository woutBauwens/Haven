package com.example.peter.domain;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by Robin on 27/10/2017.
 */

@Entity
public class Locatie {
    @Id
    private int locationID;
    private long longitude;
    private long latitude;

    public Locatie(int locationID, long longitude, long latitude){
        this.locationID = locationID;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
