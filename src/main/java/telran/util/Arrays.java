package telran.util;

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
    
    int [] res1 = new int [ar.length-index+1];
    System.arraycopy(ar, 0, res1, 0, ar.length-index+1);
    add(res1, number);
    int [] res = java.util.Arrays.copyOf(res1, ar.length+1);
    System.arraycopy(ar, index, res, index+1, ar.length-index);
    
    return res;
}

public static int[] remove(int[] numbers, int index){
    int [] res1 = new int [numbers.length-index+1];
    int [] res = new int [numbers.length-1];
    
    System.arraycopy(numbers, 0, res1, 0, res1.length);
    System.arraycopy(numbers, numbers.length-index+2,res,res1.length, numbers.length-index-1);
    return res;
}
}
