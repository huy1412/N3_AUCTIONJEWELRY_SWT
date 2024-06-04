package com.fpt.edu.repository;

import com.fpt.edu.entity.ValuationImage;
import com.fpt.edu.entity.ValuationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IValuationImageRepository extends JpaRepository<ValuationImage, Integer> {




}
