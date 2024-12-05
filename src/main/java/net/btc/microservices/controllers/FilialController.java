package net.btc.microservices.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.btc.microservices.DataBase;
import net.btc.microservices.entities.Filial;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "/filials")
public class FilialController {

    @PostMapping
    @ResponseBody
    public ResponseEntity<Filial> postFilial(@RequestBody Filial filial) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return ResponseEntity.ok(DataBase.persistObject(filial));
    }

    @PostMapping(value = "/find")
    @ResponseBody
    public ResponseEntity<List<Filial>> findFilial(@RequestBody Filial filial) {
        List<Filial> filials = (List<Filial>)DataBase.getObjectQueryResult(filial);

        return ResponseEntity.ok(filials);
    }
}
