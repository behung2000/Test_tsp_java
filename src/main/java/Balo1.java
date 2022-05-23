import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Balo1 {

    public static void main(String[] args){
        int N = 0;
        int M = 0;
        int[] A = new int[10000];
        int[][] L = new int[10000][10000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\knapsack1b.inp";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
            Scanner scanner = new Scanner(fileInputStream);
            String s = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s, " ");
            String sn = stringTokenizer.nextToken();
            String sm = stringTokenizer.nextToken();
            N = Integer.parseInt(sn);
            M = Integer.parseInt(sm);
            //sSystem.out.println("N= "+N+" -- M= "+M);
            String si = scanner.nextLine();
            stringTokenizer = new StringTokenizer(si," ");
            A[0]=0;
            for(int i=1; i<=N; i++){
                String h = stringTokenizer.nextToken();
                A[i] = Integer.parseInt(h);
            }
        } catch (Exception ex){
        }

        //Khoi tao
        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                L[i][j]=0;
            }
        }

        //Tao bang
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(j>=A[i]){
                    if(i>0) L[i][j] = Math.max(L[i-1][j-A[i]]+A[i], L[i-1][j]);
                }
                else{
                    if(i>0) L[i][j]=L[i-1][j];
                }
            }
        }

        //Truy Vet
        String SAi = " ";
        String SA = " ";
        int sum=0;
        int j = M;
        for(int i=N; i>0; i--){
            if(L[i][j] != L[i-1][j]){
                SAi = String.valueOf(i)+" "+SAi;
                SA = String.valueOf(A[i])+" "+SA;
                sum = sum+A[i];
                j=j-A[i];
            }
        }
        if(j>=A[0]){
            SAi = 0 + " "+SAi;
            SA = A[0]+" "+SA;
            sum = sum+A[0];
        }

        //In Ket qua
        System.out.println("N= "+N+" --- M= "+M);
        System.out.println("A:");
        for(int i=0; i<=N; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println("");
        System.out.println("L:");
        for(int i=0; i<=N; i++) {
            for (j=0; j <=M; j++) {
                System.out.print(L[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("i : "+SAi);
        System.out.println("A : "+SA);
        System.out.println("Sum= "+sum);

    }
}
