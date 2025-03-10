package com.algorithm.Search;

public class InsertSearch {
    public int insertSearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = -1;
        int index = -1;
        while (low <= high) {
            if (array[high] == array[low] && array[high] != target){
                return index;
            }
            /*
             * 也就是将上述的比例参数1/2改进为自适应的，
             * 根据关键字在整个有序表中所处的位置，
             * 让mid值的变化更靠近关键字key，
             * 这样也就间接地减少了比较次数
             */
            mid = low + ((target - array[low]) / (array[high] - array[low])) * (high - low);

            if (array[mid] == target) {
                index = mid;
                break;
            }else {
                if (array[mid] < target) {
                    low = mid + 1;
                }else {
                    high = mid - 1;
                }
            }
        }
        return index;
    }
}
