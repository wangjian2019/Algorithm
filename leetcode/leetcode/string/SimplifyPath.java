package leetcode.string;

import java.util.LinkedList;

/**
 * Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c" 
 * 
 * 题解：
 * 这是一道简化路径的题，使用Stack结构来完成，路径简化的依据是：
 * 当遇到“/../"则需要返回上级目录，需检查上级目录是否为空。
 * 当遇到"/./"则表示是本级目录，无需做任何特殊操作。 
 * 当遇到"//"则表示是本级目录，无需做任何操作。
 * 当遇到其他字符则表示是文件夹名，无需简化。
 * 当字符串是空或者遇到”/../”，则需要返回一个"/"。
 * 当遇见"/a//b"，则需要简化为"/a/b"。
 * 
 * 根据这些要求，我需要两个栈来解决问题。
 * 先将字符串依"/"分割出来，然后检查每个分割出来的字符串。
 * 当字符串为空或者为"."，不做任何操作。
 * 当字符串不为".."，则将字符串入栈。
 * 当字符串为"..", 则弹栈（返回上级目录）。
 * 当对所有分割成的字符串都处理完后，检查第一个栈是否为空，如果栈为空，则证明没有可以重建的目录名，返回"/"即可。
 * 当第一个栈不为空时，这时候我们需要还原path。但是不能弹出栈，因为按照要求栈底元素应该为最先还原的目录path。
 * 例如：原始path是 /a/b/c/，栈里的顺序是：a b c，如果依次弹栈还原的话是：/c/b/a（错误！），正确答案为：/a/b/c
 * 所以这里我应用了第二个栈，先将第一个栈元素弹出入栈到第二个栈，然后再利用第二个栈还原回初始path。
 * 
 * LinkedList数据类型很强大，包含了栈和队列的实现。
 * 
 */
public class SimplifyPath{
    public String simplifyPath(String path) {
        if(path.length() == 0){  
            return path;  
        }  
        //将字符串依"/"分割出来
        String[] splits = path.split("/");  
        LinkedList<String> stack = new LinkedList<String>();  
        for (String s : splits) {  
            if(s.length()==0 || s.equals(".")){  
                continue;  
            }else if(s.equals("..")){  
                if(!stack.isEmpty()){  
                    stack.pop();  
                }  
            }else{  
                stack.push(s);  
            }  
        }  
   
        if(stack.isEmpty()){  
            stack.push("");  
        }  
        String ret = "";  
        while(!stack.isEmpty()){  
            ret = ret + "/" + stack.removeLast();  
        }  
         return ret;  
    }
}