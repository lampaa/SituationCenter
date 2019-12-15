package com.lampa.situationcenter.entity;

import java.util.Date;

public class RecognitionEvent {
    private Integer id;
    private Date added;
    private Camera camera;

    public RecognitionEvent(Integer id, Date added, Camera camera) {
        this.id = id;
        this.added = added;
        this.camera = camera;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
}
