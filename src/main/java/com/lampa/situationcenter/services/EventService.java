package com.lampa.situationcenter.services;

import com.lampa.situationcenter.entity.Camera;
import com.lampa.situationcenter.entity.RecognitionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.*;

@Service
public class EventService {
    private RandService randService;
    private WebSocketService webSocketService;
    private Timer timer = new Timer();
    private List<Camera> lastRequestCameras = new ArrayList<>();

    @Autowired
    public EventService(RandService randService, WebSocketService webSocketService) {
        this.randService = randService;
        this.webSocketService = webSocketService;
    }

    @PostConstruct
    private void init() {
        timer.schedule(new EventTimerTask(), 0, 1000);
    }

    @PreDestroy
    private void destroy() {
        timer.cancel();
    }

    public List<RecognitionEvent> getRecognitionEvents(List<Camera> cameras) {
        List<RecognitionEvent> events = new ArrayList<>();

        for(Camera camera : cameras) {
            for(int i=0; i < randService.getRand(10, 20); i++) {
                events.add(randService.createEvent(camera));
            }
        }

        lastRequestCameras = cameras;

        return events;
    }

    private class EventTimerTask extends TimerTask {

        @Override
        public void run() {
            try {
                for(Camera camera : lastRequestCameras) {
                    webSocketService.sendRecognitionEvent(randService.createEvent(camera));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
