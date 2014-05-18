package levelTest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ユーザに値を入力してもらい、素数を出力するプログラムです。。
 * チャレンジ問題　初級　5番
 *@author RikakoTakaishi
 *
 */
public class Eratosthenes {
	/**
	 * ユーザに値を入力してもらい、素数を出力するプログラムです。
	 *@param args 何もしてない
	 *@throws NumberFormatException
	 *@throws IOException
	 */
	public static void main(String args[]){
		String line;
		int isUserNum = 0;
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("素数リストを出力するプログラムです。");
			System.out.println("リストの最大値を整数で入力してください。");
			line = reader.readLine(); // ユーザの値を入力
			isUserNum = Integer.parseInt(line);
			seive(isUserNum);
		} catch(NumberFormatException e) {
			System.out.println("不正なあたいが入力されました");
		} catch(IOException e) {
			System.out.println(e);
		} 
	}

	/**
	 * ユーザが入力した値をもとに配列を作り、trueを代入する。
	 * iの倍数の時は、falseを代入する
	 *@param reader
	 *@throws IOException
	 */
	private static void seive(int isUserNum) {
		boolean isPrim[] = new boolean[isUserNum+1];
		//　isPrimにtrueを代入する
		for(int i = 0; i <= isUserNum; i ++) {
			isPrim[i] = true;
		}
		// 0と1は素数ではないので、falseを代入する
		isPrim[0] = false;
		isPrim[1] = false;
		//　falseを仕込んでいく
		for(int i=2; i*i < isUserNum; i++) {
			if(isPrim[i]) {
				//　もしiが素数じゃなければfalseを入れておく
				for(int j = i * 2; j < isPrim.length; j += i) {
					isPrim[j] = false;
				}
			}
		}
		// trueを仕込んだ、素数を表示させる
		for(int i = 2; i <= isUserNum; i++){
			if(isPrim[i]){
				System.out.print(i+" ");
			}
		}
	}
}
