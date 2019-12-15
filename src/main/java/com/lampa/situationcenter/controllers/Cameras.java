package com.lampa.situationcenter.controllers;

import com.lampa.situationcenter.services.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Cameras {
    private CameraService cameraService;

    @Autowired
    public Cameras(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping("/cameras")
    public List get() {
        return cameraService.getCameras();
    }
}
