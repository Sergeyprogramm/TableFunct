/**
 * Created by 1081_1 on 28.03.17.
 */
public class Main {
    public static void main(String[] args) {
        TableFunction t =new TableFunction();
        t.Add(1,1);
        t.Remove(1,1);
        t.Add(10,10);
        t.Add(12,12);
        t.Print(11);
        System.out.println(t.Find(10.55));
        System.out.println(t.InterPolation(11.5));
        Points points = new Points();
        for(int i=0;i<100;i++)
            points.Add(i,i);
        points.Print();

    }
}
