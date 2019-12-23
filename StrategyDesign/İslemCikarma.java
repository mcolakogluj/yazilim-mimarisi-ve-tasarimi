package strategydesign;

public class İslemCikarma implements Strateji{

    @Override
    public int islemYap(int taktik1, int taktik2) {
        return taktik1 - taktik2;
    }
    
}
