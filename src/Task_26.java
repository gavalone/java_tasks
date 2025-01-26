import java.util.Scanner;

class ColorModel {
}

class RGBconverter extends ColorModel {
    public static double[] RGBtoCMYK(int r, int g, int b) {
        double c = 1 - (r / 255.0);
        double m = 1 - (g / 255.0);
        double y = 1 - (b / 255.0);
        double k = Math.min(c, Math.min(m, y));

        if (k == 1) { // если цвет черный (k=1), то c,m,y=0
            return new double[]{0, 0, 0, 1};
        }

        c = (c - k)/(1 - k);
        m = (m - k)/(1 - k);
        y = (y - k)/(1 - k);
        return new double[]{c, m, y, k};
    }
}

class CMYKconverter extends ColorModel {
    public static int[] CMYKtoRGB(double c, double m, double y, double k) {
        int r = (int) (255 * (1 - c) * (1 - k));
        int g = (int) (255 * (1 - m) * (1 - k));
        int b = (int) (255 * (1 - y) * (1 - k));
        return new int[]{r, g, b};
    }
}

public class Task_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите значения формата rgb для конвертации в cmyk: ");
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        double[] cmyk = RGBconverter.RGBtoCMYK(r, g, b);
        System.out.printf("%.2f, %.2f, %.2f, %.2f\n", cmyk[0], cmyk[1], cmyk[2], cmyk[3]);

        System.out.println("Введите значения в формате cmyk для конвертации в rgb:");
        double c = sc.nextDouble();
        double m = sc.nextDouble();
        double y = sc.nextDouble();
        double k = sc.nextDouble();
        int[] rgb = CMYKconverter.CMYKtoRGB(c, m, y, k);
        System.out.println(rgb[0] + ", " + rgb[1] + ", " + rgb[2]);
    }
}