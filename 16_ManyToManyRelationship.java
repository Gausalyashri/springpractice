/*
Problem: Many-to-Many JPA Relationship
Model a many-to-many relationship between Student and Course
using @ManyToMany with a shared join table.
*/

package com.example.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    public void enroll(Course course) {
        courses.add(course);
        course.getStudents().add(this);
    }

    public Long getId() { return id; }
    public Set<Course> getCourses() { return courses; }
}

@Entity
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public Set<Student> getStudents() { return students; }
}
