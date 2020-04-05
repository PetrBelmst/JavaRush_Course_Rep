package com.company;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes item) {
        if (item == ImageTypes.BMP) {
            return new BmpReader();
        }
        if (item == ImageTypes.JPG) {
            return new JpgReader();
        }
        if (item == ImageTypes.PNG) {
            return new PngReader();
        } else
            throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
