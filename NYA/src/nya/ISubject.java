package nya;

/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * 05.05.2020
 */
public interface ISubject {
    public void register(IObserver o);
    public void remove(IObserver o);
    public void notify(String mesaj_);
}
