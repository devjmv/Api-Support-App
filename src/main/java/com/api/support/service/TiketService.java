package com.api.support.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.support.models.TiketModel;
import com.api.support.repositories.ITiketModelRepository;

@Service
public class TiketService {

    @Autowired
    ITiketModelRepository tiketModelRepository;

    public Optional<TiketModel> getTiketById(Long id) {
        return (Optional<TiketModel>) tiketModelRepository.findById(id);
    }

    public TiketModel saveTiket(TiketModel tiket) {
        return tiketModelRepository.save(tiket);
    }

    public ArrayList<TiketModel> getTikets() {
        return (ArrayList<TiketModel>) tiketModelRepository.findAll();

    }

    public TiketModel updateTiket(TiketModel request) {
        TiketModel tiket = tiketModelRepository.findById(request.getId()).get();

        tiket.setName(request.getName());
        tiket.setSubject(request.getSubject());
        tiket.setDate(request.getDate());
        tiket.setDescription(request.getDescription());

        tiketModelRepository.save(tiket);

        return tiket;
    }

    public Boolean deleteTiket (Long id){
        try{
            tiketModelRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
