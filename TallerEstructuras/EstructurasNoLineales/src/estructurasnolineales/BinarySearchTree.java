/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructurasnolineales;

/**
 *
 * @author samaniw
 */
//PABLO
public class BinarySearchTree {

    private BinaryNode root;
    private BinaryNode father;
    private boolean position;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int data) {
        root = new BinaryNode(data);
    }

    //Punto 1
    public void InOrden() {
        InOrden(root);
    }

    private void InOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            InOrden(currentRoot.getLeft());
            System.out.print(currentRoot.getData() + " ");
            InOrden(currentRoot.getRight());
        }
    }

    //Punto 2
    public void Postorden() {
        Postorden(root);
    }

    private void Postorden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            Postorden(currentRoot.getLeft());
            Postorden(currentRoot.getRight());
            System.out.print(currentRoot.getData() + " ");
        }
    }

    //Punto 3
    public void PreOrden() {
        PreOrden(root);
    }

    private void PreOrden(BinaryNode currentRoot) {
        if (currentRoot != null) {
            System.out.print(currentRoot.getData() + " ");
            PreOrden(currentRoot.getLeft());
            PreOrden(currentRoot.getRight());
        }
    }

    //Punto 4
    public int CountNodes() {
        return CountNodes(root);
    }

    private int CountNodes(BinaryNode currentRoot) {
        int cont = 0;
        if (currentRoot != null) {
            cont++;
        }
        if (currentRoot.getLeft() != null) {
            cont += CountNodes(currentRoot.getLeft());
        }
        if (currentRoot.getRight() != null) {
            cont += CountNodes(currentRoot.getRight());
        }
        return cont;
    }

    //Punto 5
    public int CountLeafs() {
        return CountLeafs(root);
    }

    private int CountLeafs(BinaryNode currentRoot) {
        int cont = 0;
//        if(currentRoot == null){
//            return 0;
//        }
        if (isLeaf(currentRoot)) {
            cont++;
        }
        if (currentRoot.getLeft() != null) {
            cont += CountLeafs(currentRoot.getLeft());
        }
        if (currentRoot.getRight() != null) {
            cont += CountLeafs(currentRoot.getRight());
        }
        return cont;
    }

    //Devuelve true si el nodo es hoja
    private boolean isLeaf(BinaryNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    public void Add(int data) {
        if (root == null) {
            root = new BinaryNode(data);
        } else //validar si el dato ya existe
        {
            if (Search(data) != null) {
                System.out.println("Dato repetido, no se puede insertar");
            } else {
                Add(data, root);

            }
        }
    }

    private void Add(int data, BinaryNode currentRoot) {
        if (data < currentRoot.getData()) {
            if (currentRoot.getLeft() == null) {
                currentRoot.setLeft(new BinaryNode(data));
            } else {
                Add(data, currentRoot.getLeft());
            }

        } else if (currentRoot.getRight() == null) {
            currentRoot.setRight(new BinaryNode(data));
        } else {
            Add(data, currentRoot.getRight());
        }
    }

    public BinaryNode Search(int data) {
        return Search(data, root);
    }

    private BinaryNode Search(int data, BinaryNode currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        if (data == currentRoot.getData()) {
            return currentRoot;
        }

        father = currentRoot;

        if (data < currentRoot.getData()) {
            position = false;
            return Search(data, currentRoot.getLeft());
        } else {
            position = true;
            return Search(data, currentRoot.getRight());
        }
    }

    //Punto 6
    public void Delete(int data) {
        if (root == null) {
            System.out.print("Árbol vacío");
        } else {
            Delete(data, root);
        }
    }

    private void Delete(int data, BinaryNode currentRoot) {
        //Me sacaba excepcion y valide que el nodo v fuera != null y funcionó
        BinaryNode v = Search(data);
        if (v != null) {
            if (v.isLeaf()) {
                if (position) {
                    father.setRight(null);
                } else {
                    father.setLeft(null);
                }
            } else if (v.hasOneChild()) {
                if (v.isChildPosition()) {
                    father.setRight(v.getRight());
                } else {
                    father.setLeft(v.getLeft());
                }
            } else {
                BinaryNode minimum = getMinor(v.getRight());
                Delete(minimum.getData());
                v.setData(minimum.getData());
            }
        }

    }

    //Punto 7
    int altura;

    public int LastLevel() {
        altura = 0;
        LastLevel(root, 1);
        return altura;
    }

    private void LastLevel(BinaryNode currentRoot, int level) {
        if (currentRoot != null) {
            LastLevel(currentRoot.getLeft(), level + 1);
            if (level > altura) {
                altura = level;
            }
            LastLevel(currentRoot.getRight(), level + 1);
        }
    }

    //Punto 8
    //Me imprime como es pero no me reconoce el resultado correcto en el tester, 
    //tal vez por la forma de imprimir o no se si será por el null en la pos 0
    String[] niveles;

    public void LevelOrder() {
        /* 
         Para mostrar los datos se recomienda usar:
         System.out.print(x.getData()+" ");
         donde x representa un nodo del árbol

         Para generar un salto de linea se recomienda usar:
         System.out.print("\n");
        
         */
        niveles = new String[LastLevel() + 1];
        LevelOrder(root, 1);
        String cadena = "";
        for (int i = 1; i < niveles.length; i++) {
            //System.out.println("En el nivel " + i +" --> " + niveles[i]);
            cadena += niveles[i] + "\n";
        }
        System.out.println(cadena);
    }

    private void LevelOrder(BinaryNode currentRoot, int level) {
        if (currentRoot != null) {
            niveles[level] = currentRoot.getData() + " " + ((niveles[level] != null) ? niveles[level] : "");
            LevelOrder(currentRoot.getRight(), level + 1);
            LevelOrder(currentRoot.getLeft(), level + 1);
        }
    }

    public BinaryNode getMinor(BinaryNode currentRoot) {
        if (currentRoot.getLeft() == null) {
            return currentRoot;
        } else {
            return getMinor(currentRoot.getLeft());
        }
    }
}
