import java.util.PriorityQueue;
import java.util.Scanner;

class Node {
    char ch;
    int frequency;
    Node left, right;

    Node(char ch, int frequency) {
        this.ch = ch;
        this.frequency = frequency;
        left = right = null;
    }
}

public class HuffmanCoding {

    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // Leaf node represents a character
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    static void buildHuffmanTree(char[] characters, int[] frequencies) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.frequency, b.frequency)
        );

        // Insert all characters into the priority queue
        for (int i = 0; i < characters.length; i++) {
            pq.add(new Node(characters[i], frequencies[i]));
        }

        // Build the Huffman tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node parent = new Node(
                '\0',
                left.frequency + right.frequency
            );

            parent.left = left;
            parent.right = right;

            pq.add(parent);
        }

        Node root = pq.poll();

        System.out.println("\nHuffman Codes:");

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : 0");
        } else {
            printCodes(root, "");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of characters must be positive.");
            sc.close();
            return;
        }

        char[] characters = new char[n];
        int[] frequencies = new int[n];

        System.out.println("Enter each character followed by its frequency:");

        for (int i = 0; i < n; i++) {
            characters[i] = sc.next().charAt(0);
            frequencies[i] = sc.nextInt();

            if (frequencies[i] <= 0) {
                System.out.println("Frequency must be positive.");
                sc.close();
                return;
            }
        }

        buildHuffmanTree(characters, frequencies);
        sc.close();
    }
}