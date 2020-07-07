package de.hawh.kahlbrandt.ss2019bai2pm2exam;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

public class Horse {
    WalkingMode walkingMode = WalkingMode.Stand;
    private Map<Map.Entry<Command, WalkingMode>, WalkingMode> transition = new HashMap<>();

    public Horse() {
        transition.put(new AbstractMap.SimpleEntry<>(Command.Hue, WalkingMode.Stand), WalkingMode.Schritt);
        transition.put(new AbstractMap.SimpleEntry<>(Command.Hue, WalkingMode.Schritt), WalkingMode.Trab);
        transition.put(new AbstractMap.SimpleEntry<>(Command.Hue, WalkingMode.Trab), WalkingMode.Galopp);
        transition.put(new AbstractMap.SimpleEntry<>(Command.Brr, WalkingMode.Schritt), WalkingMode.Stand);
        transition.put(new AbstractMap.SimpleEntry<>(Command.Brr, WalkingMode.Trab), WalkingMode.Stand);
        transition.put(new AbstractMap.SimpleEntry<>(Command.Hue, WalkingMode.Galopp), WalkingMode.Trab);
    }

    public void feedCommand(Command command) {
        this.walkingMode = transition.getOrDefault(new AbstractMap.SimpleEntry<>(command, walkingMode), walkingMode);
    }
}
