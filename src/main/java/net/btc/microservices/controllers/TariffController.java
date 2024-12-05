package net.btc.microservices.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import net.btc.microservices.DataBase;
import net.btc.microservices.entities.Tariff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping(value = "/tariffs")
public class TariffController {

    @PostMapping
    @ResponseBody
    public ResponseEntity<Tariff> postTariff(@RequestBody Tariff tariff) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return ResponseEntity.ok(DataBase.persistObject(tariff));
    }

    @PostMapping(value = "/find")
    @ResponseBody
    public ResponseEntity<List<Tariff>> findTariff(@RequestBody Tariff tariff, HttpServletRequest request) {
        List<Tariff> tariffs = (List<Tariff>) DataBase.getObjectQueryResult(tariff);

        //TODO: should implement general entrance point (probably make counter inside DataBase class)
        //System.out.println(request.getLocalPort());

        return ResponseEntity.ok(tariffs);
    }
}
