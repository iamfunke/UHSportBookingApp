package com.funke.sport.booking;

import java.util.*;

public class Operation {

    public static List<Lesson> lessonList = new ArrayList<>();
    public static List<Weekend> timeTable = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    String saturday = "SATURDAY";
    String sunday = "SUNDAY";

    public Operation() {
        createLessons();
        createTimeTable();
        registerStudents();
        showMenu();
    }

    public void createLessons(){
        Lesson one = new Lesson("YOGA", 100, new ArrayList<>(), new ArrayList<>(), 0, 0);
        Lesson two = new Lesson("ZUMBA", 200, new ArrayList<>(), new ArrayList<>(), 0, 0);
        Lesson three = new Lesson("AQUACISE", 50, new ArrayList<>(), new ArrayList<>(), 0, 0);
        Lesson four = new Lesson("BOX FIT", 200, new ArrayList<>(), new ArrayList<>(), 0, 0);
        Lesson five = new Lesson("BODY BLITZ", 300, new ArrayList<>(), new ArrayList<>(), 0, 0);
        Lesson six = new Lesson("DANCE", 150, new ArrayList<>(), new ArrayList<>(), 0, 0);

        lessonList.add(one);
        lessonList.add(two);
        lessonList.add(three);
        lessonList.add(four);
        lessonList.add(five);
        lessonList.add(six);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void createTimeTable(){
        int weeks = 8;
        while(weeks > 0){
            List<Lesson> temp = new ArrayList<>();
            lessonList.forEach(lesson -> temp.add(lesson));
            Session sat = new Session();
            Session sun = new Session();
            Weekend weekend = new Weekend();

            int index = getRandomNumber(0, temp.size());

            sat.setMorning(temp.remove(index).getName());
            index = getRandomNumber(0, temp.size());
            sat.setAfternoon(temp.remove(index).getName());
            index = getRandomNumber(0, temp.size());
            sat.setEvening(temp.remove(index).getName());

            index = getRandomNumber(0, temp.size());
            sun.setMorning(temp.remove(index).getName());
            index = getRandomNumber(0, temp.size());
            sun.setAfternoon(temp.remove(index).getName());
            index = getRandomNumber(0, temp.size());
            sun.setEvening(temp.remove(index).getName());

            weekend.setSessions(sat, sun);

            timeTable.add(weekend);

            weeks--;
        }
    }

    public void registerStudents() {

        Student one = new Student("YUSUF", new ArrayList<>(), new ArrayList<>());
        Student two = new Student("JOHN", new ArrayList<>(), new ArrayList<>());
        Student three = new Student("STEVEN", new ArrayList<>(), new ArrayList<>());
        Student four = new Student("MARY", new ArrayList<>(), new ArrayList<>());
        Student five = new Student("KHALID", new ArrayList<>(), new ArrayList<>());
        Student six = new Student("JULIET", new ArrayList<>(), new ArrayList<>());
        Student seven = new Student("ABRAHAM", new ArrayList<>(), new ArrayList<>());
        Student eight = new Student("FATIMA", new ArrayList<>(), new ArrayList<>());
        Student nine = new Student("ADAM", new ArrayList<>(), new ArrayList<>());
        Student ten = new Student("LOVE", new ArrayList<>(), new ArrayList<>());

        studentList.add(one);
        studentList.add(two);
        studentList.add(three);
        studentList.add(four);
        studentList.add(five);
        studentList.add(six);
        studentList.add(seven);
        studentList.add(eight);
        studentList.add(nine);
        studentList.add(ten);
    }

    public void showMenu(){
        while(true){
            System.out.println();
            System.out.println("Select Operation");
            System.out.println("1: Login as student");
            System.out.println("2: Generate report");
            System.out.println("3: Show Timetable");
            System.out.println("4: Exit");

            System.out.print("INPUT: ");

            Scanner input = new Scanner(System.in);
            String select = input.next();

            if(select.equals("1")){
                login();
            }
            else if(select.equals("2")){
                showReportMenu();
            }
            else if(select.equals("3")){
                int count = 1;
                for (Weekend weekend : timeTable){
                    System.out.println("Week " + count + ": " + weekend);
                    count++;
                }
            }
            else if(select.equals("4")){
                break;
            }
            else{
                System.out.println("Invalid selection");
            }
        }

    }

    public static void main(String[] args) {
        new Operation();
    }
}

