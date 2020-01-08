package com.czz.androidtest;

/**
 * @author : 周亚楠
 * @date : 2019/9/25 20:59
 * @desc :
 */
public class ArrayTest {


    public static void main(String[] args) {
//        Integer num = arrayOne();
//        Integer num = arrayTwo();
//        String num = arrayThree();
//        String num = arrFour();
//        String num = arrayFive();
//        String num = arraySix();
        String num = arraySeven();
        System.out.println(num);
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
        int tep = 0;
        int count = 0;

        if (arr.length == 1) {
            return arr[0];
        } else {

            for (int i = 0; i < arr.length; i++) {
                if (i == 0) {
                    tep = arr[0];
                    count = 1;
                } else {
                    if (arr[i] != tep) {
                        if (count == 1) {
                            return tep;
                        } else {
                            tep = arr[i];
                            count = 1;
                        }
                    } else {
                        count++;
                    }
                }


            }
            if (count == 1) {
                return tep;
            } else {
                return null;
            }
        }
    }

    //合并两个有序数组
    public static String arrayThree() {
        int[] arr_one = {1, 4, 6, 8};
        int[] arr_two = {2, 5, 6, 9};
        int tep_index = -1;

        int m = arr_one.length;
        int n = arr_two.length;
        int[] arr = new int[m + n];
        for (int i = 0; i < arr.length; i++) {
            if (i == tep_index) {
                tep_index = -1;
                continue;
            }
            if (arr_one[i] < arr_two[i]) {
                arr[i] = arr_one[i];
            } else if (arr_one[i] > arr_two[i]) {
                arr[i] = arr_two[i];
            } else {
                arr[i] = arr_one[i];
                arr[i + i] = arr_one[i];
                tep_index = i + 1;
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

    //希尔排序
    public static String arraySeven() {

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
     * 插入排序：数组分为有序和无序两部分，将无序部分的元素一次插入到有序部分的适当位置，为了给待插入的
     * 元素留出位置，我们需要在插入之前，将插入位置之后的所有元素都向后移动一位。
     * 分为6个步骤
     * 1：将第一个元素视作有序的部分
     * 2：取出 下一个元素，在已经排序好的序列中从后向前扫描
     * 3：如果已排序的元素大于该新元素，继续向前扫描
     * 4：重复步骤3，直到找到已排序的元素小于或等与该新元素
     * 5: 将新元素放在该已排序好的元素之后
     * 6：重复步骤2~5
     *
     * 动画效果图：https://images.morethink.cn/28749729-ca072084-7503-11e7-881c-92aa915ce369.gif
     *
     *
     *
     *
     * @param arr
     * @return
     */






    private static String getArrayString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int g : arr) {
            stringBuilder.append(g).append(" ");
        }
        return stringBuilder.toString();
    }

}
