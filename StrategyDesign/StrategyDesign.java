package strategydesign;

public class StrategyDesign {

    public static void main(String[] args) {
        Baglam baglam = new Baglam(new İslemEkleme());
        System.out.println("100 + 50 = " + baglam.StratejiYonet(100, 50));
        
        baglam = new Baglam(new İslemCikarma());
        System.out.println("100 - 50 = " + baglam.StratejiYonet(100, 50));
        
        baglam = new Baglam(new İslemCarpma());
        System.out.println("100 * 50 = " + baglam.StratejiYonet(100, 50));
    }
    
}
