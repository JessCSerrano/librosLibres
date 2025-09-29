package com.jessCSerrano.librosLibres.domain.model.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jessCSerrano.librosLibres.domain.model.client.Client;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a purchase made by a customer.
 */
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private Double total;
}
