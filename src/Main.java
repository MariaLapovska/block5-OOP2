import com.epam.functions.Function;
import com.epam.functions.Linear;

/**
 * Created by Maria on 20.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Linear f = new Linear(0, 6);
        f.drawGraph(1, 5, 1);
        f.drawGraph(3, 6, 1);

        Function f1 = f.clone();

        f.drawGraph(7, 10, 1);

        System.out.println(f1.getPoints());
    }
}