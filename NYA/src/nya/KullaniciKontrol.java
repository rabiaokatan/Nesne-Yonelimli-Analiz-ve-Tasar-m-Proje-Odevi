package nya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Rabia OKATAN rabia.okatan@ogr.sakarya.edu.tr
 * Veritabani baglantisi yapilarak kullanici kontrolu saglanir.
 * 05.05.2020
 */
public class KullaniciKontrol {
    private static KullaniciKontrol instance;
    String[] kullaniciAdi_ = new String[3];
    String[] sifre_        = new String[3];
   
    public static synchronized KullaniciKontrol getInstance(){
            if(instance==null)
                instance = new KullaniciKontrol();
        return instance;
    }
    
    public void GirisKontrol()
    {
        Connection conn=baglan();
        int i=0;
        try {
		Statement statement = conn.createStatement();
                String sql= "SELECT *  FROM \"Kullanici\"";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			kullaniciAdi_[i] = rs.getString("KullaniciAdi");
			sifre_[i] = rs.getString("Sifre");
			i++;
		}
	}catch(Exception e) {
		System.out.println(e);
	}
    }
    private static Connection baglan(){

        Connection conn=null;

        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nya",
                    "postgres", "123456");
        } 
        catch (Exception e) {
           e.printStackTrace();
        }
        return conn;
    }
}
