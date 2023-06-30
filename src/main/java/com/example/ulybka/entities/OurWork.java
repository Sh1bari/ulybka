package com.example.ulybka.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OurWork implements Comparable<OurWork>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Lob
    private String fileBefore;
    @Lob
    private String fileAfter;
    private String title;
    private String content;

    @Override
    public int compareTo(OurWork o){
        return id.compareTo(o.id);
    }
}
