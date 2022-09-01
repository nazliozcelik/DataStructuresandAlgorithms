package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    enum SearchType{
        IN_ORDER,
        PRE_ORDER,
        POST_ORDER
    }

    private BinaryNode root;

    public BinarySearchTree(){
        root = null;
    }

    public void insert(int value){
        if (root == null){
            root = new BinaryNode(value);
            return;
        }

        BinaryNode currentNode = root;
        while (true){
            if (currentNode.getValue() > value){
                if (currentNode.getLeft() == null){
                    currentNode.setLeft(new BinaryNode(value));
                    return;
                }
                currentNode = currentNode.getLeft();
            }else {
                if (currentNode.getRight() == null){
                    currentNode.setRight(new BinaryNode(value));
                    return;
                }
                currentNode = currentNode.getRight();
            }
        }
    }

    public BinaryNode lookup(int value){
        if (root == null){
            return null;
        }
        BinaryNode currentNode = root;

        while (currentNode != null){
            if (value < currentNode.getValue()){
                currentNode = currentNode.getLeft();
            } else if (value > currentNode.getValue()) {
                currentNode = currentNode.getRight();
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public void remove(int value){
        if (root == null) return;

        BinaryNode nodeToRemove = root;
        BinaryNode parentNode = null;

        while (nodeToRemove.getValue() != value){ // Searching for the node to remove and it's parent
            parentNode = nodeToRemove;

            if (value < nodeToRemove.getValue()){
                nodeToRemove = nodeToRemove.getLeft();
            } else if (value > nodeToRemove.getValue()) {
                nodeToRemove = nodeToRemove.getRight();
            }
        }

        BinaryNode replacementNode = null;

        if (nodeToRemove.getRight() != null){
            replacementNode = nodeToRemove.getRight();
            if (replacementNode.getLeft() == null){
                replacementNode.setLeft(nodeToRemove.getLeft());
            } else {
                BinaryNode replacementParentNode = nodeToRemove;

                while (replacementNode.getLeft() != null){
                    replacementParentNode = replacementNode;
                    replacementNode = replacementNode.getLeft();
                }

                replacementParentNode.setLeft(null);
                replacementNode.setLeft(nodeToRemove.getLeft());
                replacementNode.setRight(nodeToRemove.getRight());
            }
        } else if (nodeToRemove.getLeft() != null) {
            replacementNode = nodeToRemove.getLeft();
        }

        if (parentNode == null){
            root = replacementNode;
        } else if (parentNode.getLeft() == nodeToRemove) {
            parentNode.setLeft(replacementNode);
        } else {
            parentNode.setRight(replacementNode);
        }
    }

    int count = 0;

    public void printTree(){
        printTree(root);
    }

    public List<Integer> breathFirstSearchIteratively(){
        BinaryNode currentNode = root;
        List<Integer> list = new ArrayList<>();
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(currentNode);

        while (!queue.isEmpty()){
            currentNode = queue.poll();
            list.add(currentNode.getValue());

            if (currentNode.getLeft() != null){
                queue.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null){
                queue.add(currentNode.getRight());
            }
        }
        return list;
    }

    public List<Integer> breathFirstSearchRecursively(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        return breathFirstSearchRecursively(queue, new ArrayList<>());
    }

    public List<Integer> depthFirstSearchInOrder(SearchType searchType){
        return depthFirstSearchInOrder(root, new ArrayList<>(), searchType);
    }

    private List<Integer> breathFirstSearchRecursively(Queue<BinaryNode> queue, List<Integer> list){
        if (queue.isEmpty()){
            return list;
        }

        BinaryNode currentNode = queue.poll();
        list.add(currentNode.getValue());

        if (currentNode.getLeft() != null){
            queue.add(currentNode.getLeft());
        }

        if (currentNode.getRight() != null){
            queue.add(currentNode.getRight());
        }

        return breathFirstSearchRecursively(queue, list);
    }

    private List<Integer> depthFirstSearchInOrder(BinaryNode node, ArrayList<Integer> list, SearchType searchType){
        if (searchType == SearchType.PRE_ORDER){
            list.add(node.getValue());
        }
        if (node.getLeft() != null){
            depthFirstSearchInOrder(node.getLeft(), list, searchType);
        }

        if (searchType == SearchType.IN_ORDER){
            list.add(node.getValue());
        }
        if (node.getRight() != null){
            depthFirstSearchInOrder(node.getRight(), list, searchType);
        }

        if (searchType == SearchType.POST_ORDER){
            list.add(node.getValue());
        }
        return list;
    }

    private void printTree(BinaryNode node){
        System.out.print(node.getValue());
        System.out.println();
        count++;

        if (node.getLeft() != null){
            System.out.print("\t".repeat(Math.max(0,count)) + "Left: ");
            printTree(node.getLeft());
        }
        if (node.getRight() != null){
            System.out.print("\t".repeat(Math.max(0, count)) + "Right: ");
            printTree(node.getRight());
        }

        count--;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        tree.insert(120);
        tree.insert(8);
        tree.insert(44);
        tree.insert(22);
        tree.printTree();
        tree.remove(22);
        tree.remove(3);
        tree.printTree();
        System.out.println("BFS " + tree.breathFirstSearchIteratively());
        System.out.println("DFS - in order " + tree.depthFirstSearchInOrder(SearchType.IN_ORDER));
        System.out.println("DFS - pre order " + tree.depthFirstSearchInOrder(SearchType.PRE_ORDER));
        System.out.println("DFS - post order " + tree.depthFirstSearchInOrder(SearchType.POST_ORDER));
    }
}
