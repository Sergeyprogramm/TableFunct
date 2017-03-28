import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by 1081_1 on 28.03.17.
 */
public class TableFunction {
    HashMap<Double,Double> table = new HashMap<Double,Double>();

    //метод добавления пары
    public void Add (double x,double y)
    {
        table.put(x,y);
    }
    //метод удаления пары
    public void Remove (double x, double y)
    {
        table.remove(x,y);
    }


    //показывает множество пар
    private void Print(Map.Entry item)
    {
        System.out.println("x:" +item.getKey()+" y:" +item.getValue());
    }
    public void Print(){
        for(Map.Entry item: table.entrySet())
            Print(item);
    }
    public void Print(double x)
    {
        Map.Entry item = Find(x);
        Print(item);
    }

    //получение элемента
    private Map.Entry Get(double x)
    {
        for(Map.Entry item: table.entrySet())
        {
            if((double)item.getKey() == x)
                return item;
        }
        return null;
    }

    private Map.Entry Get(int i)
    {
        int index =0;
        for(Map.Entry item: table.entrySet())
        {
            if(index == i)
                return item;
            index++;
        }
        return null;
    }
    //получение индекса элемента
    private int GetIndex(double x)
    {
        int i=0;
        for(Map.Entry item: table.entrySet())
        {
            if((double)item.getKey() == x)
                return i;
            i++;
        }
        return -1;
    }

    //метод поиска пары, ближайшей к x0
    public Map.Entry Find(double x)
    {
        if(table.size()>0)
        {
            double dif =abs((double)Get(0).getKey()-x), x0=(double)Get(0).getKey();
            for(Map.Entry item: table.entrySet())
            {
                if(dif>abs((double)item.getKey()-x))
                {
                    dif=abs((double)item.getKey()-x);
                    x0=(double)item.getKey();
                }
            }

            return Get(x0);
        }
        else
        {
            System.out.println("Таблица пуста");
            return null;
        }

    }


    //рассчет значения функции по заданному x(используя интерполяцию)
    public double InterPolation(double x)
    {

        Map.Entry before =null;
        for(Map.Entry item: table.entrySet())
        {
            if((double)item.getKey()<x)
                before = item;
        }


        if(before!=null)
        {
            Map.Entry after = Get(GetIndex((double)before.getKey())+1);
            if(after !=null)
            {
                double x0 = (double)before.getKey(),y0 =(double)before.getValue();
                double x1 = (double)after.getKey(),y1 =(double)after.getValue();
                return y0 + ((y1-y0)/(x1-x0))*(x-x0);
            }
        }
        return -1;
    }

 @Override
 public boolean equals(Object obj) {
     return (this == obj);
 }

 @Override
 public int hashCode(){
     return table.hashCode();
     }



 @Override
  public String toString() {
     return getClass().getName() + "@" + Integer.toHexString(hashCode());
 }

}
