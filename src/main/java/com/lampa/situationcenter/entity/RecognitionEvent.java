package com.lampa.situationcenter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class RecognitionEvent {
    private Integer id;
    private Date added;
    private Camera camera;
}
