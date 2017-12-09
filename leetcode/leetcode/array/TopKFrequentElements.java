package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Top K Frequent Elements
 * 
 * Given a non-empty array of integers, return the k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * 
 * 
 */
public class TopKFrequentElements {

    /**
     * 1. hash，得到<元素，频次>键值对
     * 2. 因为频次小于n，建散列表，即新建大小为n+1的数组，数组下标为频次，数组内容为有相同频次的键值list，对散列表按下标由大到小遍历，找出k个键值
     */
    public List<Integer> topKFrequent1(int[] nums, int k) {

        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res;
    }

    //时间复杂度应该是：O(n log k)
    //空间复杂度是: O(k)
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0 || k < 1) {
            return ret;
        }

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        //某个数字出现的频率，最多是 nums.length + 1.所以，他们的范围可以被限定在， [1, nums.length + 1]之间
        //定义一个桶，是一个数组bucket，数组下表表示重复的次数，每个数组元素里面放list，list里面表示该桶元素重复次数的数字有哪些
        List<Integer>[] bucket = new List[nums.length + 1];
        for (Integer elem : map.keySet()) {
            int times = map.get(elem);
            if (bucket[times] == null) {
                bucket[times] = new ArrayList<Integer>();
            }
            bucket[times].add(elem);
        }
        //桶已经建好了，从后往前逐个遍历桶里面的list里面的数字，直到k个
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size(); j++) {
                    ret.add(bucket[i].get(j));
                }
                if (ret.size() >= k) {
                    return ret;
                }
            }
        }

        return ret;
    }

}