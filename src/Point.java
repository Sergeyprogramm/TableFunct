import java.util.ArrayList;
import static java.lang.Math.abs;

/**
 * Created by 1081_1 on 18.04.17.
 */
public class Point {
    public double x;
    public double y;

    void Print() {
        System.out.println("x:" + x + " y:" + y);
    }

    Point(double _x, double _y) {
        y = _y;
        x = _x;
    }
}
