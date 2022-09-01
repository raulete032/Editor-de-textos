package practica_27;

import java.awt.GraphicsEnvironment;
import java.util.Arrays;

public class test {

	public static void main(String[] args) {

		
		String[] fontNames=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		System.out.println(Arrays.toString(fontNames));
		
		
	}

}
