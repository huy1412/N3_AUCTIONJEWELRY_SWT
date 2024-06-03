package com.fpt.edu.entity;

import com.fpt.edu.status.FinancialProofRequestStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "financial_proof_request")
public class FinancialProofRequest {
    //done
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financial_proof_request_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private FinancialProofRequestStatus status;

    @Column(name = "financial_proof_amount", precision = 19, scale = 1)
    private BigDecimal financialProofAmount;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "financialProofRequest")
    private Set<FinancialProofImage> financialProofImages = new LinkedHashSet<>();

}