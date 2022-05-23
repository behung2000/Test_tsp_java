import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ToMau {

    public static void main(String[] args){
        int N=0;
        int[][] graph = new int[1000][1000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\color2.inp";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
            Scanner scanner = new Scanner(fileInputStream);
            String s = scanner.nextLine();
            N = Integer.parseInt(s);
            //System.out.println("n= "+N);
            for(int i=1; i<=N; i++){
                String si = scanner.nextLine();
                StringTokenizer stringTokenizer = new StringTokenizer(si," ");
                for(int j=1; j<=N; j++){
                    String sj = stringTokenizer.nextToken();
                    graph[i][j] = Integer.parseInt(sj);
                    //System.out.println(sj+"--"+graph[i][j]);
                }
            }
            //System.out.println();
        } catch (Exception ex){
        }
        /*
        for(int i=1;i<=N;i++){ //In mang ra man hinh de theo doi
            for(int j=1;j<=N;j++) System.out.print(graph[i][j]+" ");
            System.out.println();
        }
        System.out.println();
         */

        //Xu ly de cho ra ket qua vao mang m[]
        int sm=0;
        int[] m = new int[1000];
        for(int i=1; i<=N; i++) m[i]=0;
        int kt;
        for(int i=1;i<=N;i++) {
            if(m[i]==0) {
                sm++; //Dem so mau
                m[i] = sm;
                for (int j = i + 1; j <= N; j++) //Kiem tra xem nhung dinh nao co the gan bang mau sm nua khong
                    if ((graph[i][j] == 0) && (m[j] == 0)) {
                        kt = 1;
                        for (int k = i + 1; k < j; k++)
                            if ((graph[k][j] == 1) && (m[i] == m[k])) {
                                kt = 0;
                                break;
                            }
                        if (kt == 1) m[j] = sm;
                    }
            }
        }

        //In ra
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++) System.out.print(graph[i][j]+" ");
            System.out.println();
        }
        System.out.println();
        System.out.println("KQ:");
        for(int i=1;i<=sm;i++){
            System.out.print("Mau "+i+": ");
            for(int j=1;j<=N;j++) if(m[j]==i) System.out.print(j+" ");
            System.out.println();
        }
    }
}
