package pt.isec.pa.aulas.Ex04;

import java.util.Arrays;
import java.util.Random;

public class Array20 {
    public static final int N_VALUES = 20;
    int nDup;
    int[] arr;

    public Array20(){
        this.arr = new int[N_VALUES];
        nDup = 0;
    }


    public void fill() {
        Random rnd = new Random();
        int r;
        for (int i = 0; i < N_VALUES; i++) {
            do{
                r = rnd.nextInt(100 + 1);
                ++nDup;
            }while(contains(r));
            arr[i] = r;
        }
    }

    public int getnDup() {
        return nDup - N_VALUES;
    }

    public void list() {
        System.out.println(Arrays.toString(arr));
    }

    private boolean contains(int v){
        for (int a : arr) {
            if(a == v){
                return true;
            }
        }
        return false;
    }
}