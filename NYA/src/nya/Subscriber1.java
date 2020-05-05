package nya;

/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * 05.05.2020
 */
public class Subscriber1 implements IObserver {
    @Override
    public void update(String mesaj) {
        System.out.println("DİKKAT!->" + mesaj);
    }
}
