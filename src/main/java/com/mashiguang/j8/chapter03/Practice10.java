package com.mashiguang.j8.chapter03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Practice10 extends Application{

    /*
    * BiFunction<T, U, R>
    * T, U是参数
    * R是返回值
    * */

    public static Image transform(Image in, Function<Color, Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("dog1.jpg");
        UnaryOperator<Color> brighter = Color::brighter;
        //Function<Color, Color> brighter = Color::brighter;
        Image newImage = transform(image, brighter.compose(Color::grayscale));
        //Image newImage = transform(image, Color::darker);

        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(Practice10.class, args);
    }
}
