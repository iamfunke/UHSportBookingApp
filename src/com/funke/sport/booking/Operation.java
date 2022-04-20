package com.funke.sport.booking;

import java.util.*;

public class Operation {

    public static List<Lesson> lessonList = new ArrayList<>();
    public static List<Weekend> timeTable = new ArrayList<>();

    public Operation() {
        createLessons();
        createTimeTable();

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


    public static void main(String[] args) {
        new Operation();
    }
}

