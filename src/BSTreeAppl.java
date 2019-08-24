public class BSTreeAppl {
    public static void main(String[] args) {
        BSTree tree = new BSTree();
        tree.add(15);
        tree.add(26);
        tree.add(17);
        tree.add(4);
        tree.add(16);
        tree.traverse(System.out::println);
        System.out.println(tree.contains(118));
        tree.remove(15);
        tree.traverse(System.out::println);
    }
}
