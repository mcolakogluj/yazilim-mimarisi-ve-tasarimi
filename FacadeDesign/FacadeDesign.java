package facadedesign;

public class FacadeDesign {

    public static void main(String[] args) {
        KahveYapici kahveyapici = new KahveYapici();
        
        kahveyapici.latteYap();
        kahveyapici.mochaYap();
        kahveyapici.espressoYap();
        
    }
    
}
