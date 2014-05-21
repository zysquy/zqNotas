package com.zysquy.zqnotas.entity.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zysquy.zqnotas.entity.EstablecimientoEducativo;

@Repository
public interface EstablecimientoEducativoRepository extends JpaRepository<EstablecimientoEducativo, Integer> {

}
