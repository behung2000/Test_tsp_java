import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DiChuyenTrenBang {

    public static void main(String[] args){
        int N = 0;
        int M = 0;
        int[][] A = new int[10000][10000];
        int[][] L = new int[10000][10000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\move2.inp";
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
            for(int j=0; j<=M; j++) A[0][j]=0;
            for(int i=0; i<=N; i++) A[i][0]=0;
            for(int i=1; i<=N; i++){
                String si = scanner.nextLine();
                stringTokenizer = new StringTokenizer(si, " ");
                for(int j=1; j<=M; j++) {
                    String h = stringTokenizer.nextToken();
                    A[i][j] = Integer.parseInt(h);
                }
            }
        } catch (Exception ex){
        }

        //Khoi Tao
        for(int i=0; i<=N; i++){
            for(int j=0; j<=M; j++){
                if(j==1) L[i][j]=A[i][j];
                else L[i][j]=0;
            }
        }

        //Tao bang L
        for(int j=1; j<=M; j++) {
            for(int i=1 ;i<=N; i++) {
                L[i][j] = Math.max(L[i][j - 1], Math.max(L[i - 1][j - 1], L[i + 1][j - 1])) + A[i][j];
            }
        }

        //Truy vet
        int LmaxJ = L[0][M-1];
        int Li = 0;
        for(int i=1; i<=N; i++){
            if(LmaxJ< (L[i][M])) {
                LmaxJ = L[i][M];
                Li = i;
            }
        }

        int Lmax = LmaxJ;
        LmaxJ = Lmax - A[1][M];
        String SA = ""+A[1][M];
        String Si = ""+Li;
        String Sj = ""+M;

        for(int j=M-1; j>0; j--){
            Sj = j + " " + Sj;
            for(int i=1; i<=N; i++){
                if(LmaxJ == L[i][j]) {
                    LmaxJ = LmaxJ - A[i][j];
                    SA = A[i][j] + " " + SA;
                    Si = i + " " + Si;
                    break;
                }
            }
        }

        //in kết quả
        System.out.println("N= "+N);
        System.out.println("M= "+M);
        System.out.println("Bang A:");
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Bang B:");
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                System.out.print(L[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("Cot:     "+Sj);
        System.out.println("Dong:    "+Si);
        System.out.println("Gia tri: "+SA);
        System.out.println(Lmax);

    }

}
