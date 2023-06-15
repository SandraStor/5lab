package com.example.a5labfin;


public class BigPackage implements Package {
    private String size;
    private boolean fragility, needCar;
    @Override
    public void setSize() {
        this.size = "Б";
    }

    @Override
    public void setFragility(boolean fragility) {
        this.fragility = fragility;
    }

    @Override
    public void setNeedCar() {
        this.needCar = true;
    }

    @Override
    public boolean getFrag() {
        return fragility;
    }

    @Override
    public boolean getNeedCar() {
        return needCar;
    }

    @Override
    public String getSize() {
        return size;
    }
}
