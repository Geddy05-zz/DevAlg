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

public class Binarytree {
    BinaryTreeNode root;
    
    public void insertionSort (KlantInformatie inputArray[]){
        for (int i = 1; i < inputArray.length ;i++){
            KlantInformatie key = inputArray[i];
            int j = i-1;
            while(j >= 0 && inputArray[j].KlantID == key.KlantID){
                   inputArray[j+1] = inputArray[j];
                   j--;
                }
                inputArray[j+1] = key;
            }

        }
    
    
    
    public void AddNode (KlantInformatie klantinfo){
        BinaryTreeNode nNode = new BinaryTreeNode(klantinfo);
        
        if(root == null){
            root=nNode;
        }else{
            BinaryTreeNode focusNode = root;
            
            BinaryTreeNode parent;
            
            while(true){
                parent = focusNode;
                if(klantinfo.KlantID < focusNode.klantinfo.KlantID){
                    focusNode = focusNode.leftChild;
                    
                    if(focusNode == null){
                        parent.leftChild = nNode;
                        return;
                    }
                }else{
                    focusNode = focusNode.rightChild;
                    
                    if (focusNode == null){
                        parent.leftChild = nNode;
                        return;
                    }
                }
            }
        }
    }
    
    public void InOrTraverse(BinaryTreeNode focusNode){
        if(focusNode != null){
            InOrTraverse(focusNode.leftChild);
            System.out.println(focusNode);
            InOrTraverse(focusNode.rightChild);
        }
    }
    
}
class BinaryTreeNode{
        KlantInformatie klantinfo;
        
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        BinaryTreeNode(KlantInformatie x){
            klantinfo = x;
        }     
    }