//TODO: 
//inorder
//cheap insert, remove?


public class TreeNode<T> {
    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;
    
    public TreeNode(T newElement){
        this.element = newElement;
    }

    public T getElement(){
        return element;
    }

    public TreeNode<T> getLeft(){
        return left;
    }

    public TreeNode<T> getRight(){
        return right;
    }

    public void setLeft(TreeNode<T> newNode){
        left = newNode;
    }

    public void setRight(TreeNode<T> newNode){
        right = newNode;
    }

    public String preorder(){    //(O(n)
        if (this.left == null && this.right == null){
            return this.getElement().toString();
        }
        else if (this.left == null && this.right != null){
            return this.getElement().toString() + " "
             + this.getRight().preorder();
        }
        else if (this.left != null && this.right == null){
            return this.getElement().toString() + " "
             + this.getLeft().preorder();            
        }
        else{
            return this.getElement().toString() + " "
             + this.getLeft().preorder() + " "
             + this.getRight().preorder();
        }
    }

    public String postorder(){          //O(n)
        if (this.left == null && this.right == null){
            return this.getElement().toString();
        }
        else if (this.left == null && this.right != null){
            return this.getRight().postorder() + " "
            + this.getElement().toString();
        }
        else if (this.left != null && this.right == null){
            return this.getLeft().postorder() + " "
            + this.getElement().toString();            
        }
        else{
            return this.getLeft().postorder() + " "
            + this.getRight().postorder() + " "
            + this.getElement().toString();
        }
    }

    public int size(){      //O(n)
        if (this.left == null && this.right == null){
            return 1;
        }
        else if (this.left == null && this.right != null){
            return 1 + this.getRight().size();
        }
        else if (this.left != null && this.right == null){
            return 1 + this.getLeft().size();
        }
        else{
            return 1 + this.getLeft().size() + this.getRight().size();
        }
    }

    public void insertLeft(TreeNode<T> newNode){  //O(1)
        if (left == null){
            this.setLeft(newNode);
        }
    }

    public void insertRight(TreeNode<T> newNode){  //O(1)
        if (right == null){
            this.setRight(newNode);
        }
    }

    public boolean isIn(T target){   //O(n)
        if (this.getElement().equals(target)){
            return true;
        }
        else if (this.left == null && this.right == null){
            return false;
        }
        else if (this.left != null && this.right == null){
            return false || this.left.isIn(target);
        }
        else if (this.left == null && this.right != null){
            return false || this.right.isIn(target);
        }
        else{
            return false || this.left.isIn(target) || this.right.isIn(target);
        }
    }

    public int height(){   //O(n)
        if (this.left == null && this.right == null){
            return 0;
        }
        else if (this.left != null && this.right == null){
            return 1 + this.left.height();
        }
        else if (this.left == null && this.right != null){
            return 1 + this.right.height();
        }
        else{
            return 1 + Math.max(this.left.height(), this.right.height());
        }
    }

    public void insert(TreeNode<T> newNode){ //O(n log n)
        if (this.left == null && this.right == null){
            this.insertLeft(newNode);
        }    
        else if (this.left == null && this.right != null){
            this.insertLeft(newNode);
        }    
        else if (this.left != null && this.right == null){
            this.insertRight(newNode);
        }        
        else{
            if (this.left.height() > this.right.height()){
                this.right.insert(newNode);
            }
            else{  //this.left.height <= this.right.height()
                this.left.insert(newNode);
            }
        }
    }

    public void setElement(T element) {
        this.element = element;
    }
    
    public String toString(){
        return element.toString();
    }
}
