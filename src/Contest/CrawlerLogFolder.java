package Contest;

import java.util.Stack;

public class CrawlerLogFolder {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack();
        for(int i=0;i<logs.length;i++){
            String tmp = logs[i];
            String x = tmp.substring(0,tmp.length()-1);
            if(x.equals("..")){
                if(stack.isEmpty()){
                    continue;
                }else
                    stack.pop();
            }
            else if(x.equals(".")){
                continue;
            }
            else{
                stack.push(x);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        String [] logs = {"d1/","d2/","../","d21/","./"};
        CrawlerLogFolder clf = new CrawlerLogFolder();
        int x =clf.minOperations(logs);
        System.out.print(x);
    }
}