import java.io.FileNotFoundException;

public class MorseTester {
    public static void main(String[] args) throws FileNotFoundException {
        //String[] letters = {"1","e","t","i","a","n","m","s","u","r","w","d",
            //"k","g","o","h","v","f","l","p","j","b","x","c","y","z","q"};
    
        MorseTree myTree = new MorseTree("morsecode.txt");
        System.out.println(myTree.preorder());
        System.out.println(myTree.postorder());
        String fox = myTree.getMorse("The quick fox");
        System.out.println(fox);
        String inverse = myTree.getEnglish(fox);
        System.out.println(inverse);
    }
    //-o-o|-o--|--oo|--o-|
}
