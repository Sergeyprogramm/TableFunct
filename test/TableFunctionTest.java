import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Created by 1081_1 on 28.03.17.
 */
public class TableFunctionTest {
    private Points t;
    double keys[] = {9,10,11,12};
    double values[] ={9,10,11,12};
    double f(double x)
    {
        return 2*x;
    }
    @Before
    public void Init()
    {
        t = new Points();
        for(int i=0;i<keys.length;i++)
            t.Add(keys[i],values[i]);
    }
    @Test
    public void TestAdd()
    {
        for(int i=0;i<4;i++)
            org.junit.Assert.assertEquals(t.Get(keys[i]).y,values[i],0.000001);
    }
    @Test
    public void TestDelete()
    {
        t.Remove(0);
        for(int i=1;i<4;i++)
            org.junit.Assert.assertEquals(t.Get(keys[i]).y,values[i],0.000001);
    }
    @Test
    public void InterPolation1()
    {
        for(double i=keys[1];i<keys[keys.length-2];i+=0.1) {
            org.junit.Assert.assertEquals(t.InterPolation(i).y, i, 0.0000001);
        }
    }
    @Test
    public void InterPolation2()
    {
        t.RemoveAll();
        for(int i=0;i<keys.length;i++)
            t.Add(keys[i],f(keys[i]));
        for(double i=0;i<100;i+=0.1) {
            Point p= t.InterPolation(i);
            if(p!=null)
                org.junit.Assert.assertEquals(p.y, f(i), 0.0000001);
        }
    }
    @Test
    public void TestFind1() {
        for (int i = 0; i < keys.length; i++) {
            Point temp = t.Find(keys[i]);
            org.junit.Assert.assertEquals(temp.x, keys[i], 0.0000001);
            org.junit.Assert.assertEquals(temp.y, values[i], 0.0000001);
        }
    }
    @Test
    public void TestFind2() {
        org.junit.Assert.assertEquals(t.Find(10.5).y, 10.0, 0.0000001);
        org.junit.Assert.assertEquals(t.Find(10.55).y, 11.0, 0.0000001);
        org.junit.Assert.assertEquals(t.Find(11.1).y, 11.0, 0.0000001);
    }
    @Test
    public void TestFind3(){
        t.RemoveAll();
        org.junit.Assert.assertEquals(t.Find(10.5), null);
    }



}