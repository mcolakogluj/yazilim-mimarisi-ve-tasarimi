package strategydesign;

public class İslemEkleme implements Strateji{

    @Override
    public int islemYap(int taktik1, int taktik2) {
        return taktik1 + taktik2;
    }
    
}
