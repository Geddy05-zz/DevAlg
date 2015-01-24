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
        int a = 5;

        // TODO code application logic here
        klantgegevens.vulArray();
        MergeSort mergesort = new MergeSort();
        Binarytree btree = new Binarytree();
        mergesort.sort(klantgegevens.KlantArray);
        // print merge sort on age
        System.out.println("***********************  merge sort on age ******************************");
        for(int i = 0; i < klantgegevens.KlantArray.length; i++ ){
            System.out.print(klantgegevens.KlantArray[i].KlantID+ " ");
            System.out.println(klantgegevens.KlantArray[i].Voornaam);        
        }
        //Print linearsearch on Last name
        System.out.println("***********************  linearsearch ******************************");

        int index = mergesort.linearSearch("Bruin");
        System.out.println(klantgegevens.KlantArray[index].KlantID+" ");

        System.out.print(klantgegevens.KlantArray[index].Voornaam+" ");
        if (klantgegevens.KlantArray[index].Tussenvoegsel == null){
        }else {System.out.print(klantgegevens.KlantArray[index].Tussenvoegsel+" ");}
        System.out.print(klantgegevens.KlantArray[index].Achternaam+ "  ");
        System.out.println(klantgegevens.KlantArray[index].Leeftijd + "  ");
        System.out.println(klantgegevens.KlantArray[index].Geslacht + "  ");
        System.out.println(klantgegevens.KlantArray[index].Plaats + "  ");
        
        mergesort.insertionSort(klantgegevens.KlantArray);
        
        System.out.println("*********************** SORTEER OP ACHTERNAAM ******************************");
        for(int i = 0; i <=klantgegevens.KlantArray.length -1 ; i++ ){
            System.out.println(klantgegevens.KlantArray[i].Achternaam);
        }
        
        btree.start();
        
        System.out.println("************************* QUEUE ******************************");
        new Thread(new UpdateOrders()).start();
    }
    
}
