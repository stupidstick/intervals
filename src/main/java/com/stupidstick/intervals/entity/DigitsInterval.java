package com.stupidstick.intervals.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Table(name = "digits_intervals", uniqueConstraints = @UniqueConstraint(columnNames = {"interval_start", "interval_end"}))
@Data
@NoArgsConstructor
public class DigitsInterval implements BaseInterval<BigInteger> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "interval_start", nullable = false)
    private BigInteger start;
    @Column(name = "interval_end", nullable = false)
    private BigInteger end;
}
