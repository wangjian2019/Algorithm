package tree;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlType
public class Tree<T> {
   private final List<Tree<T>> children = new ArrayList<Tree<T>>();
   private final T value;
   
   public Tree(T value) {
      this.value = value;
   }
   
   public Collection<Tree<T>> getChildren() {
      return children;
   }

   @XmlTransient
   public List<T> getChildValues() {
      List<T> childValues = new ArrayList<T>(children.size());
      for (Tree<T> childNode : children) {
         childValues.add(childNode.getValue());
      }
      return childValues;
   }
   
   /**
    * @return All node in the tree including root node.
    */
   public List<T> getAllValues(){
      final List<T> childValues = new ArrayList<T>();
      preorderTraversal(new NodeVisitor<T>() {
         
         @Override
         public void visit(Tree<T> node, int level) {
            childValues.add(node.getValue());
         }
      }, 0);
      
      return childValues;
   }
   
   public T getValue() {
      return value;
   }
   
   public Tree<T> addChild(Tree<T> childNode){
      this.children.add(childNode);
      return this;
   }
   public Tree<T> addChild(T childValue){
      Tree<T> childNode = new Tree<T>(childValue);
      return addChild(childNode);
   }
   
   /**
    * make current node as a root, and get all children in X level.
    * @param depth start from 1.
    * @return
    */
   public Collection<Tree<T>> getNLevelSiblings(int depth){
	   if (depth == 1){
		   Collection<Tree<T>> result = new ArrayList<Tree<T>>();
		   result.add(this);
		   return result;
	   }
	   // 2st level nodes.
	   Collection<Tree<T>> nextLevelChildren = getChildren();
	   // for 3+ levels.
	   for (int i=3; i<=depth; i++){
		   if (nextLevelChildren.size() == 0) break;
		   List<Tree<T>> temp = new ArrayList<Tree<T>>();
		   for (Tree<T> node : nextLevelChildren){
			   temp.addAll(node.getChildren());
		   }
		   nextLevelChildren = temp;
	   }
	   return nextLevelChildren;
   }
   public int getDepth(){
	   int depth = 1;
	   while(getNLevelSiblings(depth).size() > 0) depth++;
	   return depth - 1;
   }
   
   public boolean containNode(T value){
      return findNode(value) != null;
   }
   
   public boolean containNode(TreePredicate<T> predicate){
      return findNode(predicate) != null;
   }
   
   public Tree<T> findNode(T value){
	   if (this.value.equals(value)) return this;
	   Collection<Tree<T>> children = this.getChildren();
	   for (Tree<T> node : children){
		   Tree<T> temp = node.findNode(value);
			if (temp == null)
				continue;
			else
				return temp;
	   }
	   return null;
   }
   
   public Tree<T> findNode(TreePredicate<T> predicate){
      if ( predicate.predicate(this)) return this;
      for ( Tree<T> node : children){
         Tree<T> findNode = node.findNode(predicate);
         if ( findNode != null){
            return findNode;
         }
      }
      return null;
   }
   
   public boolean equals(Object obj){
	   if (!(obj instanceof Tree)) return false;
	   Tree<T> other = (Tree<T>)obj;
	   return equals(other);
   }
   public boolean equals(Tree<T> tree){
	   if (tree == null || tree.getValue() == null) return false;
	   if (!this.value.equals(tree.getValue())) return false;
	   if (this.getChildren().size() != tree.getChildren().size()) return false;
	   return (this.getChildren().containsAll(tree.getChildren()));
   }
   public String toString() {
      StringBuilder sb = new StringBuilder(value.toString());
      if (!children.isEmpty()) {
         sb.append(": ").append(children);
      }
      return sb.toString();
   }
   /**
    *              0
    *            /   \
    *          11    12
    *         /   \   /  \
    *        21   22 23  24
    *                     \
    *                     31
    * @param args
    */
   public static void main(String[] args){
	   Tree<String> root = new Tree<String>("0");
	   Tree<String> c11 = new Tree<String>("11");
	   Tree<String> c12 = new Tree<String>("12");
	   Tree<String> c21 = new Tree<String>("21");
	   Tree<String> c22 = new Tree<String>("22");
	   Tree<String> c23 = new Tree<String>("23");
	   Tree<String> c24 = new Tree<String>("24");
	   Tree<String> c31 = new Tree<String>("31");
	   
	   root.getChildren().add(c11);
	   root.getChildren().add(c12);
	   
	   c11.getChildren().add(c21);
	   c11.getChildren().add(c22);
	   
	   c12.getChildren().add(c23);
	   c12.getChildren().add(c24);
	   
	   c24.getChildren().add(c31);
	   System.out.println(root.getDepth());
	   System.out.println(root.getNLevelSiblings(1).size());
	   System.out.println(root.getNLevelSiblings(2).size());
	   System.out.println(root.getNLevelSiblings(3).size());
	   System.out.println(root.getNLevelSiblings(4).size());
	   System.out.println("---------------");
	   NodeVisitor<String> visitor = new NodeVisitor<String>() {
         @Override
         public void visit(Tree<String> node, int level) {
            //System.out.println(StringUtils.repeat("  ", level * 2) + node.getValue());
         }
	   };
	   
	   root.preorderTraversal(visitor, 0);
   }
   
   public <T> void preorderTraversal(NodeVisitor<T> visitor, int level) {
      visitor.visit((Tree<T>)this, level);
      
      for (Tree<T> node : ((Tree<T>)this).getChildren()) {
         node.preorderTraversal(visitor, level + 1);
      }
   }
   
   public <T> void deepFirstTraversal(NodeVisitor<T> visitor, int level) {
      
      for (Tree<T> node : ((Tree<T>)this).getChildren()) {
         node.deepFirstTraversal(visitor, level + 1);
      }
      visitor.visit((Tree<T>)this, level);
   }
   
   public static interface NodeVisitor<T> {
      void visit(Tree<T> node, int level);
   }
   
   public static interface TreePredicate<T>{
      boolean predicate(Tree<T> node);
   }
}
