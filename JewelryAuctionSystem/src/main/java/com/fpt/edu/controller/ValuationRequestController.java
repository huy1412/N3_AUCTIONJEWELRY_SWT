package com.fpt.edu.controller;

import com.fpt.edu.dto.FinalValuationRequestDTO;
import com.fpt.edu.dto.ResponseRequestValuationDTO;
import com.fpt.edu.dto.ValuationRequestDTO;
import com.fpt.edu.dto.ViewValuationRequestDTO;
import com.fpt.edu.service.ResponseValuationRequestService;
import com.fpt.edu.service.ValuationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/valuation")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ValuationRequestController {

    private final ValuationRequestService valuationRequestService;
    private final ResponseValuationRequestService responseValuationRequestService;

    //Member create valuation request by description and estimate price
    @PostMapping("/create")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ValuationRequestDTO> addValuationRequest(@RequestParam("memberId") Integer memberId,
                                                                   @RequestParam("description") String description,
                                                                   @RequestParam("estimateMin") BigDecimal estimateMin,
                                                                   @RequestParam("estimateMax") BigDecimal estimateMax,
                                                                   @RequestParam("image") Set<MultipartFile> files
    ) throws IOException {
        return ResponseEntity.ok(valuationRequestService.create(memberId, description, estimateMin, estimateMax, files));
    }

    @GetMapping("/requested")
    @CrossOrigin(origins = "*")
    public ResponseEntity<List<ValuationRequestDTO>> getRequestedValuationRequest() {
        return ResponseEntity.ok(valuationRequestService.getRequestedValuationRequest());
    }

    @PostMapping("/product-received")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ValuationRequestDTO> productReceived(@RequestParam("id") Integer id) {
        return ResponseEntity.ok(valuationRequestService.productReceived(id));
    }


    @PostMapping("/preliminary-valuation")
    @CrossOrigin(origins = "*")
    public ResponseEntity<ValuationRequestDTO> preliminaryValuation(@RequestParam("id") Integer id,
                                                                    @RequestParam("estimateMin") BigDecimal estimatePrice,
                                                                    @RequestParam("estimateMax") BigDecimal estimateMax,
                                                                    @RequestParam("staffId") Integer staffId) {
        return ResponseEntity.ok(valuationRequestService.preliminaryValuation(id, estimatePrice, estimateMax, staffId));
    }

    @GetMapping("/request/status/product-received")
    public ResponseEntity<List<ValuationRequestDTO>> getRequestStatusProductReceived() {
        return ResponseEntity.ok(valuationRequestService.getRequestStatusProductReceived());
    }

    @GetMapping("/request/status/product-received/{id}")
    public ResponseEntity<ValuationRequestDTO> getRequestStatusProductReceivedById(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.getRequestByIdAndStatusProductReceived(id));
    }

    // linh dep trai ok
    // Dai dep tai hon Linh
    @GetMapping("/get-all-final-valuations")
    public ResponseEntity<List<FinalValuationRequestDTO>> getListFinalValuationRequest() {
        return ResponseEntity.ok(valuationRequestService.getListFinalValuationRequest());
    }

    @PostMapping("/approve-final-valuation/{id}")
    public ResponseEntity<Map<String, String>> approveFinalValuationRequest(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.ApproveFinalValuationRequest(id));
    }
    @PostMapping("/cancel-final-valuation/{id}")
    public ResponseEntity<Map<String, String>> cancelFinalValuationRequest(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.CancelFinalValuationRequest(id));
    }
    //bao gom sendNotifyToMember service
    @PostMapping("/send-final-valuation-to-member/{id}")
    public ResponseEntity<List<Map<String,String>>> sendFinalValuationToMember(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.sendFinalValuationToMember(id));
    }

    @GetMapping("/get-all-valuation-manager-approved")
    public ResponseEntity<List<FinalValuationRequestDTO>> getListManagerApproveValuationRequest() {
        return ResponseEntity.ok(valuationRequestService.getListManagerApproveValuationRequest());
    }

    @GetMapping("/view-sent-request/{id}")
    public ResponseEntity<List<ViewValuationRequestDTO>> viewSentRequest(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.viewSentRequest(id));
    }
    @GetMapping("/view-my-response-request/{id}") // response id
    public ResponseEntity<ResponseRequestValuationDTO> viewMyResponseRequest(@PathVariable Integer id) {
        return ResponseEntity.ok(responseValuationRequestService.viewMyResponseRequestValuation(id));
    }

    @GetMapping("/view-valuation-response/{id}")
    public ResponseEntity<Map<String, Object>> getValuationResponseById(@PathVariable Integer id) {
        return ResponseEntity.ok(valuationRequestService.getValuationResponse(id));
    }



}
