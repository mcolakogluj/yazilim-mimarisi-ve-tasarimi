package facadedesign;

public class Espresso implements Kahve{
    @Override
    public void kahveYap(){
        System.out.println("Espresso :: kahveYap() metodu ile oluşturuldu.");
    }
}
