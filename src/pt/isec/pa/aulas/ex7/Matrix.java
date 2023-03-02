package pt.isec.pa.aulas.ex7;

import java.util.Arrays;

public class Matrix implements Cloneable{
    float values[][];

    public Matrix(int row, int collumn){
        values = new float[row][collumn];
    }

    public Matrix(Matrix nmatrix){
//        --------------------------
//        values = nmatrix.values;
//        --------------------------
//        values = new float[nmatrix.values.length][nmatrix.values[0].length];
//        for (int rows=0; rows<values.length; rows++){
//            for (int collumns=0; collumns< values[rows].length; collumns++){
//                values[rows][collumns] = nmatrix.values[rows][collumns];
//            }
//        }
//        --------------------------
//        values = new float[nmatrix.values.length][nmatrix.values[0].length];
//        for (int rows=0; rows<values.length; rows++){
//            values[rows] = new float[nmatrix.values[rows].length];
//            System.arraycopy(nmatrix.values[rows], 0, values[rows],0,nmatrix.values[rows].length);
//        }
//        ---------------------------
        _copy(nmatrix);
    }

    private void _copy(Matrix nmatrix){
        values = new float[nmatrix.values.length][nmatrix.values[0].length];
        for (int rows=0; rows<values.length; rows++){
            values[rows] = Arrays.copyOf(nmatrix.values[rows],nmatrix.values[rows].length);
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        Matrix matrix = (Matrix) super.clone();
        return matrix;
    }

    public float get(int row, int collumn) {
        return values[row][collumn];
    }

    public void show() {
        for (int rows=0; rows<values.length; rows++){
            for (int collumns=0; collumns< values[rows].length; collumns++){
                System.out.printf("%8.2f",values[rows][collumns]);
            }
            System.out.println();
        }
    }

    public void set(int row, int collumn, float v){
        values[row][collumn] = v;
    }

    public boolean add(Matrix m2) {

        if (m2.values.length == this.values.length){
            for (int rows=0; rows<values.length; rows++){
                for (int collumns=0; collumns< values[rows].length; collumns++){
                    values[rows][collumns] += m2.values[rows][collumns];
                }
            }
            return true;
        }
        else
            return false;
    }

    public static Matrix add (Matrix m1, Matrix m2){
        Matrix nova =  new Matrix(m1);
        return nova.add(m2) ? nova : null;
    }
}
