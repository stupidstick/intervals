package com.stupidstick.intervals.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "letters_intervals", uniqueConstraints = @UniqueConstraint(columnNames = {"interval_start", "interval_end"}))
@Data
@NoArgsConstructor
public class LettersInterval implements BaseInterval<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "interval_start", nullable = false)
    private String start;
    @Column(name = "interval_end", nullable = false)
    private String end;
}
