package com.example.ludwig.libraryP.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Data
public class BookManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime borrowDate;
    @Future
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime returnDate;
    private int bookId;
    private int studentId;
}
