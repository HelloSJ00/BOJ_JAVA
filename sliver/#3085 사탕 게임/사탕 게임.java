import java.io.*;
import java.util.*;

public class Main{
    static int answer = 0 ; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] board = new String[N+1][N+1];
        
        for(int i = 1 ; i <= N ; i++){
            String s = br.readLine();
            for(int j = 1; j <= N ; j++){
                board[i][j] = String.valueOf(s.charAt(j-1));
            }
        }
        
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= N ; j++){
                answer = Math.max(answer,row(i,j,board));
                answer = Math.max(answer,col(i,j,board));
            }
        }
        
        for(int i = 1 ; i <= N ; i ++){
            for(int j = 1; j <=N ; j++){
                answer = Math.max(answer,cal(i,j,board));
            }
        }

        System.out.println(answer);
    }
    public static int row(int i,int j, String[][] board){
        String tmp = board[i][j];
        int left = 1;
        int right = 1;

        while(true){
            if(j-left >= 1 && tmp.equals(board[i][j-left])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(j+right <= board.length-1 && tmp.equals(board[i][j+right])){
                right++;
            } else {
                break;
            }
        }
        return left+right-1;
    }

    public static int col(int i,int j, String[][] board){
        String tmp = board[i][j];
        int left = 1;
        int right = 1;

        while(true){
            if(i-left >= 1 && tmp.equals(board[i-left][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(i+right <= board.length-1 && tmp.equals(board[i+right][j])){
                right++;
            } else {
                break;
            }
        }
        return left+right-1;
    }
    public static int cal(int i,int j, String[][] board){
        int answer = 0;
        if(i-1 >= 1){
            answer = Math.max(answer,cal_1(i,j,board));
        }
        
        if(i+1 <= board.length-1){
            answer = Math.max(answer,cal_2(i,j,board));
        }
        if(j-1 >= 1){
            answer = Math.max(answer,cal_3(i,j,board));
        }
        
        if(j+1 <= board.length-1){
            answer = Math.max(answer,cal_4(i,j,board));
        }

        return answer;
    }

    public static int cal_1(int i , int j , String[][] board){
        int answer = 0;
        String tmp = board[i][j];
        board[i][j] = board[i-1][j];
        board[i-1][j] = tmp;

        int left = 1;
        int right = 1;

        while(true){
            if(i-left >= 1 && board[i-left][j].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(i+right <= board.length-1 && board[i+right][j].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);

        left = 1;
        right = 1;

        while(true){
            if(j-left >= 1 && board[i][j-left].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(j+right <= board.length-1 && board[i][j+right].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);
        tmp = board[i][j];
        board[i][j] = board[i-1][j];
        board[i-1][j] = tmp;
        return answer;
    }
    public static int cal_2(int i , int j , String[][] board){
        int answer = 0;
        String tmp = board[i][j];
        board[i][j] = board[i+1][j];
        board[i+1][j] = tmp;

        int left = 1;
        int right = 1;
        while(true){
            if(i-left >= 1 && board[i-left][j].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(i+right <= board.length-1 && board[i+right][j].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);

        left = 1;
        right = 1;

        while(true){
            if(j-left >= 1 && board[i][j-left].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(j+right <= board.length-1 && board[i][j+right].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);
        tmp = board[i][j];
        board[i][j] = board[i+1][j];
        board[i+1][j] = tmp;
        return answer;
    }
    public static int cal_3(int i , int j , String[][] board){
        int answer = 0;
        String tmp = board[i][j];
        board[i][j] = board[i][j-1];
        board[i][j-1] = tmp;

        int left = 1;
        int right = 1;
        while(true){
            if(i-left >= 1 && board[i-left][j].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(i+right <= board.length-1 && board[i+right][j].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);

        left = 1;
        right = 1;

        while(true){
            if(j-left >= 1 && board[i][j-left].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(j+right <= board.length-1 && board[i][j+right].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);
        tmp = board[i][j];
        board[i][j] = board[i][j-1];
        board[i][j-1] = tmp;
        return answer;
    }
    public static int cal_4(int i , int j , String[][] board){
        int answer = 0;
        String tmp = board[i][j];
        board[i][j] = board[i][j+1];
        board[i][j+1] = tmp;

        int left = 1;
        int right = 1;
        while(true){
            if(i-left >= 1 && board[i-left][j].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(i+right <= board.length-1 && board[i+right][j].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);

        left = 1;
        right = 1;

        while(true){
            if(j-left >= 1 && board[i][j-left].equals(board[i][j])){
                left++;
            } else {
                break;
            }
        }

        while(true){
            if(j+right <= board.length-1 && board[i][j+right].equals(board[i][j])){
                right++;
            } else {
                break;
            }
        }

        answer = Math.max(answer,left+right-1);
        tmp = board[i][j];
        board[i][j] = board[i][j+1];
        board[i][j+1] = tmp;
        return answer;
    }
}