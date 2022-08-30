package com.example.futebolcqrs.entidadesRead;

import javax.persistence.*;

@Entity
public class PartidaRead {

    @Id
    private Long id;

    @OneToOne
    private TimeRead timeReadCasa;

    @OneToOne
    private TimeRead timeReadRival;

    private int golsTimeCasa = 0;

    private int golsTimeRival = 0;

    private int cartaoAmareloTimeCasa = 0;

    private int cartaoAmareloTimeRival = 0;

    private int cartaoVermelhoTimeCasa = 0;

    private int cartaoVermelhoTimeRival = 0;

    private int penaltiTimeCasa = 0;

    private int penaltiTimeRival = 0;


    @Deprecated
    public PartidaRead() {
    }

    public PartidaRead(Long id, TimeRead timeReadCasa, TimeRead timeReadRival, int golsTimeCasa, int golsTimeRival, int cartaoAmareloTimeCasa, int cartaoAmareloTimeRival, int cartaoVermelhoTimeCasa, int cartaoVermelhoTimeRival, int penaltiTimeCasa, int penaltiTimeRival) {
        this.id = id;
        this.timeReadCasa = timeReadCasa;
        this.timeReadRival = timeReadRival;
        this.golsTimeCasa = golsTimeCasa;
        this.golsTimeRival = golsTimeRival;
        this.cartaoAmareloTimeCasa = cartaoAmareloTimeCasa;
        this.cartaoAmareloTimeRival = cartaoAmareloTimeRival;
        this.cartaoVermelhoTimeCasa = cartaoVermelhoTimeCasa;
        this.cartaoVermelhoTimeRival = cartaoVermelhoTimeRival;
        this.penaltiTimeCasa = penaltiTimeCasa;
        this.penaltiTimeRival = penaltiTimeRival;
    }

    public TimeRead getTimeCasa() {
        return timeReadCasa;
    }

    public TimeRead getTimeRival() {
        return timeReadRival;
    }

    public int getGolsTimeCasa() {
        return golsTimeCasa;
    }

    public int getGolsTimeRival() {
        return golsTimeRival;
    }

    public int getCartaoAmareloTimeCasa() {
        return cartaoAmareloTimeCasa;
    }

    public int getCartaoAmareloTimeRival() {
        return cartaoAmareloTimeRival;
    }

    public int getCartaoVermelhoTimeCasa() {
        return cartaoVermelhoTimeCasa;
    }

    public int getCartaoVermelhoTimeRival() {
        return cartaoVermelhoTimeRival;
    }

    public int getPenaltiTimeCasa() {
        return penaltiTimeCasa;
    }

    public int getPenaltiTimeRival() {
        return penaltiTimeRival;
    }
}
