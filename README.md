## Yazılım Mimarisi ve Tasarımı Ödevi

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

![Image of Class](https://github.com/mcolakogluj/yazilim-mimarisi-ve-tasarimi/blob/master/StrategyDesign.png)

Strateji Tasatım Desenine verilen örnek işlem örneğidir. 
İnt tipinden iki sayı işleme tabi tutularak( islemYap() ) strateji yönetilir.

Strateji arayüzü içinde, islemYap() fonksiyonu altsınıflara override edilerek işlemin gerçekleşmesini sağlayacaktır.

```java
public interface Strateji {
    public int islemYap(int taktik1, int taktik2); 
}
```
Strateji arayüzündeni İslemEkleme, İslemCikarma, İslemCarpma adında 3 sınıf türetilir.

```java
public class İslemEkleme implements Strateji{

    @Override
    public int islemYap(int taktik1, int taktik2) {
        return taktik1 + taktik2;
    }
    
}

public class İslemCikarma implements Strateji{

    @Override
    public int islemYap(int taktik1, int taktik2) {
        return taktik1 - taktik2;
    }
    
}

public class İslemCarpma implements Strateji{

    @Override
    public int islemYap(int taktik1, int taktik2) {
        return taktik1 * taktik2;
    }
    
}

```
Baglam sınıfı Stratejiyi yönetecek iki adet metoda sahip olacak, StratejiYonet(); metodu işlemi yapılacak olan değerleri işlem yapacak sınıfların fonksiyonlarına verecekken , Baglam sınıfının nesnesi 'baglam' StratejiYonet'in almış olduğu değerleri ve metodu döndürecektir.

```java
public class Baglam {
    private Strateji strateji;
    
    public Baglam(Strateji strateji){
        this.strateji = strateji;
    }
    
    public int StratejiYonet(int taktik1, int taktik2){
        return strateji.islemYap(taktik1, taktik2);
    }
}
```

```java
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
```
