package pt.isec.pa.aulas.ex9;

public class Pascal {

    int[][] t;

    public Pascal(int size) {
        create(size);
    }

    public void create(int size) {
        t = new int[size][];
        for (int i=0;i<size;i++){
            t[i] = new int[i+1];
            t[i][0] = t[i][i] = 1;
            for (int j=0;j<i;j++){
                t[i][j] = t[i-1][j] + t[i-1][j];
            }
        }
    }

    private String format(boolean align){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<t.length;i++){
            if (align){
                stringBuilder.append("".repeat((t.length-i)+6/2));
            }
            for (int j=0;j<t[i].length;j++){
                stringBuilder.append(String.format("%6d",t[i][j]));
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString(){
        return format(false);
    }

    public void show(boolean allign) {
        System.out.println(format(allign));
    }
}
