package com.example.ulybka.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OurWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fileBefore;
    private String fileAfter;
    private String title;
    private String content;
}
