package com.api.support.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.support.models.TiketModel;

@Repository
public interface ITiketModelRepository extends JpaRepository<TiketModel, Long> {

}
