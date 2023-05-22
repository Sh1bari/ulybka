package com.example.ulybka.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OurWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String fileBefore;
    private String fileAfter;
    private String title;
    private String content;
}
