package nya;
import java.util.Scanner;
import java.sql.*;
/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * Program test edilir.
 * 05.05.2020
 */
public class Uygulama {
private static final Scanner girilenVeri = new Scanner(System.in);
private static ISogutucuyuAc sogutucuAcik= new Eyleyici();

private static String kullaniciAdi ="";
private static String sifre        ="";
private static int guncelSicaklik  = 0;
private static int kullaniciSecimi = 0;
private static int donusDegeri     = 0;
private static int x=0;

    public static void main(String[] args) {
        
       if(Giris()==1)
       {
          while (kullaniciSecimi != 4) 
          {
            Menu();
                if(kullaniciSecimi==1)
                {
                   guncelSicaklik=SicaklikAlgilayici.getInstance(guncelSicaklik).SicaklikDondur();
                   SicaklikAlgilayici.getInstance(guncelSicaklik).SicaklikKontrol(guncelSicaklik);
                   System.out.println("Sıcaklık:"+ guncelSicaklik);   
                }
                else if(kullaniciSecimi==2)
                {
                   guncelSicaklik=SicaklikAlgilayici.getInstance(guncelSicaklik).GuncelSıcaklıgıYazdır(sogutucuAcik, guncelSicaklik);
                   SicaklikAlgilayici.getInstance(guncelSicaklik).SicaklikKontrol(guncelSicaklik);
                   System.out.println("Sıcaklık:"+guncelSicaklik);
                }
                else if(kullaniciSecimi==3)
                {
                    Eyleyici.getInstance().SogutucuyuKapat();
                }
                else
                {
                    System.out.println("Çıkış Yapıldı...");
                }
           }
        } 
        else if(Giris()==0)
        {
            System.out.println("Kullanıcı girişi başarısız...\n");
        }
    }
    
    public static int Giris()
    {
        KullaniciKontrol.getInstance().GirisKontrol();
        
        System.out.print("Kullanıcı Adınız: ");
        kullaniciAdi=girilenVeri.nextLine();
        
        System.out.print("Şifre: ");
        sifre=girilenVeri.nextLine();
       
            if(KullaniciKontrol.getInstance().kullaniciAdi_[0].equals(kullaniciAdi) &&KullaniciKontrol.getInstance().sifre_[0].equals(sifre))
            {
                System.out.println("Giriş başarılı.\n");
                donusDegeri=1;
            }
            else
            {
                System.out.println("Kullanıcı adı ya da şifre hatalı.\n");
                x++;
                if(x==1)
                {
                    if(Giris()==1)
                    {
                        donusDegeri=1;
                        return 1;
                    }
                }
             }
        return donusDegeri;
    }
            
    public static void Menu()
    {
        System.out.println("1 - Sıcaklık Görüntüle\n2 - Soğutucuyu Aç\n3 - Soğutucuyu Kapat\n4 - Çıkış");
        System.out.print("Seçiminiz :");
        kullaniciSecimi = girilenVeri.nextInt();

        while(kullaniciSecimi < 1 || kullaniciSecimi > 4) {
            System.out.println("Lütfen Geçerli Değerler Giriniz!\n1 - Sıcaklık Görüntüle\n2 - Soğutucuyu Aç\n3 - Soğutucuyu Kapat\4 - Çıkış");
            System.out.print("Seçiminiz :");
            kullaniciSecimi = girilenVeri.nextInt();
        }
    } 
}
