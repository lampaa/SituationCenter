package com.lampa.situationcenter.controllers;

import com.lampa.situationcenter.entity.Camera;
import com.lampa.situationcenter.entity.RecognitionEvent;
import com.lampa.situationcenter.services.EventService;
import com.lampa.situationcenter.services.RandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class Events {
    private EventService eventService;
    private RandService randService;

    @Autowired
    public Events(EventService eventService, RandService randService) {
        this.eventService = eventService;
        this.randService = randService;
    }

    @ModelAttribute
    private List<Camera> getCameraById(@RequestParam(value = "camera", required = false) List<Integer> ids) {
        List<Camera> cameras = new ArrayList<>();

        if(ids != null) {
            for(Integer id: ids) {
                cameras.add(randService.createCamera(id));
            }
        }

        return cameras;
    }

    @GetMapping("/events")
    public List<RecognitionEvent> get(List<Camera> cameras) {
        return eventService.getRecognitionEvents(cameras);
    }
}
