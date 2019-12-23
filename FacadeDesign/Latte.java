package facadedesign;

public class Latte implements Kahve{
    @Override
    public void kahveYap(){
        System.out.println("Latte :: kahveYap() metodu ile oluşturuldu.");
    }
}
