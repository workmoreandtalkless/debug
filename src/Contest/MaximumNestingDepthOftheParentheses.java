package Contest;

import L1600_1699.MaximumNumberofAchievableTransferRequests;

public class MaximumNestingDepthOftheParentheses {
    public int maxDepth(String s) {
        if(s.equals("")) return 0;
        if(s.length()==1){
            return 0;
        }
        Character c1= s.charAt(0);

        if(!c1.equals('(')){
            int index=1;
            Character next = s.charAt(index);
            while (next.equals('(')){
                index++;
                next = s.charAt(index);
            }
            int res=0;
            String sub1=s.substring(0,index);
            String sub2 = s.substring(index+1,s.length());
            res = Math.max(maxDepth(sub1),maxDepth(sub2));
            return res;
        }else {
            Character c2= s.charAt(s.length()-1);
            String temps = s.substring(1,s.length());
            if(c1.equals('(')&&c2.equals(')')) return 1+maxDepth(temps);
        }



            int count=-1;

            int res=0;

            for(int i=0;i<s.length();i++){
                Character c=s.charAt(i);


                if(c.equals('(')) count+=2;
                if(c.equals(')')) count--;

                if(count==0&&!c.equals('(')&&!c.equals(')')&&!isDigit(c)){
                    String subs1= s.substring(0,i);
                    String subs2= s.substring(i+1,s.length());
                    res= Math.max(maxDepth(subs1),maxDepth(subs2));
                    return res;
                }

            }
            return res;







    }


//     public boolean vsp(String s){
//         if(s.equals("")) return true;
//         int len = s.length();
//         if(len==1){
//             if(s.equals('(')) return false;
//             else if(s.equals(')')) return false;
//             else return true;
//         }
//         else{

    //         }
//     }
    public boolean isDigit(char c){
        int x=(int)c;
        int low = (int)'0';
        int high = (int)'9';
        if(x>=low&&x<=high) return true;
        else return false;
    }

    public static void main(String[] args) {
        MaximumNestingDepthOftheParentheses mndp = new MaximumNestingDepthOftheParentheses();
        String s="1+(2*3)/(2-1)";
        int x=mndp.maxDepth(s);
        System.out.println(x);
    }
}
