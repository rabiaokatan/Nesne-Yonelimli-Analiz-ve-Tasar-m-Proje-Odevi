package nya;
/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * Soutucuyu açma/kapama, sicakliğin dusurulmesi burada yapilir.
 * 05.05.2020
 */
public class Eyleyici implements ISogutucuyuAc {
    
    private static Eyleyici instance;
    private int sonSicaklik;
   
    public static synchronized Eyleyici getInstance(){
            if(instance==null)
                instance = new Eyleyici();
        return instance;
    }
   
    public int SogutucuyuAc(SicaklikAlgilayici algilama,int sicaklik)
    {
        System.out.println("Soğutucu Çalıştırılıyor...");
        sonSicaklik=sicaklik-5;
        return sonSicaklik;
    }
    
    public void SogutucuyuKapat()
    {
        System.out.println("Sogutucu Kapatildi");
    }

}
