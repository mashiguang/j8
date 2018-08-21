package com.mashiguang.j8.chapter03;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Practice11 extends Application{

    public static Image transform(Image in, ColorTransformer t) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y,
                        t.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("dog1.jpg");
        Image newImage = transform(image,
                (x, y, c) -> {
                    if (x <= 20) return Color.BLACK;
                    if (y <= 20) return Color.BLACK;
                    return c;
                }
        );

        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Practice11.class, args);
    }
}

@FunctionalInterface
interface ColorTransformer {
    Color apply(int x, int y, Color colorAtXY);
}
