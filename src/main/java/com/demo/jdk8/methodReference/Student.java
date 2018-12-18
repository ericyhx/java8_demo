package com.demo.jdk8.methodReference;

public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public static int comperatorByScore(Student s1,Student s2){
        return s1.getScore()-s2.getScore();
    }
    public static int comperatorByName(Student s1,Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
    public int comperatorByScore2(Student s1,Student s2){
        return s1.getScore()-s2.getScore();
    }
    public int comperatorByName2(Student s1,Student s2){
        return s1.getName().compareToIgnoreCase(s2.getName());
    }
    public int comperatorByScore3(Student student){
        return this.getScore()-student.getScore();
    }
    public int comperatorByName3(Student student){
        return this.getName().compareToIgnoreCase(student.getName());
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
