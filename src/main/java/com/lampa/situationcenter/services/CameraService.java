package com.lampa.situationcenter.services;

import com.lampa.situationcenter.entity.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CameraService {
    private RandService randService;

    @Autowired
    public CameraService(RandService randService) {
        this.randService = randService;
    }

    public List<Camera> getCameras() {
        List<Camera> cameras = new ArrayList<>();

        for(int i=0; i < randService.getRand(); i++) {
            cameras.add(randService.createCamera());
        }

        return cameras;
    }
}
