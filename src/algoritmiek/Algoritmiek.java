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
    public static klantGegevensBestand klantgegevens = new klantGegevensBestand();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        klantgegevens.vulArray();
        MergeSort mergesort = new MergeSort();
        mergesort.sort(klantgegevens.KlantArray);
        // print merge sort on age
        for(int i = 0; i < klantgegevens.KlantArray.length; i++ ){
            System.out.println(klantgegevens.KlantArray[i].Voornaam);        
        }
        //Print linearsearch on Last name
        int index = mergesort.linearSearch("Bruin");
        System.out.print(klantgegevens.KlantArray[index].Voornaam+" ");
        if (klantgegevens.KlantArray[index].Tussenvoegsel == null){
        }else {System.out.print(klantgegevens.KlantArray[index].Tussenvoegsel+" ");}
        System.out.println(klantgegevens.KlantArray[index].Achternaam);
        System.out.println(klantgegevens.KlantArray[index].Leeftijd);
        System.out.println(klantgegevens.KlantArray[index].Geslacht);
        System.out.println(klantgegevens.KlantArray[index].Plaats);
        
        mergesort.insertionSort(klantgegevens.KlantArray);
        for(int i = 0; i <=klantgegevens.KlantArray.length -1 ; i++ ){
            System.out.println(klantgegevens.KlantArray[i].Achternaam);
        }

        new Thread(new UpdateOrders()).start();
    }
    
}
