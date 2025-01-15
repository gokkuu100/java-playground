import java.util.ArrayList;
import java.util.Iterator;

public class Second {

    public static void main(String[] args) {
        // Make a collection
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(15);
        list.add(8);
        list.add(6);
        list.add(11);

        // Get the iterator
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if (i > 10) {
                it.remove();
            }
        }

        // Print the first item
        System.out.println(list);
    }
}




