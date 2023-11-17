package otoparkkayit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Liste {
    Scanner scanner =new Scanner(System.in);
    
    OtoNode head=null;
    OtoNode tail=null;
    OtoNode temp=head;
    OtoNode temp2=head;
    
    
    String plaka;
    String giris;
    String cikis;
    long dakika;
    long ucret;
    long toplamUcret;
    
    void ekle(){
        System.out.println("Plaka:"); plaka=scanner.nextLine();
        System.out.println("Giris (ss:dd):"); giris=scanner.nextLine();
        
        OtoNode arac = new OtoNode(plaka,giris);
        
        if(head==null){
            head=arac;
            tail=arac;
            head.next=tail;
            tail.prev=head;
            head.prev=tail;
            tail.next=head;
            System.out.println("Arac otoparka girdi");
        }
        else{
            arac.next=head;
            head.prev=arac;
            head=arac;
            
            head.prev=tail;
            tail.next=head;          
        }
        
    }
    
    void sil() throws ParseException{
        if(head==null){
            System.out.println("Otopark bos!!!");
        }
        else{
            System.out.println("Plaka:"); plaka=scanner.nextLine();
            System.out.println("Cikis(ss:dd)"); cikis=scanner.nextLine();
            
            if(head==tail && head.plaka.equals(plaka)){
                ucretHesapla(head,cikis);
                head=null;
                tail=null;
                System.out.println("Arac cikisi yapildi.");
            }
            
            else if(head!=tail && head.plaka.equals(plaka)){
                ucretHesapla(head,cikis);
                head=head.next;
                head.prev=tail;
                tail.next=head;
                System.out.println("Arac cikisi yapildi.");
            }
            
            else{
                temp=head;
                while(temp!=tail){
                    if(temp.plaka.equals(plaka)){
                        ucretHesapla(temp,cikis);
                        temp2.next=temp.next;
                        temp.next.prev=temp2;
                        System.out.println("Arac cikisi yapildi.");
                    }
                    temp2=temp;
                    temp=temp.next;
                }
                if(temp.plaka.equals(plaka)){
                    ucretHesapla(temp,cikis);
                    tail=temp2;
                    tail.next=head;
                    head.prev=tail;
                    System.out.println("Arac cikisi yapildi.");
                }
            }
        }
    }
    
    void ucretHesapla(OtoNode temp3,String cikis2) throws ParseException{
        giris=temp3.giris;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        Date d1,d2;
        
        d1=sdf.parse(giris);
        d2=sdf.parse(cikis);
        
        dakika=d2.getTime()-d1.getTime();
        dakika=dakika/60000;
        ucret=dakika/4;
        System.out.println("Sure:"+dakika+"dk");
        System.out.println("Ucret:"+ucret+"TL");
        toplamUcret+=ucret;
        
    }
    
    void yazdir(){
        if(head==null){
            System.out.println("Otoparkta arac yok!!");
        }
        else{
            System.out.println("Plaka\t\tGiris Saati");
            temp=head;
            while(temp!=tail){
                System.out.println(temp.plaka+"\t\t"+temp.giris);
                temp=temp.next;
            }
            System.out.println(temp.plaka+"\t\t"+temp.giris+"\n");
        }
    }
}
