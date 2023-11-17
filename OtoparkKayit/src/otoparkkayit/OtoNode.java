
package otoparkkayit;


public class OtoNode {
    String plaka;
    String giris;
    long dakika;
    long ucret;
    
    OtoNode next;
    OtoNode prev;
    
    public OtoNode(String plaka,String giris){
        this.plaka=plaka;
        this.giris=giris;
        this.next=null;
        this.prev=null;
    }
}
