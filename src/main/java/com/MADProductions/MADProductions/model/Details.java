package com.MADProductions.MADProductions.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Details {
    @Id
    private String name;
    private String GPA;
    public Details(){

    }
    public Details(String name, String GPA) {
        this.name = name;
        this.GPA = GPA;
    }
    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Details{" +
                "name='" + name + '\'' +
                ", GPA='" + GPA + '\'' +
                '}';
    }
}
