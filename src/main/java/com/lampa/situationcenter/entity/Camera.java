package com.lampa.situationcenter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Camera {
    private Integer id;
    private String name;
    private Location location;
}
