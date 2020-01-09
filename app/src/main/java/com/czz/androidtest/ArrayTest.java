package com.czz.androidtest;

import java.util.Random;

/**
 * @author : 周亚楠
 * @date : 2019/9/25 20:59
 * @desc :
 */
public class ArrayTest {


    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
//            模拟随机分布的数组
            arr[i] = new Random().nextInt();
//            模拟倒序分布的数组
//            arr[i] = 100000-i;
//            模拟已经排序好的分组
//            arr[i] = i;
        }

        insertSort1(arr);
        insertSort2(arr);
        shellSort(arr);

    }

    //寻找数组中第二小的元素
    public static Integer arrayOne() {
        int[] arr = {1, 2};
        int firstSmall = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;
        boolean isSecondGet = false;

        if (arr.length < 2) {
            return null;
        } else {
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] < firstSmall) {
                    secondSmall = firstSmall;
                    firstSmall = arr[i];
                } else if (arr[i] < secondSmall && arr[i] != firstSmall) {
                    secondSmall = arr[i];
                    isSecondGet = true;
                }

            }
            if (isSecondGet) {
                return secondSmall;
            } else {
                return null;

            }
        }


    }

    //找到数组中第一个不重复出现的整数
    public static Integer arrayTwo() {
        int[] arr = {1, 1, 1, 8, 8, 2, 2, 0};
        int tem = 0;
        int count = 0;

        if (arr.length == 1) {
            return arr[0];
        } else {

            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    tem = arr[0];
                    count = 1;
                } else {
                    if (arr[i] != tem) {
                        if (count == 1) {
                            return tem;
                        } else {
                            tem = arr[i];
                            count = 1;
                        }
                    } else {
                        count++;
                    }
                }


            }
            if (count == 1) {
                return tem;
            } else {
                return null;
            }
        }
    }

    //合并两个有序数组
    public static String arrayThree() {
        int[] arr_one = {1, 4, 6, 8};
        int[] arr_two = {2, 5, 6, 9};
        int tem_index = -1;

        int m = arr_one.length;
        int n = arr_two.length;
        int[] arr = new int[m + n];
        for (int i = 0; i < arr.length; i++) {
            if (i == tem_index) {
                tem_index = -1;
                continue;
            }
            if (arr_one[i] < arr_two[i]) {
                arr[i] = arr_one[i];
            } else if (arr_one[i] > arr_two[i]) {
                arr[i] = arr_two[i];
            } else {
                arr[i] = arr_one[i];
                arr[i + i] = arr_one[i];
                tem_index = i + 1;
            }
        }

        return getArrayString(arr);

    }


    //冒泡排序
    public static String arrayFour() {
//        冒泡排序算法的原理如下：
//        比较相邻的元素。如果第一个比第二个大，就交换他们两个。
//        对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
//        针对所有的元素重复以上的步骤，除了最后一个。
//        持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = false;
                }
            }
            String str_array = getArrayString(arr);
            System.out.println(str_array);
            if (flag) {
                break;
            }
        }
        return getArrayString(arr);
    }


    //选择排序
    public static String arrayFive() {
//        选择排序算法的原理如下：
//        寻找未排序元素中最小的，放到已排序队列的开始。
//        继续寻找未排序中最小的，放到已排序队列的尾部。
//        重复上一步，直到排序完毕。
//

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                int tem = arr[min];
                arr[min] = arr[i];
                arr[i] = tem;
            }

            String str_array = getArrayString(arr);
            System.out.println(str_array);

        }
        return getArrayString(arr);
    }


    //插入排序1
    public static String arraySix() {
//        选择排序算法的原理如下：
//        将左边看作已排序队列，第一个元素默认有序，因为只有一个。
//        取右侧无序队列第一个，与有序队列比较，在合适位置插入。
//

        int[] arr = {6, 78, 4, 3, 2, 15, 4};

        for (int i = 1; i < arr.length; i++) {

            int j = i;
            int tem = arr[j];
            while (j > 0 && tem > arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }

            if (j != i) {
                arr[j] = tem;
            }


            String str_array = getArrayString(arr);
            System.out.println(str_array);

        }
        return getArrayString(arr);
    }


    //归并排序
    public static String arrayNight() {
            /*
            归并操作的工作原理如下：
                第一步：申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
                第二步：设定两个指针，最初位置分别为两个已经排序序列的起始位置
                第三步：比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
                重复步骤3直到某一指针超出序列尾
                将另一序列剩下的所有元素直接复制到合并序列尾
                如　设有数列{6，202，100，301，38，8，1}
                初始状态：6,202,100,301,38,8,1
                第一次归并后：{6,202},{100,301},{8,38},{1}，比较次数：3；
                第二次归并后：{6,100,202,301}，{1,8,38}，比较次数：4；
                第三次归并后：{1,6,8,38,100,202,301},比较次数：4；
                总的比较次数为：3+4+4=11；
                逆序数为14；
             */
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1, 3, 4, 1123, 1232};
        //希尔排序
        int gap = array.length;
        while (true) {
            gap /= 3;   //增量每次减半
            for (int i = 0; i < gap; i++) {
                for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && array[k] > temp) {
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }
            if (gap == 1)
                break;
        }

        return getArrayString(array);
    }


    /**
     * 插入排序：
     * 类型：是一种稳定的内部排序。
     * 思路：将序列分为有序和无序两部分，将无序部分的元素依次插入到有序部分的适当位置，为了给待插入的
     * 元素留出位置，我们需要在插入之前，将插入位置之后的所有元素都向后移动一位。
     * 步骤：
     * 1：将第一个元素视作有序的部分
     * 2：取出下一个元素，在已经排序好的序列中从后向前扫描
     * 3：如果已排序的元素大于该新元素，继续向前扫描
     * 4：重复步骤3，直到找到已排序的元素小于或等与该新元素
     * 5: 将新元素放在该已排序好的元素之后
     * 6：重复步骤2~5
     *
     * 动画效果图：https://images.morethink.cn/28749729-ca072084-7503-11e7-881c-92aa915ce369.gif
     *
     * 下面有几种实现方式↓↓↓↓↓↓↓
     */

    /**
     * 最坏和平均时间复杂度为n²，数组长度较小时效率较高；数组本身有序的时候时间复杂度为n。
     * 取出已排序的元素序列后边第一个未排序元素（下标记为j），用临时变量保存起来
     * 通过比较待排序元素与arr[j-1]大小，以arr[j]=arr[j-1]的方式，将已排序的其他元素向后移动一位
     * 最后找到合适位置将临时变量保存的未排序元素保存起来
     */
    public static String insertSort1(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {  //执行次数：n
            int tem = arr[i];   //执行次数：n
            int j = i - 1;  //执行次数：n

            //下方tem < arr[j - 1]易出错，容易写成arr[j]< arr[j - 1]
            while (j >= 0 && tem < arr[j]) { //执行次数：最大n 最小1
                arr[j + 1] = arr[j];    //执行次数：最大n 最小1
                j--;    //执行次数：最大n 最小1
            }

            arr[j + 1] = tem;//执行次数：n

        }
        long end = System.currentTimeMillis();
        System.out.println("insertSort1排序用时==" + (end - start));
        //执行次数：最高：n+n+n+n*(n+n+n)+n=12n²  最低：n+n+n+n*(1+1+1)+n=12n

        String string = getArrayString(arr);
//        System.out.println(string);
        return string;
    }

    /**
     * 借鉴冒泡排序，此直接插入方式没insertSort1好，知道即可。
     * 内层for循环是对已排序好的再加一个当前正在找位置的元素组成的序列的逆序遍历,从最后一位开始跟前一个元素比较，若比前一位小，就交换
     */
    public static String insertSort2(int[] array) {
        int[] arr = array.clone();
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {  //执行次数：n
            for (int j = i + 1; j > 0; j--) {   //执行次数：n
                if (arr[j] < arr[j - 1]) {  //执行次数：1
                    int tem = arr[j];   //执行次数：最大1 最小0
                    arr[j] = arr[j - 1];    //执行次数：最大1 最小0
                    arr[j - 1] = tem;   //执行次数：最大1 最小0
                }
            }

            //执行次数：最多：n*(n+1+1+1+1)=n²+4n 最少：n*(n+1)=n²+n


        }
        long end = System.currentTimeMillis();
        System.out.println("insertSort2排序用时==" + (end - start));
//        String string = getArrayString(arr);
//        System.out.println(string);
        return getArrayString(arr);
    }


    //希尔排序

    /**
     * 类型：是一种非稳定的插入排序
     * 原理：先说直接插入排序的两个特性
     * 1:因为直接插入排序平均时间复杂度为n²，所以在数组个数很少的时候比个数很多的时候要快；
     * 2:直接插入排序在数组本身有序的情况下时间复杂度为n
     * 为什么希尔排序比直接插入排序更快呢？因为希尔排序利用这两点做了以下操作：
     * 定义一个合适的递减的增量，按照增量将数组分成几个分组分别进行直接插入排序。一开始增量较大，分成的组数也多，每一组的元素很少，根据插入排序特点一可知：
     * 数组个数很少的时候比个数很多的时候要快，所以会很快。
     * 之后随着增量的递减，分组的数量会越来越少，数组也渐渐变得有序，最后增量为1的时候，对整个数组进行直接插入排序，由插入排序特点二可知：
     * 直接插入排序在数组本身有序的情况下时间复杂度为n，所以也很快。
     */
    public static String shellSort(int[] arr) {
        int[] array = arr.clone();
        long start = System.currentTimeMillis();
        //gap就是间隔，就是用来将每相差gap个下标的元素各个元素提出来单独插入排序。

        int gap = array.length / 2;
        for (; gap >= 1; gap /= 2) { //操作次数 ：log2n

            for (int i = 0; i < gap; i++) {
                //这个循环我让懵逼了半天，一开始没有写这个循环，但排序结果也是正确的，但是从希尔的逻辑上是讲不通的，后来突然想到，不管前边gap值为几
                //最后都会为1，进行一次整体的直接插入排序，所以结果也是正确的，只是速度变慢了，下面注释掉的是我说的这种错误的写法。

                for (int j = i + gap; j < array.length; j += gap) { //操作次数 ：n/gap
                    //这个循环里其实就是一个插入排序
                    int temp = array[j];
                    int k = j - gap;
                    while (k >= 0 && temp < array[k]) { //操作次数 ：最小1 最大n/gap
                        array[k + gap] = array[k];
                        k -= gap;
                    }
                    array[k + gap] = temp;
                }
            }

//            for (int j = gap; j < array.length; j += gap) { //操作次数 ：n/gap
//                //这个循环里其实就是一个插入排序
//                int temp = array[j];
//                int k = j - gap;
//                while (k >= 0 && temp < array[k]) { //操作次数 ：最小1 最大n/gap
//                    array[k + gap] = array[k];
//                    k -= gap;
//                }
//                array[k + gap] = temp;
//            }
        }
        long end = System.currentTimeMillis();
        System.out.println("希尔排序排序用时==" + (end - start));
        String string = getArrayString(array);
//        System.out.println(string);
        return getArrayString(array);
    }


    private static String getArrayString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int g : arr) {
            stringBuilder.append(g).append(" ");
        }
        return stringBuilder.toString();
    }

}
