package net.btc.microservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
@Table(name = "tariffs")
public class Tariff {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    private String date;

    @Id
    private String name;

    private String speed;

    private String price;

    private Boolean status;

    public Tariff(String Name, String Speed, String Price, Boolean Status) {
        this.date = dateFormat.format(new Date(System.currentTimeMillis()));

        this.name = Name;
        this.speed = Speed;
        this.price = Price;
        this.status = Status;
    }

    public Tariff(Tariff tariff) {
        this.date = dateFormat.format(new Date(System.currentTimeMillis()));

        this.name = tariff.name;
        this.speed = tariff.speed;
        this.price = tariff.price;
        this.status = tariff.status;
    }

    public Tariff() {}

    public String getDate() {return this.date;}

    public void setDate(String date) {this.date = date;}

    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}

    public String getSpeed() {return this.speed;}

    public void setSpeed(String speed) {this.speed = speed;}

    public String getPrice() {return this.price;}

    public void setPrice(String price) {this.price = price;}

    public Boolean getStatus() {return this.status;}

    public void setStatus(Boolean status) {this.status = status;}
}
