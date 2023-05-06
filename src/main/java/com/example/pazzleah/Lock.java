package com.example.pazzleah;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.*;

public class Lock {

    ArrayList<Integer> cellsColorIndexes;
    ArrayList<Integer> placesColorIndexes;
    ArrayList<Circle> cirArr;
    ArrayList<Circle> indicatorsArr = new ArrayList<>();
    Circle bigCircle = new Circle();
    Circle smallCircle = new Circle();
    ArrayList<CubicCurve> triangle = new ArrayList<>();
    Button left = new Button();
    Button right = new Button();
    Button swap = new Button();
    Text aText = new Text();
    Text dText = new Text();
    Text sText = new Text();

    double triangleRotateDistance;
    double getTriangleRotateStartingPoint;


    Lock(ArrayList<Integer> cells, ArrayList<Integer> places, Scene scene, Pane pane) {
        pane.getChildren().add(left);
        pane.getChildren().add(right);
        pane.getChildren().add(swap);
        pane.getChildren().add(aText);
        pane.getChildren().add(dText);
        pane.getChildren().add(sText);

        left.setPrefWidth(70);
        left.setPrefHeight(70);
        left.setText("A");
        left.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        right.setPrefWidth(70);
        right.setPrefHeight(70);
        right.setText("D");
        right.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        swap.setPrefWidth(70);
        swap.setPrefHeight(70);
        swap.setText("S");
        swap.setFont(Font.font("Arial", FontWeight.BOLD, 35));

        left.setLayoutX(scene.getWidth() * 0.25 - left.getPrefWidth() / 2.0);
        left.setLayoutY(scene.getHeight() * 0.9 - left.getPrefHeight() / 2.0);

        right.setLayoutX(scene.getWidth() * 0.75 - right.getPrefWidth() / 2.0);
        right.setLayoutY(scene.getHeight() * 0.9 - right.getPrefHeight() / 2.0);

        swap.setLayoutX(scene.getWidth() / 2.0 - swap.getPrefWidth() / 2.0);
        swap.setLayoutY(scene.getHeight() * 0.9 - swap.getPrefHeight() / 2.0);

        aText.setText("Повернуть влево");
        dText.setText("Повернуть вправо");
        sText.setText("Поменять");
        aText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        dText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        sText.setFont(Font.font("Arial", FontWeight.BOLD, 35));
        aText.setLayoutX(left.getLayoutX() + left.getPrefWidth() / 2. - 250);
        aText.setLayoutY(left.getLayoutY() - 10);
        dText.setLayoutX(right.getLayoutX() + right.getPrefWidth() / 2 - 250);
        dText.setLayoutY(right.getLayoutY() - 10);
        sText.setLayoutX(swap.getLayoutX() + swap.getPrefWidth() / 2 - 250);
        sText.setLayoutY(swap.getLayoutY() - 10);

        aText.setWrappingWidth(500);
        aText.setTextAlignment(TextAlignment.CENTER);
        dText.setWrappingWidth(500);
        dText.setTextAlignment(TextAlignment.CENTER);
        sText.setWrappingWidth(500);
        sText.setTextAlignment(TextAlignment.CENTER);

        this.cellsColorIndexes = cells;
        this.placesColorIndexes = places;

        bigCircle.setCenterX(scene.getWidth() / 2);
        bigCircle.setCenterY(scene.getHeight() / 2);
        bigCircle.setRadius(240);
        bigCircle.setFill(Color.web("#2B2B2B", 1.0));
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);

        smallCircle.setCenterX(scene.getWidth() / 2);
        smallCircle.setCenterY(scene.getHeight() / 2);
        smallCircle.setRadius(130);
        smallCircle.setFill(Color.web("#252525", 1.0));
        smallCircle.setStrokeWidth(3);
        smallCircle.setStroke(Color.BLACK);

        this.triangle.add(new CubicCurve());
        this.triangle.add(new CubicCurve());

        this.triangle.get(0).setStartX(getOnCirclePosX(bigCircle.getCenterX(), 185, 2 * (Math.PI / 4)));
        this.triangle.get(0).setStartY((double) getOnCirclePosY(bigCircle.getCenterY(), 185, 1 * (Math.PI / 4)) - 40);

        this.triangle.get(0).setControlX1((double) getOnCirclePosX(bigCircle.getCenterX(), 230, 1 * (Math.PI / 4)) + 70);
        this.triangle.get(0).setControlY1((double) getOnCirclePosY(bigCircle.getCenterY(), 230, 1 * (Math.PI / 4)) - 70);

        this.triangle.get(0).setControlX2((double) getOnCirclePosX(bigCircle.getCenterX(), 230, 1 * (Math.PI / 4)) + 70);
        this.triangle.get(0).setControlY2((double) getOnCirclePosY(bigCircle.getCenterY(), 230, 1 * (Math.PI / 4)) - 20);

        this.triangle.get(0).setEndX(getOnCirclePosX(bigCircle.getCenterX(), 185, 2 * (Math.PI / 4)));
        this.triangle.get(0).setEndY((double) getOnCirclePosY(bigCircle.getCenterY(), 185, 2 * (Math.PI / 4)) + 40);

        this.triangle.get(1).setStartX(getOnCirclePosX(bigCircle.getCenterX(), 185, 2 * (Math.PI / 4)));
        this.triangle.get(1).setStartY((double) getOnCirclePosY(bigCircle.getCenterY(), 185, 3 * (Math.PI / 4)) - 40);

        this.triangle.get(1).setControlX1((double) getOnCirclePosX(bigCircle.getCenterX(), 230, 3 * (Math.PI / 4)) - 70);
        this.triangle.get(1).setControlY1((double) getOnCirclePosY(bigCircle.getCenterY(), 230, 3 * (Math.PI / 4)) - 70);

        this.triangle.get(1).setControlX2((double) getOnCirclePosX(bigCircle.getCenterX(), 230, 3 * (Math.PI / 4)) - 70);
        this.triangle.get(1).setControlY2((double) getOnCirclePosY(bigCircle.getCenterY(), 230, 3 * (Math.PI / 4)) - 20);

        this.triangle.get(1).setEndX(getOnCirclePosX(bigCircle.getCenterX(), 185, 2 * (Math.PI / 4)));
        this.triangle.get(1).setEndY((double) getOnCirclePosY(bigCircle.getCenterY(), 185, 2 * (Math.PI / 4)) + 40);

        this.triangle.get(0).setFill(Color.web("#464435", 0.5));
        this.triangle.get(1).setFill(Color.web("#464435", 0.5));

        for (int i = 0; i < 8; i++) {
            indicatorsArr.add(new Circle());
            pane.getChildren().add(indicatorsArr.get(i));
            indicatorsArr.get(i).setRadius(30);
            indicatorsArr.get(i).setCenterX(getOnCirclePosX(bigCircle.getCenterX(), 225, i * (Math.PI / 4)));
            indicatorsArr.get(i).setCenterY(getOnCirclePosY(bigCircle.getCenterY(), 225, i * (Math.PI / 4)));
            indicatorsArr.get(i).setStrokeWidth(3);
            indicatorsArr.get(i).setStroke(Color.BLACK);
        }
        this.setIndicatorsArray(indicatorsArr, this);
        pane.getChildren().add(bigCircle);
        pane.getChildren().add(smallCircle);
        pane.getChildren().add(this.triangle.get(0));
        pane.getChildren().add(this.triangle.get(1));
        cirArr = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            cirArr.add(new Circle());
            pane.getChildren().add(cirArr.get(i));
            cirArr.get(i).setRadius(25);
            cirArr.get(i).setCenterX(getOnCirclePosX(bigCircle.getCenterX(), 185, i * (Math.PI / 4)));
            cirArr.get(i).setCenterY(getOnCirclePosY(bigCircle.getCenterY(), 185, i * (Math.PI / 4)));
            cirArr.get(i).setStrokeWidth(3);
            cirArr.get(i).setStroke(Color.web("#7A8052", 0.45));
        }
        triangleRotateDistance = Math.abs(cirArr.get(1).getCenterX()-cirArr.get(3).getCenterX());
        getTriangleRotateStartingPoint = cirArr.get(1).getCenterX();
    }

    public Color getCellsColor(int cellsColorIndex) {
        return AppSettings.SINGLETON.getColorMap().get(cellsColorIndex);
    }

    public int getCellsColorIndexes(int index) {
        return this.cellsColorIndexes.get(index);
    }

    public int getPlacesColorIndexes(int index) {
        return this.placesColorIndexes.get(index);
    }

    public static int getOnCirclePosX(double circleX, double l, double angle) {
        return (int) (circleX + l * Math.cos(angle));
    }

    public static int getOnCirclePosY(double circleY, double l, double angle) {
        return (int) (circleY + l * Math.sin(angle));
    }
    public boolean isCompleted() {
        //return this.getPlacesColorIndexes()==this.getCellsColorIndexes();
        for (int i = 0; i < 8; i++) {
            if (this.getCellsColorIndexes(i) != this.getPlacesColorIndexes(i)) {
                return false;
            }
        }
        return true;
    }
    public void setCirclesArray(ArrayList<Circle> cirArr, Lock lock) {
        for (int i = 0; i < 8; i++) {
            cirArr.get(i).setFill(lock.getCellsColor(lock.getCellsColorIndexes(i)));
            if (lock.getCellsColorIndexes(i) == 0) {
                cirArr.get(i).setRadius(7);
            } else {
                cirArr.get(i).setRadius(25);
            }
        }
    }
    public void setIndicatorsArray(ArrayList<Circle> rectArr, Lock lock) {
        new Thread(() -> {
            for (int j = 0; j <= 22; j++) {
                try {
                    Thread.sleep(6);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int k = j;
                Platform.runLater(() -> {
                    for (int i = 0; i < 8; i++) {
                        rectArr.get(i).setFill(lock.getCellsColor(lock.getPlacesColorIndexes(i)));
                        if ((lock.getCellsColorIndexes(i) == getPlacesColorIndexes(i) || lock.getPlacesColorIndexes(i) == 0) && rectArr.get(i).getRadius() != 25) {
                            rectArr.get(i).setRadius(47 - k);
                        }
                        if ((lock.getCellsColorIndexes(i) != getPlacesColorIndexes(i) && lock.getPlacesColorIndexes(i) != 0) && rectArr.get(i).getRadius() != 47) {
                            rectArr.get(i).setRadius(25 + k);
                        }
                    }
                });
            }
        }).start();
    }

    public void rotateLock(int a) {
        Collections.rotate(this.cellsColorIndexes, a);
        this.setIndicatorsArray(this.indicatorsArr, this);
        new Thread(() -> {
            for (int j = 0; j <= 40; j++) {
                try {
                    Thread.sleep(3 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int k = j;
                Platform.runLater(() -> {
                    for (int i = 0; i < 8; i++) {
                        double formula = a/2.0*k * (Math.PI / 80)+(i-a)*(Math.PI / 4);
                        cirArr.get(i).setCenterX(getOnCirclePosX(bigCircle.getCenterX(), 185,  formula));
                        cirArr.get(i).setCenterY(getOnCirclePosY(bigCircle.getCenterY(), 185,  formula));
                    }
                    this.setCirclesArray(this.cirArr, this);
                });
            }
        }).start();
    }

    public void rotateTriangle() {
        int a1, b1, c1;
        a1 = this.cellsColorIndexes.get(1);
        b1 = this.cellsColorIndexes.get(2);
        c1 = this.cellsColorIndexes.get(3);
        this.cellsColorIndexes.set(1, b1);
        this.cellsColorIndexes.set(2, c1);
        this.cellsColorIndexes.set(3, a1);
        this.setIndicatorsArray(this.indicatorsArr, this);

        new Thread(() -> {
            for (int j = 0; j <= 20; j++) {
                try {
                    Thread.sleep(6 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int k = j;
                Platform.runLater(() -> {
                    for (int i = 1; i <= 2; i++) {
                        double formula1 = -k * (Math.PI / 80)+(i+1)*(Math.PI / 4);
                        cirArr.get(i).setCenterX(getOnCirclePosX(bigCircle.getCenterX(), 185,  formula1));
                        cirArr.get(i).setCenterY(getOnCirclePosY(bigCircle.getCenterY(), 185,  formula1));
                    }
                    cirArr.get(3).setCenterX(getTriangleRotateStartingPoint-k*triangleRotateDistance/20);
                    this.setCirclesArray(this.cirArr, this);
                });
            }
        }).start();

    }
}
