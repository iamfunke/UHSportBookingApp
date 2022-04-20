package com.funke.sport.booking;

public class Schedule {
    private String lesson;
    private String day;
    private String session;
    private String status;



    public Schedule(String lesson, String day, String session, String status) {
        this.lesson = lesson;
        this.day = day;
        this.session = session;
        this.status = status;
    }

    public String getLesson() {
        return lesson;
    }

    public String getDay() {
        return day;
    }

    public String getSession() {
        return session;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "lesson='" + lesson + '\'' +
                ", day='" + day + '\'' +
                ", session='" + session + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
