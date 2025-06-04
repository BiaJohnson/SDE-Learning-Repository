import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class SimpleBinaryTree<K, V> implements BinaryTree<K, V> {
    protected BinaryTreeNode<K, V> root;

    public void put(K key, V value) {
        if (root == null)
            root = new BinaryTreeNode<>(key, value);
        else
            put(key, value, root);
    }

    @SuppressWarnings("unchecked")
    private void put(K key, V value, BinaryTreeNode<K, V> node) {
        if (((Comparable) key).compareTo(node.getKey()) == 0) {
            node.setKey(key);
            node.setValue(value);
        } else if (((Comparable) key).compareTo(node.getKey()) < 0) {
            if (node.getLeft().isPresent())
                put(key, value, node.getLeft().get());
            else
                node.setLeft(new BinaryTreeNode<>(key, value));
        } else {
            if (node.getRight().isPresent())
                put(key, value, node.getRight().get());
            else
                node.setRight(new BinaryTreeNode<>(key, value));
        }
    }

    @SuppressWarnings("unchecked")
    public Optional<V> get(K key) {
        return Optional.ofNullable(root).flatMap(n -> get(key, n));
    }

    @SuppressWarnings("unchecked")
    private Optional<V> get(K key, BinaryTreeNode<K, V> node) {
        if (((Comparable) key).compareTo(node.getKey()) == 0)
            return Optional.of(node.getValue());
        else if (((Comparable) key).compareTo(node.getKey()) < 0)
            return node.getLeft().flatMap(n -> get(key, n));
        else
            return node.getRight().flatMap(n -> get(key, n));
    }

    public Optional<K> minKey() {
        if (root == null) {
            return Optional.empty();
        }
        return Optional.of(findMin(root));
    }

    private K findMin(BinaryTreeNode<K, V> node) {
        // Keep going left until we can't anymore
        while (node.getLeft().isPresent()) {
            node = node.getLeft().get();
        }
        return node.getKey();
    }

    public static void main(String[] args) {
        SimpleBinaryTree<Integer, String> binaryTree = new SimpleBinaryTree<>();
        binaryTree.put(2, "Isabel");
        binaryTree.put(1, "John");
        binaryTree.put(3, "Ruth");
        binaryTree.put(6, "Sarah");
        binaryTree.put(5, "Peter");

        System.out.println(binaryTree.minKey());
    }
}
