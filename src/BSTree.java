import java.util.function.Consumer;

public class BSTree {
    private Node root;

//    public void add(int value){
//        if(root == null){
//            root = new Node(value);
//            return;
//        }
//        Node curr = root;
//        while (true){
//            if(value == curr.value){
//                break;
//            }else if(value > curr.value){
//                if(curr.right == null){
//                    curr.right = new Node(value);
//                    break;
//                }
//                curr = curr.right;
//            }else{
//                if(curr.left == null){
//                    curr.left = new Node(value);
//                    break;
//                }
//                curr = curr.left;
//            }
//        }
//    }

    public void add(int value){
        root = addRecursive(root,value);
    }

    private Node addRecursive(Node root, int value){
        if(root == null){
            return new Node(value);
        }
        if(value < root.value){
            root.left = addRecursive(root.left, value);
        }else if(value > root.value) {
            root.right = addRecursive(root.right, value);
        }
        return root;
    }


    public boolean contains(int value){
        return searchRecursive(root,value) != null;
    }

    private Node searchRecursive(Node node, int value){
        if(node == null || node.value == value){
            return node;
        }
        if(value < node.value){
            return searchRecursive(node.left,value);
        }else{
            return searchRecursive(node.right,value);
        }
    }

    public void remove(int value){
        removeRecursive(root,value);
    }

    private Node removeRecursive(Node node, int value){
        if (node == null){
            return null;
        }

        if(node.value == value){
            //Case no children
            if(node.left == null && node.right == null){
                return null;
            }

            //Case one children
            if(node.left == null){
                return node.right;
            }
            if(node.right == null){
                return node.left;
            }
            int small = findSmall(node.right);
            node.value = small;
            node.right = removeRecursive(node.right,small);

        }else if (value < node.value){
            node.left = removeRecursive(node.left,value);
        }else{
            node.right = removeRecursive(node.right,value);
        }
        return node;
    }
    private int findSmall(Node node){
        return  node.left == null ? node.value : findSmall(node.left);
    }
    public void traverse(Consumer<Integer> consumer){
        traverseRecursive(root,consumer);
    }

    private void traverseRecursive(Node node, Consumer<Integer> consumer){
        if(node != null){
            traverseRecursive(node.left,consumer);
            traverseRecursive(node.right,consumer);
            consumer.accept(node.value);
        }
    }
    private class Node{
        private int value;
        private Node left;
        private Node right;
        private Node(int value){
            this.value = value;
        }
    }
}
