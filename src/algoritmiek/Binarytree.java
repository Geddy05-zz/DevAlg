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

public class Binarytree {
    BinaryTreeNode root;
    
    public void start(){

        
        insertionSort(klantgegevens.KlantArray);
        
        for (KlantInformatie klantinfo : klantgegevens.KlantArray) {
            AddNode(klantinfo);
        }
        System.out.println("***********************  Binarytree before Delete 1 node ******************************");
        InOrTraverse(root);
        remover(26);
        System.out.println("***********************  Binarytree After Delete 1 node ******************************");
        InOrTraverse(root);
    }
    
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
                        parent.rightChild = nNode;
                        return;
                    }
                }
            }
        }
    }
    
        public boolean remover(int key){
        BinaryTreeNode focusNode = root; 
        BinaryTreeNode parent = root;
        boolean isItLeft =true;
        
        while(focusNode.klantinfo.KlantID != key){
            parent = focusNode;
            
            if(key < focusNode.klantinfo.KlantID){
                isItLeft = true;
                focusNode = focusNode.leftChild;
                
            }else{
                isItLeft = false;
                focusNode = focusNode.rightChild;
            }
            if (focusNode == null) return false;
        }
        if(focusNode.leftChild == null && focusNode.rightChild == null){
            if(focusNode == root) root = null;
            else if(isItLeft) parent.leftChild=null;
            else parent.rightChild = null;
            
        }else if(focusNode.rightChild == null){
            if (focusNode == null) root = focusNode.leftChild;
            
            else if (isItLeft) parent.leftChild=focusNode.leftChild;
            else parent.rightChild= focusNode.leftChild;
        }
        else if(focusNode.leftChild == null){
            if (focusNode == null) root = focusNode.rightChild;
            
            else if (isItLeft) parent.leftChild=focusNode.rightChild;
            else parent.rightChild= focusNode.rightChild;
        }
        else{
            BinaryTreeNode replace = getReplace(focusNode);
            
            if(focusNode == root) root = replace;
            
            else if (isItLeft) parent.leftChild = replace;
            
            else {
                parent.rightChild = replace;
                
                replace.leftChild = focusNode.leftChild;
            }
        }
        return true;
    }
    
    public BinaryTreeNode getReplace ( BinaryTreeNode toReplaceNode){
        
        BinaryTreeNode replaceParent = toReplaceNode;
        BinaryTreeNode replace = toReplaceNode;
        
        BinaryTreeNode focusNode = toReplaceNode.rightChild;
        
        while(focusNode != null){
            replaceParent = replace;
            replace = focusNode;
            focusNode = focusNode.leftChild;
            
        }
        if ( replace != toReplaceNode.rightChild){
            replaceParent.leftChild = replace.rightChild;
            replace.rightChild = toReplaceNode.rightChild;
            
        }
        return replace;
            
    }
    
    private void InOrTraverse(BinaryTreeNode focusNode){
        if(focusNode != null){
            InOrTraverse(focusNode.leftChild);
            System.out.print(focusNode.klantinfo.KlantID+" ");
            System.out.print(focusNode.klantinfo.Voornaam+" ");
            System.out.print(focusNode.klantinfo.Achternaam+" ");
            System.out.println(focusNode.klantinfo.Plaats+" ");
            InOrTraverse(focusNode.rightChild);
        }
    }
    
}
class BinaryTreeNode{
        KlantInformatie klantinfo;
        
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        
        //Constructor
        BinaryTreeNode(KlantInformatie x){
            this.klantinfo = x;
        }     
    }