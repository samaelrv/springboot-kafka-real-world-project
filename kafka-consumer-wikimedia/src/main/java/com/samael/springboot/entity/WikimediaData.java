package com.samael.springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Table(name= "wikimedia_recentchange")
@Data
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Size(max = 5000, message = "wiki_events cannot be longer than 5000 characters")
    private String wikiEvents;

}
