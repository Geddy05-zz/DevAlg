/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek;

/**
 *
 * @author geddyS
 */
public class klantGegevensBestand {
    
    private KlantInformatie KlantArray[];
    
    public void vulArray()
    {
        KlantArray[0] = new KlantInformatie(00001,"Bruin","De","Laura",22,"Vrouw","De lier","laura@laura.nl");
        KlantArray[1] = new KlantInformatie(00002,"Schellevis","Geddy",24,"Man","Maasluis","geddy@geddy.nl");
        KlantArray[2] = new KlantInformatie(00003,"Vink","Manasse",23,"Man","Maasluis","vink@vink.nl");
        KlantArray[3] = new KlantInformatie(00004,"Jong","de","Jeff",25,"Man","Maasdijk","jeff@jeff.nl");
        KlantArray[4] = new KlantInformatie(00005,"Edelman","Ben",23,"Man","Maasdijk","ben@ben.nl");
    }
            
    
}
