package com.funke.sport.booking;

public class Session {

    private String morning;
    private String afternoon;
    private String evening;


    public Session() {
    }

    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    public String getEvening() {
        return evening;
    }

    public void setEvening(String evening) {
        this.evening = evening;
    }

    @Override
    public String toString() {
        return "{" +
                "morning='" + morning + '\'' +
                ", afternoon='" + afternoon + '\'' +
                ", evening='" + evening + '\'' +
                '}';
    }
}
