package org.jorgma.athome.rpi.business;

import org.jorgma.athome.rpi.dao.RpiBackLight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by jorgma on 2018-03-24.
 */
@Service
public class RpiBackLightBlImpl implements RpiBackLightBl{
    @Value("${rpi.backLight.path}")
    private String filePath;

    @Override
    public int getBackLightIntensity() {
        return readBackLightIntensity();
    }


    private int readBackLightIntensity() {
        int backLightIntensity = 11;
        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            backLightIntensity =  Integer.parseInt(lines.get(0));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return backLightIntensity;
    }

    @Override
    public void setBackLightIntensity(RpiBackLight rpiBackLight) throws IOException {
        writeBackLightIntensity(rpiBackLight.getIntensity());
    }

    private void writeBackLightIntensity(int intensity) throws IOException {
        Path path = Paths.get(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(String.valueOf(intensity));
        }
    }
}
