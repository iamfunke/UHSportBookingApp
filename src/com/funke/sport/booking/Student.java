package com.funke.sport.booking;

import java.util.List;
import java.util.Scanner;

public class Student {

    private String name;
    private List<String> lessons;
    private List<Schedule> bookings;

    String saturday = "SATURDAY";
    String sunday = "SUNDAY";

    String morning = "MORNING";
    String afternoon = "AFTERNOON";
    String evening = "EVENING";

    String booked = "BOOKED";
    String attended = "ATTENDED";


    public Student bookLesson(Lesson lesson){
        if(lesson != null){
            if(!this.getBookings().isEmpty()){
                if(this.getLessons().contains(lesson.getName())){
                    System.out.println("Lesson already exist");
                    return null;
                }
            }
            Student student = schedule(this, lesson);

            if(student != null) {
                this.setBookings(student.getBookings());
                this.setLessons(student.getLessons());
                System.out.println(student.getBookings());
                return this;
            }
        }
        System.out.println("Lesson cannot be null");
        return null;
    }

    private Student schedule(Student student, Lesson lesson){
        int day = selectDay(lesson.getName());
        int session = selectSession();
        boolean conflict = false;
        if((day > 0 & day <  3) & (session > 0 & session <  4)){
            if(day == 1){
                if(session == 1){

                    if(!isNotScheduled(student, saturday, morning)){
                        Schedule schedule = new Schedule(lesson.getName(), saturday, morning, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
                else if(session == 2){

                    if(!isNotScheduled(student, saturday, afternoon)){
                        Schedule schedule = new Schedule(lesson.getName(), saturday, afternoon, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
                else if(session == 3){

                    if(!isNotScheduled(student, saturday, evening)){
                        Schedule schedule = new Schedule(lesson.getName(), saturday, afternoon, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
            }

            else{
                if(session == 1){

                    if(!isNotScheduled(student, sunday, morning)){
                        Schedule schedule = new Schedule(lesson.getName(), sunday, morning, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
                else if(session == 2){

                    if(!isNotScheduled(student, sunday, afternoon)){
                        Schedule schedule = new Schedule(lesson.getName(), sunday, afternoon, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
                else if(session == 3){

                    if(!isNotScheduled(student, sunday, evening)){
                        Schedule schedule = new Schedule(lesson.getName(), sunday, afternoon, booked);
                        student.getBookings().add(schedule);
                        student.getLessons().add(schedule.getLesson());
                    }else{
                        conflict = true;
                    }
                }
            }

            if(conflict){
                System.out.println("Time conflict");
                return null;
            }
            else{
                System.out.println("Booking was successful");
                return student;
            }
        }
        else {
            System.out.println("\nInvalid input");
        }
        return null;
    }

    public boolean changeLesson(Lesson lesson, Schedule schedule){
        if(lesson != null & schedule != null){
            if(this.getLessons().contains(lesson.getName())) {
                System.out.println("Training already exist");
                return false;
            }
            this.getLessons().remove(schedule.getLesson());
            this.getLessons().add(lesson.getName());
            schedule.setLesson(lesson.getName());
            schedule.setStatus(booked);
            this.getBookings().add(schedule);
            System.out.println("Lesson changed successfully");
            return true;
        }
        System.out.println("Cannot find lesson");
        return false;
    }

    private boolean isNotScheduled(Student student, String day, String session){
        return student.getBookings().stream()
                .filter(schedule -> schedule.getDay().equals(day) & schedule.getSession().equals(session))
                .findFirst().isPresent();
    }

    public String attendLesson(int bookingIndex){

        this.getBookings().get(bookingIndex).setStatus(attended);

        return this.getBookings().get(bookingIndex).getLesson();
    }

    public int selectDay(String lessonName){
        System.out.println("\nAdd " + lessonName + " to your schedule");
        System.out.println("Select Day");
        System.out.println("1: Saturday");
        System.out.println("2: Sunday");

        Scanner input = new Scanner(System.in);
        System.out.print("INPUT: ");
        return input.nextInt();
    }

    public int selectSession(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nSelect Session");
        System.out.println("1: Morning");
        System.out.println("2: Afternoon");
        System.out.println("3: Evening");
        System.out.print("INPUT: ");
        return input.nextInt();
    }

    public Student(String name, List<String> lessons, List<Schedule> bookings) {
        this.name = name;
        this.lessons = lessons;
        this.bookings = bookings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getLessons() {
        return lessons;
    }

    public void setLessons(List<String> lessons) {
        this.lessons = lessons;
    }

    public List<Schedule> getBookings() {
        return bookings;
    }

    public void setBookings(List<Schedule> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Lessons: " + lessons + '\n' +
                "Bookings: " + bookings;
    }
}
