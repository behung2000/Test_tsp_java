import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DayConTangDanKoLienTiep {

    public static void main(String[] args){
        int N=0;
        int[] A = new int[10000];
        int[] L = new int[10000];
        int[] P = new int[10000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\sequence2.inp";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
            Scanner scanner = new Scanner(fileInputStream);
            String s = scanner.nextLine();
            N = Integer.parseInt(s);
            s = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(s," ");
            for(int i=0; i<N; i++){
                String h = stringTokenizer.nextToken();
                A[i] = Integer.parseInt(h);
            }
        } catch (Exception ex){
        }

        //Khoi Tao
        for(int i=0; i<N; i++){
            L[i]=1;
            P[i]=-1;
        }

        //Tao bang L
        int Lmax=0;
        for(int i=1; i<N; i++){
            Lmax=0;
            for(int j=0; j<i; j++){
                if(A[i]>A[j]){
                    if(L[j]>Lmax){
                        Lmax=L[j];
                        P[i]=j;
                    }
                }
            }
            L[i] = Lmax+1;
        }

        int max = 1;
        int imax = 0;
        for(int i=0 ;i<N; i++){
            if(max<L[i]){
                max=L[i];
                imax=i;
            }
        }

        String SA = " ";
        Lmax = 0;
        while(imax>=0) {
            SA = A[imax] + " " + SA;
            imax = P[imax];
            Lmax += 1;
        }

        //In Kết quả
        System.out.println("N= "+N);
        System.out.print("Chuỗi đã cho là               :");
        for(int i=0; i<N; i++) System.out.print(A[i]+" ");
        System.out.println();
        System.out.print("Độ dài chuỗi lớn nhất theo i  :");
        for(int i=0; i<N; i++) System.out.print(L[i]+" ");
        System.out.println();
        System.out.print("Vị trí trước i là             :");
        for(int i=0; i<N; i++) System.out.print(P[i]+" ");
        System.out.println();
        System.out.println("max = "+Lmax);
        System.out.println("Thu tu: "+SA);

    }
}
