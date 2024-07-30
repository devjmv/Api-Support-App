package com.api.support.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.support.models.TiketModel;
import com.api.support.service.TiketService;

@RestController
@RequestMapping("/tiket")
public class TiketController {

    @Autowired
    private TiketService tiketService;

    @GetMapping
    public ArrayList<TiketModel> getAllTikets(){
        return this.tiketService.getTikets();
    }

    @GetMapping("/{id}")
    public Optional<TiketModel> getTiketByID(@PathVariable("id") Long id) {
        return this.tiketService.getTiketById(id);
    }

    @PutMapping()
    public TiketModel updateTiketModel(@RequestBody TiketModel user) {
        return this.tiketService.updateTiket(user);
    }

    @PostMapping
    public TiketModel saveTiket(@RequestBody TiketModel tiket) {
        return this.tiketService.saveTiket(tiket);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteTiket(@PathVariable("id") Long id) {
        boolean ok = this.tiketService.deleteTiket(id);

        if (ok)
            return "User Tiket as deleted";
        else
            return "Error, we have a problem to deleted user Tiket";
    }
}