package com.jasontyzzer.demo;

public class Country {
    private String name;
    private int population;
    private int landSize;
    private int medianAge;

    public Country(String name, int population, int landSize, int medianAge) {
        this.name = name;
        this.population = population;
        this.landSize = landSize;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getLandSize() {
        return landSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setLandSize(int landSize) {
        this.landSize = landSize;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }
}
