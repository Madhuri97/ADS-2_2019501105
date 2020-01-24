
import java.awt.Color;
class SeamCarver {

    Picture p;
    int width;
    int height;
    public SeamCarver(Picture picture) {
        p = new Picture(picture);
        width = p.width();
        height = p.height();
    }

    public Picture picture() {
        return p;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public double energy(int x, int y) {
        if(x >= width() || x < 0 || y >= height() || y < 0) {
            throw new IndexOutOfBoundsException();
        }
        if(x == 0 || x == width() - 1 || y == 0 || y == height() - 1) {
            return 0;
        }
        double dltX = 0.0;
        double dltY = 0.0;
        Color r1 = p.get(x - 1, y);
        Color l1 = p.get(x + 1, y);
        Color b1 = p.get(x,y - 1);
        Color t1 = p.get(x,y + 1);
        dltX = Math.pow((r1.getRed() - l1.getRed()), 2) + Math.pow((r1.getBlue() - l1.getBlue()), 2) + Math.pow((r1.getGreen() - l1.getGreen()), 2);
        dltY = Math.pow((b1.getRed() - t1.getRed()), 2) + Math.pow((b1.getBlue() - t1.getBlue()), 2) + Math.pow((b1.getGreen() - t1.getGreen()), 2);
        return Math.sqrt(dltX + dltY); 
    }
}