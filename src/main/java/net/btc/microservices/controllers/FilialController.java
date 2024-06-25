package net.btc.microservices.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.btc.microservices.DataBase;
import net.btc.microservices.entities.Filial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filial")
public class FilialController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @ResponseBody
    public ResponseEntity<Filial> postFilial(@RequestBody Filial filial) {
        DataBase.persistObject(entityManager, filial);

        return ResponseEntity.ok(filial);
    }

    @PostMapping(value = "/find")
    @ResponseBody
    public ResponseEntity<List<Filial>> findFilial(@RequestBody Filial filial) {
        List<Filial> filials = (List<Filial>) DataBase.getObjectQueryResult(entityManager, filial);

        return ResponseEntity.ok(filials);
    }
}
