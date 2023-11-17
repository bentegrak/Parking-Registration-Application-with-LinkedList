
package otoparkkayit;

import java.text.ParseException;
import java.util.Scanner;


public class Uygulama {
    
    
    public static void main(String[] args) throws ParseException {
        
        Scanner scanner = new Scanner(System.in);
        
        Liste liste=new Liste();
        int secim=-1;
        while(secim!=0){
            System.out.println("1- Otoparka Arac Girisi");
            System.out.println("2- Otoparktan Arac Cikisi");
            System.out.println("3- Otoparktaki Araclari Listele");
            System.out.println("4- Toplam Gelir(TL)");
            System.out.println("0- Cikis");
            System.out.println("Seciminiz:"); secim=scanner.nextInt();
            
            switch(secim){
                case 1:liste.ekle();
                    break;
                case 2:liste.sil();
                    break;
                case 3:liste.yazdir();
                    break;
                case 4:System.out.println("Toplam Ucret:"+liste.toplamUcret);
                    break; 
                case 0:System.out.println("Cikis Yaptiniz!!");
                    break;   
                default:System.out.println("Hatali Secim");
            }
        }
    }
    
}
