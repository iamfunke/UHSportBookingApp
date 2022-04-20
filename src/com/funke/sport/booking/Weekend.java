package com.funke.sport.booking;

public class Weekend {

    private Session saturday;
    private Session sunday;

    public void setSessions(Session sat, Session sun){
        this.setSaturday(sat);
        this.setSunday(sun);
    }

    public Weekend() {
    }

    public Session getSaturday() {
        return saturday;
    }

    public void setSaturday(Session saturday) {
        this.saturday = saturday;
    }

    public Session getSunday() {
        return sunday;
    }

    public void setSunday(Session sunday) {
        this.sunday = sunday;
    }


    @Override
    public String toString() {
        return "saturday=>" + saturday +
                ", sunday=>" + sunday + '\n';
    }
}
