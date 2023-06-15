package com.example.a5labfin;

public class SmallPackage implements Package{
    private String size;
    private boolean fragility, needCar;

    public void setSize() {
        this.size = "М";
    }

    @Override
    public void setFragility(boolean fragility){
        this.fragility=fragility;
    }
    @Override
    public void setNeedCar(){
        this.needCar=false;
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
