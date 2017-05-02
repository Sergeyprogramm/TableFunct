import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;


/**
 * Created by 1081_1 on 28.03.17.
 */
public class TableFunctionTest {
    private TableFunction t;
    ArrayList<Double> keys;
    ArrayList<Double> values;

    @Before
    public void Init() {
        t = new TableFunction();
        keys = new ArrayList<Double>();
        values = new ArrayList<Double>();
        for (double i = 0; i < 100; i += 0.5) {
            keys.add(i);
            values.add(i);
        }
        for (int i = 0; i < keys.size(); i++) t.Add(keys.get(i), values.get(i));
    }

    @Test
    public void get() throws Exception {
        for (double i = 0; i < 100; i++) org.junit.Assert.assertEquals((double) t.Get(i).getValue(), i, 0.000001);
        org.junit.Assert.assertEquals((double) t.Get(0.25).getValue(), 0, 0.000001);
        org.junit.Assert.assertEquals((double) t.Get(0.5).getValue(), 0.5, 0.000001);
    }

    @Test
    public void interPolation() throws Exception {
        for (double i = 1; i < 100; i++) {
            Object val = t.InterPolation(i);
            if (val != null)
                org.junit.Assert.assertEquals((double) ((Map.Entry) t.InterPolation(i)).getValue(), i, 0.000001);
        }
        for (double i = 0; i > -100; i--) org.junit.Assert.assertEquals(t.InterPolation(i), null);
    }
}