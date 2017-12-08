package leetcode.string;



/**
 * Valid Number
 * 
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
 * 
 * 
 * 题解：正则表达式
 * ^是界定符，表示匹配字符串的开始；
 * $是界定符，表示匹配字符串的结尾
 * +是零次或多次出现，{1,}简写就是加号（至少有一次）
 * ?是零次或一次出现,{0,1}简写就是?（要么没有要么只有一次）
 * *是零次或多次出现，{0,}简写就是星号（随便有没有也不限次数）
 * [] 中括号表示其内的内容都是符合要求的匹配，[xyz]字符集。匹配包含的任一字符。例如，"[abc]"匹配"plain"中的"a"。例如[+-]?表示这个位置有可能出现+或-或什么都没有
 * [^xyz]反向字符集。匹配未包含的任何字符。例如，"[^abc]"匹配"plain"中"p"，"l"，"i"，"n"。
 * [a-z]字符范围。匹配指定范围内的任何字符。例如，"[a-z]"匹配"a"到"z"范围内的任何小写字母。
 * [^a-z]反向范围字符。匹配不在指定的范围内的任何字符。例如，"[^a-z]"匹配任何不在"a"到"z"范围内的任何字符。
 * \w匹配任何字类字符，包括下划线。与"[A-Za-z0-9_]"等效
 * \W与任何非单词字符匹配。与"[^A-Za-z0-9_]"等效。
 * \s匹配任何空白字符，包括空格、制表符、换页符等。与 [ \f\n\r\t\v] 等效。
 * \S匹配任何非空白字符。与 [^ \f\n\r\t\v] 等效。
 * \d，是[0-9]的简写形式，也就是匹配数字
 * \D，是非数字字符匹配。等效于 [^0-9]。
 * {}表示出现次数，例如4、20、123、226这样的，[0-9]{1,3}或者\d{1,3}。类似的，[0-9]{2}就表示只能匹配2个数字（多一个少一个都不行），[0-9]{2,}表示至少要有2个数字最多不限（注意大括号内的逗号），[0-9]{,2}表示最多有2个数字
 * ()表示匹配表达式，
 * x|y匹配 x 或 y。例如，'z|food' 匹配"z"或"food"。'(z|f)ood' 匹配"zood"或"food"。
 * 
 */
public class ValidNumber{
    //上正则表达式
    public boolean isNumber(String s) {
        if(s.trim().isEmpty()){ 
            return false; 
        } 
        //1.  0个或1个+或-或没有
        //2.  整数，10
        //3.  带小数的整数，21.2
        //4.  浮点数2e10
        String regex = "[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?"; 

        if(s.trim().matches(regex)){ 
            return true; 
        }else{ 
            return false; 
        } 
    }
}