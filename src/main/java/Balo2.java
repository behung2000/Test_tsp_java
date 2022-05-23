import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Balo2 {
    public static void main(String[] args){
        int N = 0;
        int M = 0;
        int[] A = new int[10000];
        int[] C = new int[10000];
        int[][] L = new int[10000][10000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\knapsack2b.inp";
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
            A[0]=0;
            C[0]=0;
            for(int i=1; i<=N; i++){
                String si = scanner.nextLine();
                stringTokenizer = new StringTokenizer(si," ");
                String h = stringTokenizer.nextToken();
                A[i] = Integer.parseInt(h);
                h = stringTokenizer.nextToken();
                C[i] = Integer.parseInt(h);
            }
        } catch (Exception ex){
        }

        //Khoi Tao
        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                L[i][j]=0;
            }
        }

        //Tao bang
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                if(j>=A[i]){
                    L[i][j] = Math.max(L[i-1][j-A[i]]+C[i], L[i-1][j]);
                }
                else{
                    L[i][j]=L[i-1][j];
                }
            }
        }


        //Truy Vet
        String SAi = " ";
        String SA = " ";
        String SC = " ";
        int sumA=0;
        int sumC=0;
        int j = M;
        for(int i=N; i>0; i--){
            if(L[i][j] != L[i-1][j]){
                SAi = String.valueOf(i)+" "+SAi;
                SA = String.valueOf(A[i])+" "+SA;
                SC = String.valueOf(C[i])+" "+SC;
                sumA = sumA+A[i];
                sumC = sumC+C[i];
                j=j-A[i];
            }
        }
        if(j>=A[0]){
            SAi = 0 + " "+SAi;
            SA = A[0]+" "+SA;
            SC = C[0]+" "+SC;
            sumA = sumA+A[0];
            sumC = sumC+C[0];
        }

        //In Ket qua
        System.out.println("N= "+N+" --- M= "+M);
        System.out.println("A:");
        for(int i=0; i<N; i++){
            System.out.print(A[i]+" ");
        }
        System.out.println("");
        System.out.println("C:");
        for(int i=0; i<=N; i++){
            System.out.print(C[i]+" ");
        }
        System.out.println("");
        System.out.println("L:");
        for(int i=0; i<=N; i++) {
            for (j=0; j < M; j++) {
                System.out.print(L[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("i : "+SAi);
        System.out.println("A : "+SA);
        System.out.println("C : "+SC);
        System.out.println("SumA= "+sumA);
        System.out.println("SumC= "+sumC);
    }
}
