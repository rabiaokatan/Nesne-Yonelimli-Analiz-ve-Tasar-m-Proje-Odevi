package nya;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * Sicaklikla ilgili tüm islemler burada yapilir.
 * 05.05.2020-instance:S-
 */
public class SicaklikAlgilayici implements ISubject {
    
    private static Subscriber1 sub = new Subscriber1();
    private static SicaklikAlgilayici instance;
    Random random = new Random();
    private int sicaklik;

    private SicaklikAlgilayici(int sicaklik_)
    {
        this.sicaklik=sicaklik_;
    }
    
    public static synchronized SicaklikAlgilayici getInstance(int sicaklik_){
            if(instance==null)
                instance = new SicaklikAlgilayici(sicaklik_);
        return instance;
    }
    
    public int SicaklikDondur()
    {
        sicaklik=random.nextInt(41)-10; 
        return sicaklik;
    }
    
    public int GuncelSıcaklıgıYazdır(ISogutucuyuAc sogutucuAcik,int sicaklik)
    {
        return sogutucuAcik.SogutucuyuAc(this,sicaklik);
    }
    
    public void SicaklikKontrol(int sicaklik)
    {
        if(sicaklik>10)
        {
         sub.update("Sıcaklık 10 derecenin üstünde!");
        }
        else if(sicaklik<-10)
        {
         sub.update("Sıcaklık -10 derecenin altında!");
        }
    }
    //ISubject
     private List<IObserver> subscribers = new ArrayList<>();
     @Override
        public void register(IObserver subscriber) {
            subscribers.add(subscriber);
        }

     @Override
        public void remove(IObserver subscriber) {
            subscribers.remove(subscriber);
        }   
     @Override
        public void notify(String mesaj) {
            for(IObserver subscriber: subscribers) {
                subscriber.update(mesaj);
            }
        }
    //ISubject son
}