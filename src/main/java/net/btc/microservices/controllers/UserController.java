package net.btc.microservices.controllers;

import net.btc.microservices.DataBase;
import net.btc.microservices.entities.Network;
import net.btc.microservices.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @PostMapping
    @ResponseBody
    public User postUser(@RequestBody User user) {
        /*
        Input for networks must be like:
        "networks": [
            {
                "network": "net1",
                "url": "url1"
            }
        ]
        Output:
        "networks": [
            {
                "net1": "url1"
            }
        ]

         */

        DataBase.persistObject(user);

        return user;
    }

    @PostMapping(value = "/find")
    @ResponseBody
    public ResponseEntity<List<User>> findUser(@RequestBody User User) {
        List<User> users = (List<User>) DataBase.getObjectQueryResult(User);

        return ResponseEntity.ok(users);
    }


    //DEBUG ONLY
    @PostMapping(value = "/example")
    @ResponseBody
    public User exampleUser(@RequestBody User user) {
        List<Network> nets = new ArrayList<>();
        nets.add(new Network("net1", "url1"));
        nets.add(new Network("net2", "url2"));
        nets.add(new Network("net3", "url3"));
        User newUser = new User("photo", 123L, "name", "desc", nets);

        return newUser;
    }

}
