package strategydesign;

public class Baglam {
    private Strateji strateji;
    
    public Baglam(Strateji strateji){
        this.strateji = strateji;
    }
    
    public int StratejiYonet(int taktik1, int taktik2){
        return strateji.islemYap(taktik1, taktik2);
    }
}
