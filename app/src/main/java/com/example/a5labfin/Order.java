package com.example.a5labfin;

public class Order {
    private boolean fragility, isNeedCar;
    private Company company;
    private BigPackage bigPack;
    private SmallPackage smallPack;
    private Document doc;

    static int total;

    private String sourceAddress, destinationAddress;
    private int price;
    private String typeOfPack;

    public Order(Company company, SmallPackage smallPack, String sourceAddress, String destinationAddress, int price){
        this.company = company;
        this.smallPack = smallPack;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.typeOfPack = smallPack.getSize();
        this.price = price;
    }
    public Order(Company company, BigPackage bigPack, String sourceAddress, String destinationAddress,int price){
        this.company = company;
        this.bigPack = bigPack;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.typeOfPack = bigPack.getSize();
        this.price = price;
    }
    public Order(Company company, Document doc, String sourceAddress, String destinationAddress,int price){
        this.company = company;
        this.doc = doc;
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.typeOfPack = doc.getSize();
        this.price = price;
    }

    public String getCompany() {
        return company.getName();
    }

    public void SetSmall(SmallPackage smallPack){
        this.smallPack = smallPack;
    }

    public void SetBig(BigPackage bigPack){
        this.bigPack = bigPack;
    }

    public void SetDoc(Document doc){
        this.doc = doc;
    }


    public String getTypeOfPack() {
        switch (typeOfPack){
            case ("М"):
                return smallPack.getSize();

            case ("Б"):
                return bigPack.getSize();

            case ("Д"):
                return doc.getSize();

            default: break;
        }
        return "-";
    }

    public boolean getNeedCar(){
        switch (typeOfPack){
            case ("М"):
                return smallPack.getNeedCar();

            case ("Б"):
                return bigPack.getNeedCar();

            case ("Д"):
                return bigPack.getNeedCar();

            default: break;
        }
        return false;
    }

    public boolean getFrag(){
        switch (typeOfPack){
            case ("М"):
                return smallPack.getFrag();

            case ("Б"):
                return bigPack.getFrag();

            case ("Д"):
                return doc.getFrag();

            default: break;
        }
        return false;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getPrice() {
        return String.valueOf(price);
    }
}
