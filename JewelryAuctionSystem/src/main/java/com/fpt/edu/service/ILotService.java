package com.fpt.edu.service;

import com.fpt.edu.entity.Lot;

import java.util.List;

public interface ILotService {

    List<Lot> getLotsByStatusReady();
}