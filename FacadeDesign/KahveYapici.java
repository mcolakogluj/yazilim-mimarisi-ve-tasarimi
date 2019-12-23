package facadedesign;

public class KahveYapici {
    private Kahve latte;
    private Kahve mocha;
    private Kahve espresso;
    
    public KahveYapici(){
        latte = new Latte();
        mocha = new Mocha();
        espresso = new Espresso();
    }
    
    public void latteYap(){
        latte.kahveYap();
    }
    
    public void mochaYap(){
        mocha.kahveYap();
    }
    
    public void espressoYap(){
        espresso.kahveYap();
    }
}
