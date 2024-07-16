package telran.util;

import java.lang.reflect.Array;

public class Arrays {
public static int search(int[] ar, int key){
    int index =0;
    while(index <ar.length && key != ar[index]){
        index++;
    }
    return index == ar.length ? -1 : index;
}
public static int[] add(int [] ar, int number){
    int [] res = java.util.Arrays.copyOf(ar, ar.length+1);
    res[ar.length]=number;
    return res;
}
public static int[] insert(int[] ar, int index, int number){
    
    int [] res = java.util.Arrays.copyOf(ar, ar.length+1);
    res [index]=number;
    System.arraycopy(ar, index, res, index+1, ar.length-index);
    
    return res;
}

public static int[] remove(int[] numbers, int index){

    int [] res = new int [numbers.length-1];
    
    System.arraycopy(numbers, 0, res, 0, index);
    System.arraycopy(numbers, index+1,res, index, numbers.length-index-1);
    return res;
}
public static boolean pushMaxAtEnd(int [] ar, int length){
    boolean res = true;
    for(int i = 0; i < length; i++){
        if (ar[i] > ar[i+1]){
            res = false;
            swap(ar, i, i+1);
        }
    }
    return res;
}

    private static void swap(int[] ar, int i, int j) {
        int tmp = ar[i];
        ar[i] = ar[j];
        ar[j]=tmp;
    }
    public static void sort(int [] ar){
        int length = ar.length;
        boolean flSorted = false;
        while (!flSorted){
            length--;
            flSorted = pushMaxAtEnd(ar, length);
            }
        }

        public static int binarySearch(int [] ar, int key){
            
            int start = 0;
            int end = ar.length-1;
            int res = -1;

            while(start <= end){
                int index = start + ((end -start) / 2);
                
                if (ar[index]<key){
                    start = index + 1;
                } else if (ar[index]>key){
                    end = index - 1;
                } else {
                    res = index;
                    break;
                }
            }
            return res == -1 ? (-start-1) : res;

        }
            public static int[] insertSorted(int [] arSorted, int number){
                int index = binarySearch(arSorted, number);
                if (index < 0) index = - index - 1;
                return insert(arSorted, index, number);
            }

                public static boolean isOneSwap(int [] array){
                    boolean res = false;
                    int i = 0;
                    int index1 = -1, index2 = -1;

                    while(i<array.length-1){
                        if(array[i] > array[i+1]){
                            if (index1 < 0){
                                index1 = i;
                            } else {
                                index2 = i + 1;
                            }
                        }
                        i++;
                    }
                    if (index1 >= 0) {
                        if(index2 < 0) index2 = index1+1;
                        int[] testArray = java.util.Arrays.copyOf(array, array.length);
                        swap(testArray, index2, index1);
                        res = isSortedArray(testArray);
                    }
                    return res;
                }

            public static boolean isSortedArray(int [] ar){
                boolean res = true;

                for(int i = 0; i < ar.length - 1; i++ ){
                    if (ar[i]>ar[i+1]){
                        res = false;
                        break;
                    }
                }
                return res;
            }

        }

    

