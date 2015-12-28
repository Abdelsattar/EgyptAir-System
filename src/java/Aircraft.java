/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammed
 */
public class Aircraft {
    
     String model,country,weight,seatsNum,calsses,name,aircraftID;

     public Aircraft(){
         
     }
    public Aircraft(String model, String country, String weight,
            String seatsNum, String calsses, String name, String aircraftID) {
        this.model = model;
        this.country = country;
        this.weight = weight;
        this.seatsNum = seatsNum;
        this.calsses = calsses;
        this.name = name;
        this.aircraftID = aircraftID;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public String getWeight() {
        return weight;
    }

    public String getSeatsNum() {
        return seatsNum;
    }

    public String getCalsses() {
        return calsses;
    }

    public String getName() {
        return name;
    }

    public String getAircraftID() {
        return aircraftID;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setSeatsNum(String seatsNum) {
        this.seatsNum = seatsNum;
    }

    public void setCalsses(String calsses) {
        this.calsses = calsses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAircraftID(String aircraftID) {
        this.aircraftID = aircraftID;
    }
    
}
