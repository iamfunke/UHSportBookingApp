package com.funke.sport.booking;

import java.util.*;

public class Operation {

    public static List<Lesson> lessonList = new ArrayList<>();
    public static List<Weekend> timeTable = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    static final String saturday = "SATURDAY";
    static final String sunday = "SUNDAY";

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

    public void login(){
        System.out.println("\n");
        System.out.println("Select Student");
        System.out.println("0: " + studentList.get(0).getName());
        System.out.println("1: " + studentList.get(1).getName());
        System.out.println("2: " + studentList.get(2).getName());
        System.out.println("3: " + studentList.get(3).getName());
        System.out.println("4: " + studentList.get(4).getName());
        System.out.println("5: " + studentList.get(5).getName());
        System.out.println("6: " + studentList.get(6).getName());
        System.out.println("7: " + studentList.get(7).getName());
        System.out.println("8: " + studentList.get(8).getName());
        System.out.println("9: " + studentList.get(9).getName());
        System.out.println("10: " + "Go Back");

        System.out.print("INPUT: ");

        Scanner input = new Scanner(System.in);
        int studentId = input.nextInt();

        if(studentId <= 9)
            studentDashboard(studentId);
    }

    public void studentDashboard(int index){
        while(true){
            Student student = studentList.get(index);
            System.out.println();
            System.out.println("Welcome " + student.getName());
            System.out.println("Select Activity");
            System.out.println("1: Book Lesson");
            System.out.println("2: Change Booking");
            System.out.println("3: Attend Lesson");
            System.out.println("4: View profile");
            System.out.println("5: Logout");

            System.out.print("INPUT: ");

            Scanner input = new Scanner(System.in);
            String select = input.next();

            if(select.equals("1")){
                String lessonName = bookGetLessonName();
                Lesson lesson = getLesson(lessonName);
                student = student.bookLesson(lesson);
                if(student != null){
                    Operation.lessonList.forEach(lesson1 -> {
                        if(lesson1 == lesson){
                            lesson1.book();
                        }
                    });

                    updateStudentList(student);
                }
            }

            else if(select.equals("2")){
                System.out.println("Select a new Lesson");
                String lessonName = bookGetLessonName();
                Lesson lesson = getLesson(lessonName);
                if(lesson != null){
                    System.out.println("Select lesson to change");
                    int sel = selectBooking(student);
                    Schedule schedule = student.getBookings().remove(sel);
                    Lesson unBookedLesson = getLessonByName(schedule.getLesson());
                    boolean changed = student.changeLesson(lesson, schedule);
                    if(changed){
                        lessonList.forEach(lesson1 -> {
                            if(lesson1 == lesson){
                                lesson1.book();
                            }
                            if(lesson1 == unBookedLesson){
                                lesson1.unBook();
                            }
                        });
                        updateStudentList(student);
                    }
                }
            }

            else if(select.equals("3")){
                if(student.getBookings().isEmpty()){
                    System.out.println("No Booked lesson found");
                    return;
                }
                System.out.println("Select lesson to attend");
                int bookingIndex = selectBooking(student);
                System.out.println("Thank you for attending this lesson");
                String lessonName = student.attendLesson(bookingIndex);
                Lesson selectLesson = getLessonByName(lessonName);
                if(selectLesson != null){
                    lessonList.forEach(lesson -> {
                        if(lesson == selectLesson){
                            lesson.takeAttendance();
                        }
                    });
                    review(lessonName);
                    updateStudentList(student);
                }
            }

            else if(select.equals("4")){
                System.out.println("Profile");
                System.out.println("\n" + student);
            }
            else{
                break;
            }
        }
    }

    private int selectBooking(Student student){

        int index = 0;
        for(Schedule book: student.getBookings()){
            System.out.println(index + ": " + book);
            System.out.println();
            index++;
        }
        Scanner input = new Scanner(System.in);
        System.out.print("INPUT: ");
        return input.nextInt();
    }

    private void review(String lessonName){

        System.out.println("1: Review and Rate");
        System.out.println("2: Back");

        System.out.print("INPUT: ");

        Scanner input = new Scanner(System.in);
        String select = input.next();

        if(select.equals("1")){
            ratingMenu(lessonName);
        }
    }

    private String bookGetLessonName(){
        System.out.println();
        System.out.println("Lessons occur on both Saturdays and Sundays. The following are the list of lessons" +
                " available");

        StringBuilder lessons = new StringBuilder("[");
        lessonList.forEach(lesson -> lessons.append(lesson.getName() + ", "));
        lessons.append("]");
        System.out.println(lessons);

        System.out.println("\nPlease enter either 'SUNDAY' or 'SATURDAY' to view the timetable available for each day " +
                "or enter the lesson name to view the timetable for the lesson");
        System.out.print("INPUT: ");

        Scanner input = new Scanner(System.in);
        String option = input.nextLine().toUpperCase();

        if(option.equals(sunday) || option.equals(saturday)){
            return showTimeTableByDay(option);
        }
        else{
            return showTimeTableByLesson(option);
        }
    }

    private Lesson getLesson(String lessonName){
        for(Lesson lesson: lessonList){
            if(lesson.getName().equals(lessonName)){
                if(lesson.isBookedMax()) {
                    System.out.println("Space available");
                    return lesson;
                }
                System.out.println("Lesson is at maximum capacity");
                return null;
            }
        }
        System.out.println("Lesson can not be found");
        return null;
    }

    public String showTimeTableByDay(String day){
        System.out.println("\nTIMETABLE FOR " + day.toUpperCase() + 'S');
        Set<String> lessons = new HashSet<>();
        int week = 1;
        for(Weekend weekend: timeTable){
            if(day.equals("saturday")){
                System.out.println("WEEK " + week);
                System.out.println(weekend.getSaturday().toString());
                lessons.add(weekend.getSaturday().getAfternoon());
                lessons.add(weekend.getSaturday().getMorning());
                lessons.add(weekend.getSaturday().getEvening());
            }
            else{
                System.out.println("WEEK " + week);
                System.out.println(weekend.getSunday().toString());
                lessons.add(weekend.getSunday().getAfternoon());
                lessons.add(weekend.getSunday().getMorning());
                lessons.add(weekend.getSunday().getEvening());
            }
            week++;
        }
        System.out.println("\n----->>>Lessons<<<-----");
        lessonList.forEach(lesson -> {
            if(lessons.contains(lesson.getName()))
                System.out.println(lesson);
            System.out.println();
        });

        System.out.print("Book using lesson name: ");
        Scanner input = new Scanner(System.in);

        return input.nextLine().toUpperCase();
    }

    public String showTimeTableByLesson(String lessonName){
        System.out.println("\nTIMETABLE FOR " + lessonName);
        int week = 1;
        for(Weekend weekend : timeTable){
            System.out.println("WEEK " + week);
            if(weekend.getSaturday().getEvening().equals(lessonName))
                System.out.println("Saturday: " + weekend.getSaturday());
            if(weekend.getSaturday().getAfternoon().equals(lessonName))
                System.out.println("Saturday: " + weekend.getSaturday());
            if(weekend.getSaturday().getMorning().equals(lessonName))
                System.out.println("Saturday: " + weekend.getSaturday());
            if(weekend.getSunday().getEvening().equals(lessonName))
                System.out.println("Sunday: " + weekend.getSunday());
            if(weekend.getSunday().getAfternoon().equals(lessonName))
                System.out.println("Sunday: " + weekend.getSunday());
            if(weekend.getSunday().getMorning().equals(lessonName))
                System.out.println("Sunday: " + weekend.getSunday());

            week++;
        }
        Lesson lesson = getLessonByName(lessonName);
        System.out.println("\n" + lesson);
        System.out.print("Book exercise using the lesson name: ");
        Scanner input = new Scanner(System.in);

        return input.nextLine().toUpperCase();
    }

    private void updateStudentList(Student student){
        studentList.forEach(student1 -> {
            if(student1.getName().equals(student.getName())) {
                student1.setLessons(student.getLessons());
                student1.setBookings(student.getBookings());
            }
        });
    }

    private void ratingMenu(String lessonName){

        System.out.println("\nReview and Rate " + lessonName + " lesson");

        Scanner input = new Scanner(System.in);
        System.out.print("Review: ");
        String review = input.nextLine().trim();

        if(review.isEmpty())
            review = "No Review";

        System.out.println("\nRating");
        System.out.println("1: Very Dissatisfied");
        System.out.println("2: Dissatisfied");
        System.out.println("3: OK");
        System.out.println("4: Satisfied");
        System.out.println("5: Very Satisfied");

        Scanner rateInput = new Scanner(System.in);
        System.out.print("INPUT: ");
        int rating = rateInput.nextInt();

        String finalReview = review;

        lessonList.forEach(lesson -> {
            if(lesson.getName().equals(lessonName)){
                lesson.rateAndReview(rating, finalReview);
                System.out.println("Review and rating saved");
            }
        });

    }

    public void showReportMenu(){
        System.out.println("Select report");
        System.out.println("1: Show report for all lessons");
        System.out.println("2: Show report of highest income generated by a lesson");

        Scanner input = new Scanner(System.in);

        System.out.print("INPUT: ");
        int select = input.nextInt();

        if(select == 1){
            generateLessonsReport();
        }
        else if(select == 2){
            generateBestLessonReport();
        }
    }

    public void generateLessonsReport(){
        System.out.println("\nAll Lesson Report");
        for(Lesson lesson : lessonList){
            String name = lesson.getName();
            int students = lesson.getStudents();
            List<String> reviews = lesson.getReviews();
            int averageRate = 0;
            for(int rate : lesson.getRatings()){
                averageRate += rate;
            }
            if(averageRate > 0)
                averageRate = averageRate / lesson.getRatings().size();

            int fee = lesson.getFee();
            int attendance = lesson.getAttendance();

            System.out.println("Name         " + name);
            System.out.println("Fee          " + fee);
            System.out.println("Bookings     " + students);
            System.out.println("Attendance   " + attendance);
            System.out.println("Average rate " + averageRate);
            System.out.println("Reviews");
            for(String review : reviews){
                System.out.println("     - " + review);
            }
            System.out.println();

        }
    }

    public void generateBestLessonReport(){
        int max = 0;
        Lesson lesson = null;
        for(Lesson lesson1 : lessonList){
            int income = lesson1.getFee() * lesson1.getAttendance();
            if(income > max){
                max = income;
                lesson = lesson1;
            }
        }
        if(lesson == null){
            System.out.println("No lesson was attended");
            return;
        }
        System.out.println("Report of the lesson with highest income generation");
        System.out.println("Name: " + lesson.getName());
        System.out.println("Total income: " + lesson.getFee() * lesson.getAttendance());

    }

    public Lesson getLessonByName(String lessonName){
        return lessonList.stream()
                .filter(lesson -> lesson.getName().equals(lessonName))
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        new Operation();
    }
}

