package iurii.job.interview.generic.listener.farm.animals;

import iurii.job.interview.generic.listener.farm.main.Animal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Cat implements Animal {
    private String name;
    private int periodAction = 5;
    private int ready = 5;
    private final DateFormat df = new SimpleDateFormat("HH:mm:ss");

    Cat(String name) {
        this.name = name;
    }

    Cat(String name, int period) {
        this.ready = this.periodAction = period;
    }

    @Override
    public String die() {
        return df.format(LocalDate.now()) + "-" + name + " died";
    }

    @Override
    public String eat() {
        ready = periodAction;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date()) + "-" + name + " eating";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String grow() {
        ready = periodAction;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date()) + "-" + name + " growing";
    }

    @Override
    public boolean isReady() {
        ready--;
        return ready == 0;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public void setPeriodAction(int period) {
        this.periodAction = ready = period;

    }

    @Override
    public String sleep() {
        ready = periodAction;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(new Date()) + "-" + name + " sleeping";
    }

    @Override
    public String walk() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        ready = periodAction;
        return df.format(new Date()) + "-" + name + " walking";
    }

    @Override
    public int compareTo(Animal animal) {
        return this.getName().compareTo(animal.getName());
    }


}
