package algoritmiek;

import static algoritmiek.Algoritmiek.klantgegevens;

public class Binarytree {
    // the root node of the tree
    BinaryTreeNode root;
    
    public void start(){
        insertionSort(klantgegevens.KlantArray);

        // foreach customer in the array add a node representing
        // them into the binary tree
        for (KlantInformatie klantinfo : klantgegevens.KlantArray) {
            AddNode(klantinfo);
        }

        // show in onder traversal and deletion of a leaf
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
    
    
    // this functions adds a leaf to the
    // binary tree
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

    // remove a leaf containing a specified key value from
    // the tree

    public void Remove(int leafKey) {
        BinaryTreeNode focus = root;
        BinaryTreeNode parent = root;
        boolean left = true;

        while (focus.klantinfo.KlantID != leafKey) {
            parent = focus;

            if (leafKey < focus.klantinfo.KlantID) {
                left = true;
                focus = focus.leftChild;

            } else {
                left = false;
                focus = focus.rightChild;
            }
            if (focus == null) break;
        }
        if (focus.leftChild == null && focus.rightChild == null) {
            if (focus == root) root = null;
            else {
                BinaryTreeNode replace = getReplace(focus);
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
            BinaryTreeNode replace = getReplace(focus);
            if(focus == root) root = replace;
            else if (left) parent.leftChild = replace;
            else {
                parent.rightChild = replace;
                replace.leftChild = focus.leftChild;
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
/**
 * this class represents a single node in a
 * binary tree
 * */
class BinaryTreeNode{
        KlantInformatie klantinfo;
        
        BinaryTreeNode leftChild;
        BinaryTreeNode rightChild;
        
        //Constructor
        BinaryTreeNode(KlantInformatie x){
            this.klantinfo = x;
        }     
    }