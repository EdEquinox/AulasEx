package pt.isec.pa.aulas.ex7;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Matrix m1 = new Matrix(4,3);
        for (int i=0; i<4; i++){
            for (int j=0; j<3; j++){
                m1.set(i,j,(float) Math.random()*100);
            }
        }

        Matrix m2 = new Matrix(m1);

        m1.show();
        System.out.println();
        m2.show();
        System.out.println();


        m1.set(2,2,100);
        m1.set(2,2,200);
        m1.show();

        Matrix m3 =  (Matrix) m1.clone();

        m1.add(m2);

        Matrix m4 = Matrix.add(m2,m3);
    }

}
