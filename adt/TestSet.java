public class Test{
  public static void main(String[] args) {
        //O(1)
        Set<Integer> mySet = new HashSet<>();
    
        //O(1)
        mySet.add(1);
        mySet.add(2);
        mySet.add(30);
   
        //O(1)
        //it only requires calculating the hash code of the element and checking if it exists in the hash table.
        if(myset.contains(30)){
            System.out.println("contains 30");
        }
    
        //convert array to hashset
        String[] foo = {"foo1", "foo2", "foo3"};
        //O(n)
        Set<String> newSet = new HashSet<>(Arrays.asList(foo));
    
  }
}
