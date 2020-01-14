package com.czz.androidtest;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author : 周亚楠
 * @date : 2019/9/25 20:59
 * @desc :
 */
public class ArrayTest {


    public static void main(String[] args) {
        int length = 100;
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
//            模拟随机分布的数组
            arr[i] = Math.abs(new Random().nextInt(length));
//            System.out.println(arr[i]);
//            模拟倒序分布的数组
//            arr[i] = length-i;
//            模拟已经排序好的分组
//            arr[i] = i;
        }

//        insertSort1(arr);
//        insertSort2(arr);
//        shellSort(arr);
//        selectionSort(arr);
//        heapSort(arr);
//        bubbleSort(arr);
//        quickSort(arr);
//        sortByStack(arr);
//        mergeSort(arr);
        baseSort(arr);
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


    /**
     * 选择排序：
     * 非稳定排序：在一趟选择，如果一个元素比当前元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
     * 原理：
     * 1：分为已排序队列和未排序队列，先寻找未排序队列中最小的，放在已排序队列的开始。
     * 2：在未排序队列中找最小的，放在已排序队列的队尾
     * 3: 重复上一步，直到排序完毕
     */
    public static void selectionSort(int[] array) {

        int[] arr = array.clone();
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }

            }
            if (i != min) {
                int tem = arr[i];
                arr[i] = arr[min];
                arr[min] = tem;
            }

        }
//        String string = getArrayString(arr);
//        System.out.println("selectionSort排序结果：" + string);
//        return string;
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
    public static void insertSort1(int[] array) {
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

//        String string = getArrayString(arr);
//        System.out.println(string);
    }

    /**
     * 借鉴冒泡排序，此直接插入方式没insertSort1好，知道即可。
     * 内层for循环是对已排序好的再加一个当前正在找位置的元素组成的序列的逆序遍历,从最后一位开始跟前一个元素比较，若比前一位小，就交换
     */
    public static void insertSort2(int[] array) {
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
    public static void shellSort(int[] arr) {
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
//        String string = getArrayString(array);
//        System.out.println(string);

    }


    /**
     * 堆排序：
     * 类型：非稳定排序。同时由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序。
     * 思路：将序列认为两部分，后半部分为已排序（从0个开始）
     * 1：构建大顶堆或小顶堆
     * 2：将堆顶元素与未排序序列最后一位交换，已排序数量+1
     * 3：剩下未排序重复1~2
     */
    public static void heapSort(int[] array) {
        int[] a = array.clone();
        long start = System.currentTimeMillis();
        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);

            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
        long end = System.currentTimeMillis();
        System.out.println("heapSort排序用时==" + (end - start));
//        String string = getArrayString(a);
//        System.out.println("堆排序结果==" + string);
    }

    /***
     *
     *  将数组堆化
     *  i = 最后一个非叶子节点。
     *  从最后一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }


    //  =============================  快速排序 系列开始================================

    /**
     * 快速排序
     * 类型：非稳定排序
     * 思路：挖坑填数与分治
     * 步骤：
     * 1：选择一个基数，将其提到临时变量，一般以序列的第一个值为基数
     * 2：从序列尾部开始向前找比基数小的值，一直到找到为止，记为位置i,将该值放到基数占位的地方
     * 3：从序列头部开始向后找比基数大的值，一直到找到为止，记为位置j，将该值放到上一步的取出的位置
     * 4：重复2~3直到两个位置i=j，将基数赋值到此位置，此时序列被所选基数分成左边小于，右边大于的形态
     * 5：将序列出基数外的两边分别再在使用1~4步进行排序
     *
     * @param array
     */

    public static void quickSort(int[] array) {
        int[] arr = array.clone();
        quick(0, arr.length - 1, arr);
    }

    public static void quick(int low, int high, int[] array) {


        //注意点1：退出点 ，无此处代码将会出现StackOverflowError，因为一直递归调用
        if (low >= high) {
            return;
        }


        int pivot = array[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && array[j] >= pivot) {
                j--;
            }
            //注意点二：次数我一开始写错了成 array[low] = array[j];
            array[i] = array[j];
            while (i < j && array[i] <= pivot) {
                i++;
            }
            array[j] = array[i];
        }

        array[i] = pivot;
        quick(low, i - 1, array);
        quick(i + 1, high, array);
        String string = getArrayString(array);
        System.out.println("简单快排结果==" + string);

    }


    /**
     * 数组较小时效率低于直接插入，所以可以使用栈来待体递归或者针对数组较小的部分使用插入排序（n²）
     * 通过栈替代递归实现快排
     * 思路：利用栈先进后出的特点代替递归保存分区的头尾指针（坐标）
     *
     * @param array
     */
    public static void sortByStack(int[] array) {
        int[] a = array.clone();
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            //出栈进行划分
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(a, low, high);

            //保存中间变量
            if (pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex < high && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] a, int low, int high) {
        if (low >= high) return -1;
        int left = low;
        int right = high;
        //保存基准的值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素，插入到基准位置中
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        //放置基准值，准备分治递归快排
        a[left] = pivot;
        return left;
    }

    /**
     * 数组基本有序时，会一直出现分区之后一边很少一边很多的情况，这样整体看下来近乎冒泡排序，时间复杂度由O（nlog2n）退化到O(n²)
     * 优化方式：随机取基准：（利用Random函数将第一个索引的值与分区内随机一个交换）
     *          三者取中法：取左端、中间、右端三个数，然后进行排序，将中间数作为枢纽值。
     * @param array
     */

    /**
     * 数组重复数据很多时，一个元素全部重复的子数组就不需要继续排序了，但我们的算法还会继续将它切分为更小的数组。
     * 在有大量重复元素的情况下，快速排序的递归性会使元素全部重复的子数组经常出现。
     * 优化方式：三向快速排序
     * 思路：将数组分为三部分，大于小于等于基准值，分别位列前中后位置；每次一个元素与基数比较的时候，大于或小于基数就交换并更新三区分界位置，等于的时候不做交换进入下个元素的比较。
     * 这样下来就会使重复的数据处在数组中间并避免做无用的处理。
     */
    public static void sortThreeWay(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int v = a[lo], lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, i++, lt++);
            } else if (a[i] > v) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sortThreeWay(a, lo, lt - 1);
        sortThreeWay(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


    //  =============================  快速排序 系列结束================================


    public static void bubbleSort(int[] array) {
        int[] a = array.clone();
        long start = System.currentTimeMillis();

        int tem;//将变量提出来避免重复生命
        boolean isChange;//内循环是否发生元素交互

        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            isChange = false;
            //内层循环控制到达位置
            for (int j = 0; j < a.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (a[j] > a[j + 1]) {
                    tem = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tem;
                    isChange = true;
                }
            }
            if (!isChange) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("bubbleSort排序用时==" + (end - start));
    }


    //归并所需的辅助数组
    private static int[] aux;

    public static void mergeSort(int[] array) {
        int[] a = array;
        //一次性分配空间
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        //将左半边排序
        sort(a, low, mid);
        //将右半边排序
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    /**
     * 该方法先将所有元素复制到aux[]中，然后在归并会a[]中。方法咋归并时(第二个for循环)
     * 进行了4个条件判断：
     * - 左半边用尽(取右半边的元素)
     * - 右半边用尽(取左半边的元素)
     * - 右半边的当前元素小于左半边的当前元素(取右半边的元素)
     * - 右半边的当前元素大于等于左半边的当前元素(取左半边的元素)
     *
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {
        //将a[low..mid]和a[mid+1..high]归并
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > high) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
        String string = getArrayString(a);
        System.out.println("归并结果==" + string);
    }

    /**
     * 基数排序
     * 类型：不需要比较的稳定排序（通过取余取模放置到二维数组中）
     * 思路：
     * 1 数字有个十百千位，从低位向高位开始排序，每排一次序就把元素放在一个二维数组（桶）中:buckets[基数][该基数出现次数]
     * 2 每排一次就从桶底开始取出来，这样取出来的就是按照当前基数排序好的
     * 3 基数上升一个（比如：由个位到十位），然后重复1~2
     * @param arr
     */
    public static void baseSort(int[] arr) {
        if (arr.length <= 1) return;

        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量

            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
    }


    private static String getArrayString(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int g : arr) {
            stringBuilder.append(g).append(" ");
        }
        return stringBuilder.toString();
    }

}
