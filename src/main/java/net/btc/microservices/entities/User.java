package net.btc.microservices.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    private String photo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    //TODO: check Network class structure
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private List<Network> networks;

    public User(String Photo, Long Id, String Name, String Description, List<Network> Networks) {
        this.photo = Photo;
        this.id = Id;
        this.name = Name;
        this.description = Description;
        this.networks = new ArrayList<>(Networks);
    }

    public User(User user) {
        this.photo = user.photo;
        this.id = user.id;
        this.name = user.name;
        this.description = user.description;
        this.networks = new ArrayList<>(user.networks);
    }

    public User() {
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String Photo) {
        this.photo = Photo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> network) {
        this.networks = network;
    }
}
