package com.funke.sport.booking;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class OperationTest {

    private Operation operation;
    private List<Lesson> lessonList;
    private List<Student> studentList;
    @BeforeEach
    void setUp() {
        operation = new Operation();
        lessonList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    @Test
    void createLessons() {
        String [] lessonNames = {"YOGA","ZUMBA","AQUACISE","BOX FIT","BODY BLITZ","DANCE"};
        List<Lesson> automatedList = IntStream.rangeClosed(0,5)
                .mapToObj(i->new Lesson(lessonNames[i], 100, new ArrayList<>(), new ArrayList<>(), 0, 0))
                .collect(Collectors.toList());

        lessonList.addAll(automatedList);

        Assert.assertEquals("Error creating Lesson", 6, lessonList.size());
    }

    @Test
    void registerStudents() {
        String [] studentNames = {"FUNKE","VICTORIA","AKINTOMIWA","MAYOWA","DANIELS",
                "LONIMI","SAMUEL","GOLD","PAUL","JBOSS"};

        List<Student> automatedList = IntStream.rangeClosed(0,9)
                .mapToObj(i->new Student(studentNames[i], new ArrayList<>(), new ArrayList<>()))
                .collect(Collectors.toList());

        studentList.addAll(automatedList);

        Assert.assertEquals("Error creating Student", 10, studentList.size());
    }

    @Test
    void getRandomNumber() {
        int result = operation.getRandomNumber(0, 100);
        boolean expectedResult = (result >= 0 && result <= 100) ? true : false;
        Assert.assertTrue("Error while fetching random number", expectedResult);
    }

}