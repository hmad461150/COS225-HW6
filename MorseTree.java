import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MorseTree {
    private TreeNode<String> root;
    
    public MorseTree() {
        this.root = new TreeNode<String>("Root");
    }
    
    public MorseTree(String fileName) throws FileNotFoundException {
        this.root = new TreeNode<String>("Root");
        File file = new File(fileName);
        Scanner sc;
        
        sc = new Scanner(file);
        while (sc.hasNextLine()) {
            TreeNode<String> nd = root;
            String temp = sc.nextLine();
            //System.out.println(temp);
            for (int i = 2; i < temp.length(); i+=2) {
                if (temp.substring(i, i+1).equals("o")) {
                    if (nd.getLeft()==null) {
                        nd.setLeft(new TreeNode<String>(temp));
                    }
                    nd = nd.getLeft();
                } else {
                    if (nd.getRight()==null) {
                        nd.setRight(new TreeNode<String>(temp));
                    }
                    nd = nd.getRight();
                }
            }
            //System.out.println(temp.substring(0,1));
            nd.setElement(temp.substring(0,1));
        }
        
        sc.close();

    }
    
    public String preorder() {
        return root.preorder();
    }

    public String postorder() {
        return root.postorder();
    }

    /* 
    private void recTreeFill(TreeNode<String> nd, String[] x, int index) {
        if (2*index + 1 <x.length) {
            nd.setLeft(new TreeNode<String>(x[2*index+1]));
            recTreeFill(nd.getLeft(), x, 2*index+1);
        } 
        
        if (2*index+2 < x.length) {
            nd.setRight(new TreeNode<String>(x[2*index+2]));
            recTreeFill(nd.getRight(), x, 2*index+2);
        }
    }
    */


    private String letterToMorse(String letter, TreeNode<String> n, String mcode) {
        if (letter.equals(n.getElement())) {
            //System.out.println("Execute");
            return mcode;
        }

        else if ((n.getLeft() == null) && (n.getRight() == null)){ 
            //System.out.println("return");
            return "";
        }
        else if ((n.getLeft() != null) && (n.getRight() == null)){
            //System.out.println("retless");
            return letterToMorse(letter, n.getLeft(), mcode+"o");
        }
        else if ((n.getLeft() == null) && (n.getRight() != null)) {
            //System.out.println("retless");
            return letterToMorse(letter, n.getRight(), mcode+"-");
        }
        else {
            //System.out.println("retless");
            return 
                letterToMorse(letter, n.getRight(), mcode+"-")
                + letterToMorse(letter, n.getLeft(), mcode+"o");
            
        }
    }
    

    public String getMorse(String x) {
        String morse = "";
        x=x.toLowerCase();
        System.out.println(x);
        for (int i = 0; i < x.length(); i++) {
            if (!x.substring(i, i+1).equals(" ")) {
                morse += letterToMorse(x.substring(i, i+1), root, "")+"|";
            }
        }
        return morse;
    }

    public String getEnglish(String x) {
        String eng = "";
        while(x.length() > 0) {
            int stp = x.indexOf("|");
            TreeNode<String> nd = root;
            for (int i = 0; i < stp; i++) {
                if (x.substring(i, i+1).equals("o"))
                    nd = nd.getLeft(); 
                else 
                    nd = nd.getRight();
            }
            eng += nd.getElement();
            x = x.substring(stp + 1);
        }
        return eng;
    }
}