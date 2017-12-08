package leetcode.string;

/**
 * Count and Say
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2", then "one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * 
 * 题解：
 * 解释一下就是，输入n，那么我就打出第n行的字符串。
 * 
 * 怎么确定第n行字符串呢？他的这个是有规律的。
 * n = 1时，打印一个1。
 * n = 2时，看n=1那一行，念：1个1，所以打印：11。
 * n = 3时，看n=2那一行，念：2个1，所以打印：21。
 * n = 4时，看n=3那一行，念：一个2一个1，所以打印：1211。
 * 以此类推。(注意这里n是从1开始的）
 * 所以构建当前行的字符串要依据上一行的字符串。“小陷阱就是跑完循环之后记得把最后一个字符也加上，因为之前只是计数而已。”
 * 
 * 
 */
public class CountandSay       {
    public String countAndSay(int n) {
        if(n <= 0){
            return "";
        }
        String curRes = "1";
        int start = 1;//从1开始算
        while(start < n){
            StringBuilder res = new StringBuilder();
            int count = 1;
                for(int j=1;j<curRes.length();j++){
                    if(curRes.charAt(j)==curRes.charAt(j-1)){
                        //用来计数有几个1
                        count++;
                    }else{
                        res.append(count);
                        res.append(curRes.charAt(j-1));
                        count = 1;
                    }
                }
            res.append(count);
            res.append(curRes.charAt(curRes.length()-1));
            curRes = res.toString();
            start++;
        }
        return curRes;
    }
}