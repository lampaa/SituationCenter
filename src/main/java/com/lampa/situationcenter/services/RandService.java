package com.lampa.situationcenter.services;

import com.lampa.situationcenter.entity.Camera;
import com.lampa.situationcenter.entity.Location;
import com.lampa.situationcenter.entity.RecognitionEvent;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class RandService {
    private Random random = new Random();
    private static final String AB = "0123456789abcdefghijklmnopqrstuvwxyz";

    public int getRand(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public float getRand(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public int getRand() {
        return getRand(50, 99);
    }

    public String getStringRand(int count) {
        StringBuilder sb = new StringBuilder(count );
        for( int i = 0; i < count; i++ )
            sb.append( AB.charAt( random.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public Camera createCamera() {
        return new Camera(
                getRand(1000, 2000),
                getStringRand(5).toUpperCase(),
                new Location(getRand(50, 60), getRand(60, 70)));
    }

    public Camera createCamera(Integer id) {
        return new Camera(id, getStringRand(5).toUpperCase(),
                new Location(getRand(50, 60), getRand(60, 70)));
    }

    public RecognitionEvent createEvent(Camera camera) {
        return new RecognitionEvent(getRand(3000, 4000), new Date(), camera);
    }
}
