package utils;

import entity.Location;
import repository.ConfigVar;

public class RandomizerLocation {

    public int getLocation()
    {
        return  (int)(Math.random()* ConfigVar.X);
    }
}
