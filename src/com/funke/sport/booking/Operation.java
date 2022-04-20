package com.funke.sport.booking;

import java.util.*;

public class Operation {

    public static List<Lesson> lessonList = new ArrayList<>();

    public Operation() {
        createLessons();
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


    public static void main(String[] args) {
        new Operation();
    }
}

