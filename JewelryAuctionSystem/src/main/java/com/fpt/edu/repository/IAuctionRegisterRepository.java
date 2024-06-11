package com.fpt.edu.repository;

import com.fpt.edu.entity.AuctionRegister;
import com.fpt.edu.entity.Lot;
import com.fpt.edu.status.AuctionRegisterStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuctionRegisterRepository  extends JpaRepository<AuctionRegister, Integer> {

  Integer countByLotIdAndStatus(Integer lotId, AuctionRegisterStatus auctionRegisterStatus);

  List<AuctionRegister> findAuctionRegisterByMemberIdAndStatus(Integer memberId, AuctionRegisterStatus auctionRegisterStatus);

  AuctionRegister findByLotIdAndMemberId(Integer lotId, Integer memberId);
}
