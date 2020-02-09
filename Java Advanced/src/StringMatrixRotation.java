import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        int lengthMax = 0;
        Pattern p = Pattern.compile("^(Rotate)(\\()([0-9]+)(\\))");
        String in = br.readLine();
        Matcher m = p.matcher(in);
        if(m.matches()) {
            int degrees = Integer.parseInt(m.group(3));
            int times = degrees/90;
            while (true) {
                String input = br.readLine();
                if (input.equals("END")) {
                    break;
                }
                if (input.length() > lengthMax) {
                    lengthMax = input.length();
                }
                list.add(input);
            }
            char[][] matrix = new char[list.size()][lengthMax];

            //FILLING THE MATRIX
            for (int i = 0; i < matrix.length; i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(i));
                if(list.get(i).length() < lengthMax){
                    for(int j=0; j<lengthMax-list.get(i).length(); j++){
                        sb.append(" ");
                    }
                }
                matrix[i] = sb.toString().toCharArray();
            }
            for(int i=0; i<times; i++){
                matrix =  rotate(matrix);
            }
            print(matrix);

        }
    }
    public static char [][] rotate(char [][] input){

        int n =input.length;
        int m = input[0].length;
        char [][] output = new char [m][n];

        for (int i=0; i<n; i++)
            for (int j=0;j<m; j++)
                output [j][n-1-i] = input[i][j];
        return output;
    }

    public static void print(char[][] matrix){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}