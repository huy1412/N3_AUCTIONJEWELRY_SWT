package com.fpt.edu.repository;

import com.fpt.edu.entity.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILotRepository extends JpaRepository<Lot, Integer> {
}