import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by 1081_1 on 18.04.17.
 */
public class Points {
    ArrayList<Point> points = new ArrayList<>();

    public void Add(double x, double y) {
        points.add(new Point(x, y));
    }
    

    public void Remove(int index) {
        points.remove(index);
    }

    public void RemoveAll() {
        points.removeAll(points);
    }

    public Map<Double,Double> GetPoints()
    {
        Map<Double,Double> res= new HashMap<>();
        for(Point point: points)
            res.put(point.x,point.y);
        return res;
    }
    public Point Get(double x)
    {
        Map<Double,Double> map= GetPoints();
        if(map.containsKey(x))
            return new Point(x, map.get(x));
        else
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
        if(points.size()>1) {
            Point before = null , after = null;
            for(double i=x;i>=points.get(0).x;i-=0.1) {
                before = Get(Math.round(i));
                if (before != null && before.x <x) break;
            }
            for(double i=x;i<=points.get(points.size()-1).x;i+=0.1) {
                after = Get(Math.round(i));
                if(after!=null && after.x>x)break;
            }
            if (before != null && after != null) {
                double x0 = before.x, y0 = before.y,x1 = after.x, y1 = after.y;
                return new Point(x,y0 + ((y1 - y0) / (x1 - x0)) * (x - x0));
            }
        }
        return null;
    }

    public void Print() {
        for (int i = 0; i < points.size(); i++)
            points.get(i).Print();
    }
}
