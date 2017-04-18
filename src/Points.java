import java.util.ArrayList;
import static java.lang.Math.abs;

/**
 * Created by 1081_1 on 18.04.17.
 */
public class Points {
    ArrayList<Point> points = new ArrayList<>();

    public void Add(double x, double y) {
        points.add(new Point(x, y));
    }

//    public void Add(Point p) {
//        points.add(p);
//    }

    public void Remove(int index) {
        points.remove(index);
    }

    public void RemoveAll() {
        points.removeAll(points);
    }

    public Point Get(double x) {
        for (int i = 0; i < points.size(); i++)
            if (x == points.get(i).x)
                return points.get(i);
        return null;
    }

    public Point Find(double x) {
        if (points.size() > 0) {
            double dif = abs(points.get(0).x - x);
            Point res = points.get(0);
            for (int i = 0; i < points.size(); i++) {
                if (dif > abs(points.get(i).x - x)) {
                    dif = abs(points.get(i).x - x);
                    res = points.get(i);
                }
            }
            return res;
        } else
            return null;
    }

    public Point InterPolation(double x) {
        if (points.size() > 1) {
            Point before = null;
            int index = -1;
            for (int i = 0; i < points.size(); i++)
                if (points.get(i).x < x) {
                    before = points.get(i);
                    index = i;
                }
            if (before != null) {
            }
            Point after = points.get(index + 1);
            if (after != null) {
                double x0 = before.x, y0 = before.y;
                double x1 = after.x, y1 = after.y;
                return new Point(x, y0 + ((y1 - y0) / (x1 - x0)) * (x - x0));
            }
        }

        return null;
    }

    public void Print() {
        for (int i = 0; i < points.size(); i++)
            points.get(i).Print();
    }
}
