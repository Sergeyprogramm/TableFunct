import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.abs;

/**
 * Created by 1081_1 on 28.03.17.
 */
public class TableFunction {
    private TreeMap<Double, Double> table = new TreeMap<Double, Double>();

    public void Add(double x, double y) {
        table.put(x, y);
    }

    public void Remove(double x, double y) {
        table.remove(x, y);
    }

    private void Print(Map.Entry item) {
        System.out.println("x:" + item.getKey() + " y:" + item.getValue());
    }


    public Map.Entry Get(double x) {
        if (table.floorEntry(x) != null)
            return table.floorEntry(x);
        else
            return table.ceilingEntry(x);

    }

    public MEntry InterPolation(double x) {
        Map.Entry before = Get(x - Math.ulp(x));
        Map.Entry after = table.ceilingEntry(x +  Math.ulp(x));
        if (before != null && after != null) {
            double x0 = (double) before.getKey(), y0 = (double) before.getValue();
            double x1 = (double) after.getKey(), y1 = (double) after.getValue();
            if ((x1 - x0) != 0)
                return new MEntry(x, y0 + ((y1 - y0) / (x1 - x0)) * (x - x0));
            else return null;
        }
        return null;
    }
}
