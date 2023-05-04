package com.inf1013.example1.backend.models;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Auto-incremented booking id

    private Long offerId;
    private Long clientId;

    private String date;
    private String hour;

    private String location = "";

    private String status = "waiting";

    public String toJson() {
        return "{" +
            "\"id\":" + id + "," +
            "\"offerId\":" + offerId + "," +
            "\"userId\":" + clientId + "," +
            "\"date\":\"" + date + "\"," +
            "\"hour\":\"" + hour + "\"," +
            "\"location\":\"" + location + "\"," +
            "\"status\":\"" + status + "\"" +
        "}";
    }

}
