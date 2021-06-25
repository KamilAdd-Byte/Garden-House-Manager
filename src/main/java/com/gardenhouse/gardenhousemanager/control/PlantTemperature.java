package com.gardenhouse.gardenhousemanager.control;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "temperature")
public class PlantTemperature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temp_id")
    private int temperaturePlantId;

    @Column(name = "temp_min")
    private double minimum;

    @Column(name = "temp_max")
    private double maximum;

    @Column(name = "temp_actual")
    private double actual;


}
