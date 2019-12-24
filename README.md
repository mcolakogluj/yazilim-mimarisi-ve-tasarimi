## Yazılım Mimarisi ve Tasarımı

1160505034 
Mert Çolakoğlu

## Facade Tasarım Deseni

Bu tasarım deseni, sistemin detaylarını saklayarak, istemcinin dışarıdan sisteme ulaşabilmesi için tek bir ön yüz sunar. Sistemdeki alt sınıflara, bu ön yüz sınıfı ile ulaşılır. İstemci yalnızca sistemdeki bu ön yüz sınıfını bilir. Yani kısaca ön yüz sınıfı, sistemin dışarıya açılmış bir kapısı gibidir.

![Image of Class](https://github.com/mcolakogluj/yazilim-mimarisi-ve-tasarimi/blob/master/FacadeDesign.png)

Ön Yüz Tasarım Desenine örnek olarak kahve örneği verilmiştir. Main fonksiyonumuz başlangıçta kahve yapmak için gerekli olan kahveYapici fonksiyonunu çalıştıracak ve bu fonksiyon altında, sırasıyla Latte, Mocha ve Espresso yapan 3 adet fonksiyon tetiklenecektir.

```java
public class FacadeDesign {

    public static void main(String[] args) {
        KahveYapici kahveyapici = new KahveYapici();
        
        kahveyapici.latteYap();
        kahveyapici.mochaYap();
        kahveyapici.espressoYap();
        
    }
    
}
```
Kahveleri yapan sınıflar sırasıyla Latte, Mocha ve Espresso sınıflarıdır. 3 sınıfta Kahve arayüzünden türetilir.

Kahve Arayüzü:
```java
public interface Kahve {
    void kahveYap();
}
```

Latte Sınıfı:
```java
public class Latte implements Kahve{
    @Override
    public void kahveYap(){
        System.out.println("Latte :: kahveYap() metodu ile oluşturuldu.");
    }
}
```

Mocha Sınıfı: 
```java
public class Mocha implements Kahve{
    @Override
    public void kahveYap(){
        System.out.println("Mocha :: kahveYap() metodu ile oluşturuldu.");
    }
}
```
Espresso Sınıfı:
```java
public class Espresso implements Kahve{
    @Override
    public void kahveYap(){
        System.out.println("Espresso :: kahveYap() metodu ile oluşturuldu.");
    }
}
```

Bu tasarım deseninde Ön Yüz görevi gören KahveYapici sınıfı, private ile oluşturulmuş 3 adet değişkene sahiptir. Değişkenlerin tipi Kahve arayüzüdür.
```java
private Kahve latte;
private Kahve mocha;
private Kahve espresso;
```

Sınıfın kurucu metodu KahveYapici(), nesneleri tanımlar ve bu nesneler üzerinde 3 farklı kahveyi de yapan fonksiyonlara ulaşılır.
```java
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
```

## Strategy Tasarım Deseni

Bir işlem için farklı yöntemlerin uygulanabilir olduğu durumlarda, bu yöntemi kullanacak olan nesne, hangi yöntemin uygulanacağını seçer. Çünkü bu içerik nesnesi, yöntemleri belirleyen üst sınıfı içerir. Farklı yöntem veya strateji alt sınıfları da, bu üst sınıftan türerler. Bu tasarım deseniyle, yöntemin nasıl uygulanması gerektiği ile ilgili detaylar, bu yöntemi kullanacak nesneden ayrılmış olur. Ayrıca bu tasarım deseninin kullanılmasıyla, kod uzun "if/else" veya "switch" ifadelerinden ayıklanır.
