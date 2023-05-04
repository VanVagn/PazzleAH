package com.example.pazzleah;
import javafx.scene.paint.Color;
import java.util.HashMap;
import java.util.Map;

public class AppSettings {
    public static final AppSettings SINGLETON = new AppSettings();;

    AppSettings() {
        colorMap = new HashMap<>();
        colorMap.put(1, Color.web("#FFFFFF",1)); // Белый
        colorMap.put(2, Color.web("#F3F978",1)); //Желтый
        colorMap.put(3, Color.web("#52C4EF",1)); //Голубой
        colorMap.put(4, Color.web("#81CFA5",1)); //Зеленый
        colorMap.put(5, Color.web("#2B2B2B",1)); //Пустой
        colorMap.put(6, Color.web("#F3C0EB",1)); //Розовый
        colorMap.put(7, Color.web("#FD5845",1)); //Красный
        colorMap.put(8, Color.web("#81CFA5",1)); //Зеленый
    }
    private  Map<Integer, Color> colorMap;

    public Map<Integer, Color> getColorMap() {
        return colorMap;
    }
}

/*
new ArrayList<Integer>(Arrays.asList(5,5,7,3,1,2,4,6)),
new ArrayList<Integer>(Arrays.asList(6,2,5,4,7,1,3,5)),*/ //Самый сложный уровень
