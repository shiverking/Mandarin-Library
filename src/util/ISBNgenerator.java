package util;
import java.math.*;
import java.util.ArrayList;
import java.util.Random;
public class ISBNgenerator {
	/*����������������10λ���ֵ�stringֵ��Ϊͼ���ISBN*/
	private static String  Numbers[] = {"0","1","2","3","4","5","6","7","8","9"}; 
	public static String generateISBN() {
		String tmp="";
		Random random = new Random();
		for(int i=0;i<10;i++) {
			int randomNumber= random.nextInt(10);
			tmp+=Numbers[randomNumber];
		}
		return tmp;
	}
}
