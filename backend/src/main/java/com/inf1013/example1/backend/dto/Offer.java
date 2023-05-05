package com.inf1013.example1.backend.dto;

import lombok.Data;

@Data
public class Offer {

    private String title = "";

    private Long hairdresserId;

    private int duration;

    private int grade;

    private String imageUrl = "";

    private String description = "";

    private String location = "";
}
