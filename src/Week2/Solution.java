package Week2;

class Solution {
    public String frequencySort(String s) {
        int [] chararr = new int[60];
        for(char c: s.toCharArray()){
            int temp= c-'A';
            chararr[temp]++;
        }
        StringBuilder str = new StringBuilder();
        int max=0;
        int maxindex=0;
        while (!isZero(chararr)){
            for (int i = 0; i < chararr.length ; i++) {
                if(chararr[i]>=max){
                    max = chararr[i];
                    maxindex = i;
                }
            }
            while (max>0){
                str.append((char)( maxindex+'A'));
                chararr[maxindex]--;
                max--;
            }
        }

        return str.toString();

    }
    public boolean isZero(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution ss= new Solution();
       String a= ss.frequencySort("tree");
       String b = ss.frequencySort("cccaaa");
       String c = ss.frequencySort("Aabb");

       System.out.println(a);
       System.out.println(b);
       System.out.println(c);
    }
}
