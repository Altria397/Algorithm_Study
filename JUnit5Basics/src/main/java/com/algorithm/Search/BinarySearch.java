package com.algorithm.Search;

public class BinarySearch {
    public int binarySearchBasic(int[] array, int target){
        int i = 0, j = array.length-1; //初始化指针
        //代码中所有比较符号都为'<',与编程习惯有关，默认小的在左边，大的在右边
        while(i <= j) //说明范围内有东西
        {
            int middle = (i + j) >> 2;
            if(target < array[middle]){//在目标左侧
                j = middle - 1;
            }else if(array[middle] < target){//在目标右侧
                i = middle + 1;
            }else{
                return middle; //找到目标值位置
            }
        }
        return -1;
    }

    public int binarySearchAlternative(int[] array, int target){
        int i = 0, j = array.length;        //第一处: 边界值与基础二分查找不同
        /*
        * j指向的一定不是查找目标
        * */
        while(i < j)                        //第二处: 修改while循环范围
        {
            int middle = (i + j) >>> 1;
            if(target < array[middle]){
                j = middle;                 //第三处: 修改在目标左侧时，上界值
            }else if(array[middle] < target){
                i = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    public int binarySearch3(int[] a, int target){
        int i = 0, j = a.length;
        while(1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        /*由于最后的比较在循环外，原本最优的时间复杂度度O(1)，即数组的中间即是目标值，也需要在循环结束后才能比较
        *所以该平衡板二分查找最好和最差时间复杂度都为O(log(n))
        */
        if(a[i] == target ){
            return i;
        }else{
            return -1;
        }
    }

    //返回最靠左的元素位置
    public int binarySearchLeftmost(int[] array, int target){
        int i = 0, j = array.length-1;
        int candidate = -1;
        while(i <= j) //说明范围内有东西
        {
            int middle = (i + j) / 2;
            if(target < array[middle]){//在目标左侧
                j = middle - 1;
            }else if(array[middle] < target){//在目标右侧
                i = middle + 1;
            }else{
                //记录成为候选位置，继续向左找
                candidate = middle;
                j = middle -1;
            }
        }
        return candidate;
    }

    //返回最靠右的元素位置
    public int binarySearchRightmost(int[] array, int target){
        int i = 0, j = array.length-1;
        int candidate = -1;
        while(i <= j) //说明范围内有东西
        {
            int middle = (i + j) >>> 1;
            if(target < array[middle]){//在目标左侧
                j = middle - 1;
            }else if(array[middle] < target){//在目标右侧
                i = middle + 1;
            }else{
                //记录成为候选位置，继续向左找
                candidate = middle;
                i = middle + 1;
            }
        }
        return candidate;
    }


    //返回≥target的最左索引位置，可以用在返回目标应该插入的位置，求排名
    public int binarySearchLeftmost2(int[] array, int target){
        int i = 0, j = array.length - 1;
        while(i <= j) //说明范围内有东西
        {
            int middle = (i + j) / 2;
            if(target <= array[middle]){//在目标左侧
                j = middle - 1;
            }else{//在目标右侧
                i = middle + 1;
            }
        }
        return i;
    }

    //返回≤target的最右索引位置，可以用在返回目标应该插入的位置
    public int binarySearchRightmost2(int[] array, int target){
        int l = 0, r = array.length-1;
        while(l <= r) //说明范围内有东西
        {
            int middle = (l + r) / 2;
            if(target < array[middle]){//在目标左侧
                r = middle - 1;
            }else{//在目标右侧
                l = middle + 1;
            }
        }
        return l - 1;
    }
}
