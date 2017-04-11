import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static org.junit.Assert.*;



/**
 * Created by 1081_1 on 28.03.17.
 */
public class TableFunctionTest {
    private TableFunction t;
    double keys[] = {9,10,11,12};
    double values[] ={9,10,11,12};
    @Before
    public void Init()
    {
        t = new TableFunction();
        for(int i=0;i<keys.length;i++)
            t.Add(keys[i],values[i]);
    }
    @Test
    public void TestAdd()
    {
        for(int i=0;i<4;i++)
            assertEquals(t.Get(keys[i]).getValue(),values[i]);

    }
    @Test
    public void TestDelete()
    {
        t.Remove(keys[0],values[0]);
        for(int i=1;i<4;i++)
            assertEquals(t.Get(keys[i]).getValue(),values[i]);
        t.Remove(999,86);
        for(int i=1;i<4;i++)
            assertEquals(t.Get(keys[i]).getValue(),values[i]);


    }
    @Test
    public void InterPolation()
    {
        for(double i=keys[1];i<keys[keys.length-2];i+=0.1)
            assertEquals(t.InterPolation(i), i,0.0000001);

    }
    @Test
    public void TestFind()
    {
        for(int i=0;i<keys.length;i++)
        {
            assertEquals(t.Find(keys[i]).getKey(), keys[i]);
            assertEquals(t.Find(keys[i]).getValue(), values[i]);
        }
        assertEquals(t.Find(10.5).getValue(), 10.0);
        assertEquals(t.Find(10.55).getValue(), 11.0);
        assertEquals(t.Find(11.1).getValue(), 11.0);
        for(int i=0;i<keys.length;i++)
            t.Remove(keys[i],values[i]);
        assertEquals(t.Find(10.5), null);
    }


}