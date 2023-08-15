package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {

    BufferedImage image;


    // ====== Constructor With One Parameter (Path of origin Image) =========
    public Bitmap(String path) {

        try {
            this.image = ImageIO.read(new File(path));
        }catch (IOException e){
            System.out.println("Error Bitmap : " + e.getMessage());
        }

    }

    // ============Write New Image==========
    public void writeNewImage(String pathOfNewImage){
        try {
            ImageIO.write(this.image ,"bmp" , (new File(pathOfNewImage)));
        }
        catch (IOException e){
            System.out.println("Error writeNewImage : " + e.getMessage());
        }
    }


    public void convertImageToGray() {
        for (int i=0; i < this.image.getWidth(); i++){
            for( int j=0; j < this.image.getHeight(); j++){
                //getting RGB color on each pixel
                Color color = new Color(this.image.getRGB(i, j));
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                int a = color.getAlpha();
                //turning color to grayscale
                int grayColor = (r + g + b) / 3;

                //create gray color
                Color grayColors = new Color (grayColor, grayColor, grayColor, a);
                this.image.setRGB(i, j, grayColors.getRGB());
            }
        }
    }

    public void mirrorImageHorizontally() {
        for (int i = 0; i < this.image.getHeight(); i++) {
            for (int j = 0; j < this.image.getWidth() / 2; j++) {
                int temp = this.image.getRGB(j, i);
                this.image.setRGB(j, i, this.image.getRGB(this.image.getWidth() - j - 1, i));
                this.image.setRGB(this.image.getWidth() - j - 1, i, temp);
            }
        }
    }



    public void mirrorImageVertically(){
        for (int i = 0; i < this.image.getWidth(); i++){
            for (int j = 0; j < this.image.getHeight()/2; j++){
                int temp = this.image.getRGB(i,j);
                this.image.setRGB(i,j, this.image.getRGB(i,this.image.getHeight() - j - 1));
                this.image.setRGB(i,this.image.getHeight() - j - 1, temp);
            }
        }

    }




}