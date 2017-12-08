package leetcode.array;

/**
 * Gas Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next
 * station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 * Note: The solution is guaranteed to be unique.
 * 
 * 
 * 题解：
 * 
 * 环形路线上有N个加油站，每个加油站有汽油gas[i]，从每个加油站到下一站消耗汽油cost[i]，问从哪个加油站出发能够回到起始点，如果都不能则返回-1（注意，解是唯一的）。
 * 
 * O(N) 的解法是，设置两个变量， sum 判断当前的指针的有效性； total 则判断整个数组是否有
 * 解，有就返回通过 sum 得到的下标，没有则返回 -1。
 * 
 * 从任意一个站出发，我们可以累加油的净余量，如果出现负的，序列结束，开启一个新的，并且证明旧的这个序列的起点不能作为起点，因为会出现负油量，不能继续前进。而且不仅这个负序列的起点不能作为起点，负序列中的任意一点都不能作为起点。
 * 
 * 
 * 
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {  
        int sum = 0;  
        int total = 0;  
        int j = -1;  
        for (int i = 0; i < gas.length; i++) {  
            sum = sum + gas[i] - cost[i];  
            total = total + gas[i] - cost[i];  
            if(sum < 0) {   
                j = i;  
                sum = 0;  
            }  
        }  
        // //所有加油站的油量都不够整个路程的消耗 
        if (total < 0) {
             return -1;  
        }else{
            return j + 1;
        }  
    } 
}