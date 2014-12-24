/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmiek;

import static algoritmiek.Algoritmiek.klantgegevens;

/**
 *
 * @author geddyS
 */
public class MergeSort {
    
    private KlantInformatie[] Array;
    private KlantInformatie[] tempArray;
    private int lenght;
    
    public void sort(KlantInformatie inputArray[]){
        this.Array = inputArray;
        this.lenght = inputArray.length;
        this.tempArray = new KlantInformatie[lenght];
        MergeSort(0,lenght-1);
    }
    
    private void MergeSort(int low, int higher){
        
        if(low < higher){
            int middle = low + (higher-low)/2;
            MergeSort(low,middle);
            MergeSort(middle+1,higher);
            Merge(low,middle,higher);
        }
    }
    private void Merge(int low,int middle,int higher){
        for (int i = low; i <=higher; i++){
            tempArray[i]=Array[i];
        }
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j<= higher){
            if(tempArray[i].Leeftijd <= tempArray[j].Leeftijd){
                Array[k] = tempArray[i];
                i++;
            }else{
                Array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i<=middle){
            Array[k] = tempArray[i];
            k++;
            i++;
        }
    }
    
    public int linearSearch(String Achternaam)
    {
        int index =0;
        while(index< klantgegevens.KlantArray.length)
        {
            if (klantgegevens.KlantArray[index].Achternaam == Achternaam){
                return index;
            }else{
                index++;
            }
        }
        return -1;
    }
    
    public void insertionSort (KlantInformatie inputArray[]){
        for (int i = 1; i < inputArray.length ;i++){
            KlantInformatie key = inputArray[i];
            int j = i-1;
            while(j >= 0 && inputArray[j].Achternaam.compareToIgnoreCase(key.Achternaam) > 0){
                   inputArray[j+1] = inputArray[j];
                   j--;
                }
                inputArray[j+1] = key;
            }

        }
    
}
