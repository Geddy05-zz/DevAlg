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
public class Algoritmiek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        klantGegevensBestand klantgegevens = new klantGegevensBestand();
        klantgegevens.vulArray();
        
        for(int i = 0; i <klantgegevens.KlantArray.length -1 ; i++ ){
            System.out.println(klantgegevens.KlantArray[i].Voornaam);
            try{
            Thread.sleep(3000); 
            }catch(Exception e){
                
            }
        }
    }
}
