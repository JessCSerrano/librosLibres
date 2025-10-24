package com.jessCSerrano.librosLibres.adapters.persistence.entity.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jessCSerrano.librosLibres.adapters.persistence.entity.client.ClientEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a purchase made by a customer.
 */
@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientEntity clientEntity;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    @Column(precision = 10, scale = 2)
    private BigDecimal total;
}
