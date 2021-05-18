package L400_499;

import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindMaximumXOR {
    // solution 2
    class TrieNode{
        HashMap<Character,TrieNode> children = new HashMap<>();
        public TrieNode(){}
    }
    public int findMximumXOR2(int[] nums){
        // Compute length L of max number in a binary representation
        int maxNum = nums[0];
        for (int num : nums) { maxNum = Math.max(maxNum,num); }
        String s= Integer.toBinaryString(maxNum);
        int L = s.length();
        //zero left-p[adding to ensure L bits for each number
        int n = nums.length, bitmask = 1<<L;
        String []strNums = new String[n];
        for(int i=0;i<n;++i){
            strNums[i] = Integer.toBinaryString(bitmask|nums[i]).substring(1);//?
        }
        TrieNode trie = new TrieNode();
        int maxXor =0;
        for(String num : strNums){
            TrieNode node = trie, xorNode = trie;
            int currXor =0;
            for(Character bit : num.toCharArray()){
                // insert new number in trie
                if(node.children.containsKey(bit)){
                    node = node.children.get(bit);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(bit,newNode);
                    node = newNode;
                }
                //compute max xor of that new number
                //with all previously inserted
                Character toggleBit = bit == '1' ? '0':'1';
                if(xorNode.children.containsKey(toggleBit)){
                    currXor =(currXor<<1)|1;
                    xorNode = xorNode.children.get(toggleBit);
                }else{
                    currXor = currXor<<1;
                    xorNode = xorNode.children.get(bit);
                }
            }
            maxXor = Math.max(maxXor,currXor);
        }
        return maxXor;
    }
    //solution 1
    public int findMaximumXOR(int[] nums) {
       int maxNum = nums[0];
       for(int num: nums) maxNum = Math.max(maxNum,num);
       //length of max number in a binary representation
        String s = Integer.toBinaryString(maxNum);
        int L = s.length();

        int maxXor =0,currXor;
        Set<Integer> prefixes = new HashSet<>();
        for(int i=L-1;i>-1;--i){
            //go to the next bit by the left shift
            maxXor <<=1;
            //set 1 in the smallest bit
            currXor = maxXor|1;
            prefixes.clear();
            //compute all possible prefiexes
            //of length(L-i) in binary representation
            for(int num: nums) prefixes.add(num>>i);
            //Update maxXor, if two of these prefixes could result in currXor.
            //check if p1^p2 == currXor, i.e. p1 == currXor^p2.

            for (int p: prefixes){
                if(prefixes.contains(currXor^p)){
                    maxXor = currXor;
                    break;
                }
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        int[] nums ={3,10,5};
        FindMaximumXOR f = new FindMaximumXOR();
       // int x= f.findMaximumXOR(nums);
        int y = f.findMximumXOR2(nums);
        System.out.println(y);
    }
}
