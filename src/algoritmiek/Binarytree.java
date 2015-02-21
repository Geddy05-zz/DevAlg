package algoritmiek;

import static algoritmiek.Algoritmiek.klantgegevens;

public class Binarytree {
    // the root node of the tree
    KlantInformatie root;
    
    public void start(){
        insertionSort(klantgegevens.KlantArray);

        // foreach customer in the array add a node representing
        // them into the binary tree
        for (KlantInformatie klantinfo : klantgegevens.KlantArray) {
            newNode(klantinfo);
        }

        // show in onder traversal and deletion of a leaf
        System.out.println("***********************  Binarytree before Delete 1 node ******************************");
        InOrTraverse(root);
        Remove(26);
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
    
    
    // this functions adds a leaf to the
    // binary tree
    public void newNode (KlantInformatie newNode){
        boolean notFinish = true;
        KlantInformatie focusNode = root;
        KlantInformatie parentNode;
            
        while(notFinish){
            parentNode = focusNode;
                
            if(newNode.KlantID < focusNode.KlantID){
                focusNode =  parentNode.leftChild;
                    
                if (focusNode == null){
                    parentNode.leftChild = newNode;
                    notFinish = false;
                }
            }else{
                focusNode =  parentNode.rightChild;
                    
                if(focusNode == null){
                    parentNode.rightChild = newNode;
                    notFinish = false;
                }
            }
        }
    }

    // remove a leaf containing a specified key value from
    // the tree

    public void Remove(int leafKey) {
        KlantInformatie focus = root;
        KlantInformatie parent = root;
        boolean left = true;

        while (focus.KlantID != leafKey) {
            parent = focus;

            if (leafKey < focus.KlantID) {
                left = true;
                focus = focus.leftChild;

            } else {
                left = false;
                focus = focus.rightChild;
            }
            if (focus == null) return;
        }
        if (focus.leftChild == null && focus.rightChild == null) {
            if (focus == root) root = null;
            else {
                KlantInformatie replace = getReplace(focus);
            }
        } else if(focus.rightChild == null){
            if (focus == null) root = focus.leftChild;
            else if (left) parent.leftChild = focus.leftChild;
            else parent.rightChild= focus.leftChild;
        } else if(focus.leftChild == null){
            if (focus == null) root = focus.rightChild;
            else if (left) parent.leftChild = focus.rightChild;
            else parent.rightChild= focus.rightChild;
        } else {
            KlantInformatie replace = getReplace(focus);
            if(focus == root) root = replace;
            else if (left) parent.leftChild = replace;
            else {
                parent.rightChild = replace;
                replace.leftChild = focus.leftChild;
            }
        }
    }
    public boolean remover(int key){
        KlantInformatie focusNode = root; 
        KlantInformatie parent = root;
        boolean isItLeft =true;
        
        while(focusNode.KlantID != key){
            parent = focusNode;
            
            if(key < focusNode.KlantID){
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
            KlantInformatie replace = getReplace(focusNode);
            
            if(focusNode == root) root = replace;
            
            else if (isItLeft) parent.leftChild = replace;
            
            else {
                parent.rightChild = replace;
                
                replace.leftChild = focusNode.leftChild;
            }
        }
        return true;
    }
    
    public KlantInformatie getReplace ( KlantInformatie toReplaceNode){
        
        KlantInformatie replaceParent = toReplaceNode;
        KlantInformatie replace = toReplaceNode;
        
        KlantInformatie focusNode = toReplaceNode.rightChild;
        
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
    
    private void InOrTraverse(KlantInformatie focusNode){
        if(focusNode != null){
            System.out.print(focusNode.KlantID+" ");
            System.out.print(focusNode.Voornaam+" ");
            System.out.print(focusNode.Achternaam+" ");
            System.out.println(focusNode.Plaats+" ");
            if (focusNode.leftChild != null) InOrTraverse(focusNode.leftChild);
            if (focusNode.rightChild != null) InOrTraverse(focusNode.rightChild);
        }
    }
    
}
/**
 * this class represents a single node in a
 * binary tree
 * */
/*
class BinaryTreeNode{
        KlantInformatie klantinfo;
        
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        
        //Constructor
        BinaryTreeNode(KlantInformatie x){
            this.klantinfo = x;
        }     
    }*/