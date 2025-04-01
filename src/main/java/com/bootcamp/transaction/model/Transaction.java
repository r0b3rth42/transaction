package com.bootcamp.transaction.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "transaction")
public class Transaction {
    @Id
    private String id;

    @NotBlank(message = "Product ID is required")
    private String productId;

    @NotNull(message = "Transaction type is required")
    private TransactionType type;

    @NotNull(message = "Amount is required")
    @Min(value = 0, message = "Amount must be positive")
    private Double amount;

    private String description;
    private LocalDateTime transactionDate;

    @NotBlank(message = "Customer ID is required")
    private String customerId;

    public enum TransactionType {
        DEPOSIT, RETIRO, PAYMENT, CONSUMPTION
    }
}
