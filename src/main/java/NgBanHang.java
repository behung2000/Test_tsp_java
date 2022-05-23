import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class NgBanHang {

    // Function to find the minimum weight
    // Hamiltonian Cycle
    static int tsp(int[][] graph, boolean[] v,
                   int currPos, int n,
                   int count, int cost, int ans)
    {

        // If last node is reached and it has a link
        // to the starting node i.e the source then
        // keep the minimum value out of the total cost
        // of traversal and "ans"
        // Finally return to check for more possible values
        if (count == n && graph[currPos][0] > 0)
        {
            ans = Math.min(ans, cost + graph[currPos][0]);
            return ans;
        }

        // BACKTRACKING STEP
        // Loop to traverse the adjacency list
        // of currPos node and increasing the count
        // by 1 and cost by graph[currPos,i] value
        for (int i = 0; i < n; i++)
        {
            if (v[i] == false && graph[currPos][i] > 0)
            {

                // Mark as visited
                v[i] = true;
                ans = tsp(graph, v, i, n, count + 1,
                        cost + graph[currPos][i], ans);

                // Mark ith node as unvisited
                v[i] = false;
            }
        }
        return ans;
    }

    // Driver code

    public static void main(String[] args){
        // n is the number of nodes i.e. V
        /*
        int n = 4;

        int[][] graph = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
         */

        int n=0;
        int[][] graph = new int[1000][1000];

        String url ="C:\\Users\\LuckyKendo\\Desktop\\HK2_2021_2022\\Seminar\\KTLan1\\filetest\\data_test1\\tsp2.inp";
        // Đọc dữ liệu từ File với Scanner
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(url);
            Scanner scanner = new Scanner(fileInputStream);
            String s = scanner.nextLine();
            System.out.println(s);
            n = Integer.parseInt(s);
            System.out.println("n= "+n);
            for(int i=0; i<n; i++){
                String si = scanner.nextLine();
                System.out.println(si);
                StringTokenizer stringTokenizer = new StringTokenizer(si," ");
                int h = stringTokenizer.countTokens();
                for(int j=0; j<h; j++){
                    String sj = stringTokenizer.nextToken();
                    graph[i][j] = Integer.parseInt(sj);
                }
            }
        } catch (Exception ex){
        }


        // Boolean array to check if a node
        // has been visited or not
        boolean[] v = new boolean[n];

        // Mark 0th node as visited
        v[0] = true;
        int ans = Integer.MAX_VALUE;

        // Find the minimum weight Hamiltonian Cycle
        ans = tsp(graph, v, 0, n, 1, 0, ans);

        // ans is the minimum weight Hamiltonian Cycle
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
        System.out.println(ans);
    }
}
