package app.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Fair {

    private int id;
    private String name;
    private String address;
    private String time;
    private String weekday;
    private double latitude;
    private double longitude;
}