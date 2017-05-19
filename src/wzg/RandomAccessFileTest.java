package wzg;
import java.io.RandomAccessFile;
public class RandomAccessFileTest {
	public static void main(String[] args) {
		try(RandomAccessFile raf=new RandomAccessFile("src/wzg/RandomAccessFileTest.java", "r")) {
			//获取文件指针的位置，初始值为0；
			System.out.println("RandomAccessFile的文件指针的初始位置："+raf.getFilePointer());
			//设置文件指针的位置
			raf.seek(85);
			byte[] buf=new byte[1024];
			int hasRead=0;
			while((hasRead=raf.read(buf))!=-1){
				//打印输出指针为85位置后面的内容
				System.out.println(new String(buf,0,hasRead));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
