package net.btc.microservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "filials")
public class Filial {

    @Id
    private String location;

    private String name;

    private String address;

    private String phone;

    private String work;

    private String rating;

    public Filial(String Location, String Name, String Address, String Phone, String Work, String Rating) {
        this.location = Location;
        this.name = Name;
        this.address = Address;
        this.phone = Phone;
        this.work = Work;
        this.rating = Rating;
    }

    public Filial(Filial filial) {
        this.location = filial.location;
        this.name = filial.name;
        this.address = filial.address;
        this.phone = filial.phone;
        this.work = filial.work;
        this.rating = filial.rating;
    }

    public Filial() {
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String Location) {
        this.location = Location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String Phone) {
        this.phone = Phone;
    }

    public String getWork() {
        return this.work;
    }

    public void setWork(String Work) {
        this.work = Work;
    }

    public String getRating() {
        return this.rating;
    }

    public void setRating(String Rating) {
        this.rating = Rating;
    }

    public void saveFilial() {

    }
}
