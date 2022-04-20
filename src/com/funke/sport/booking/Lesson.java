package com.funke.sport.booking;

import java.util.List;

public class Lesson {

    private String name;
    private Integer fee;
    private List<String> reviews;
    private List<Integer> ratings;
    private int students;
    private int attendance;


    public void rateAndReview(int rating, String review){
        this.getRatings().add(rating);
        this.getReviews().add(review);
    }

    public void book(){
        this.students++;
    }

    public void unBook(){
        --this.students;
    }

    public void takeAttendance(){
        this.attendance++;
    }

    public boolean isBookedMax(){
        return this.students <= 3 ? true : false;
    }


    public Lesson(String name, Integer fee, List<String> reviews, List<Integer> ratings, int students, int attendance) {
        this.name = name;
        this.fee = fee;
        this.reviews = reviews;
        this.ratings = ratings;
        this.students = students;
        this.attendance = attendance;
    }

    public String getName() {
        return name;
    }

    public Integer getFee() {
        return fee;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public List<Integer> getRatings() {
        return ratings;
    }

    public int getStudents() {
        return students;
    }

    public int getAttendance() {
        return attendance;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name: '" + name + '\'' +
                ", fee: " + fee +
                '}';
    }
}

