import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

public class ShiYan1Test {
	
	@Test

	public void testQueryBridgeWords() 
	{
		Scanner input = new Scanner(System.in);
        System.out.println("Please input the path of input file:");
        String address = input.nextLine();
        String str = "";
        Logger log = Logger.getLogger(ShiYan1.class.getName());
        
        File file = new File(address);
        try {
            FileInputStream in =  new FileInputStream(file);
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            str = new String(buffer, "UTF-8");
        } catch (IOException e) {
        	log.warning(e.toString());
        }
        int[][] Graph = ShiYan1.createDirectedGraph(str);
        
		String result1 = ShiYan1.queryBridgeWords(Graph ,"bu", "yi");
		Assert.assertEquals("zai,", result1);
		
		String result2 = ShiYan1.queryBridgeWords(Graph ,"bu", "yiyi");
		Assert.assertEquals("#yiyi", result2);
		
		String result3 = ShiYan1.queryBridgeWords(Graph ,"bubu", "yi");
		Assert.assertEquals("#bubu", result3);
		
		String result4 = ShiYan1.queryBridgeWords(Graph ,"bubu", "yiyi");
		Assert.assertEquals("#bubuyiyi", result4);
		
		String result5 = ShiYan1.queryBridgeWords(Graph ,"bu", "zai");
		Assert.assertEquals("", result5);
		//C:\Users\Alice\Desktop\Test.txt
	}
}
