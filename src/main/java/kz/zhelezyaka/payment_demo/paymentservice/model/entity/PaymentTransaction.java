package kz.zhelezyaka.payment_demo.paymentservice.model.entity;

import jakarta.persistence.*;

import kz.zhelezyaka.payment_demo.paymentservice.model.enums.PaymentTransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentTransaction extends BaseEntity {

    private BigDecimal amount;
    private String currency;

    @Convert(converter = PaymentTransactionStatus.class)
    private PaymentTransactionStatus paymentTransactionStatus;

    private String errorMessage;

    @ManyToOne
    @JoinColumn(name = "sourceBankAccountId")
    private BankAccount sourceBankAccount;

    @ManyToOne
    @JoinColumn(name = "destinationBankAccountId")
    private BankAccount destinationBankAccount;

    @OneToMany(mappedBy = "paymentTransaction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Refund> refunds;

}
