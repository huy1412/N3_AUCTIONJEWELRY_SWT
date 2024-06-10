package com.fpt.edu.service;

import com.fpt.edu.dto.AuctionSessionDTO;
import com.fpt.edu.dto.ViewLiveAuctionSessionDetailDTO;
import com.fpt.edu.entity.AuctionSession;
import com.fpt.edu.status.AuctionRegisterStatus;
import com.fpt.edu.status.AuctionSessionStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface  IAuctionSessionService {

    List<AuctionSession> getAllAuctionSession();

    AuctionSession createSession(String name, String description, LocalDate startDate, LocalDate startingBid, int staffId);

    List<AuctionSession> getAllAuctionSessionByCreatedStatus();

    AuctionSession addLotToSession(int lotId, int sessionId);

    AuctionSession getAuctionSessionById(int id);

    List<AuctionSessionDTO> getUpcomingAuctionSession();

    ResponseEntity<?> viewLiveAuctionSessionDetail(Integer sessionId, Integer memberId);

    boolean authByMember(Integer sessionId, Integer memberId);
}
