package wzg;

import java.io.RandomAccessFile;

public class AppendContent {
	public static void main(String[] args) {
		try (RandomAccessFile raf=new RandomAccessFile("File/out.txt","rw")){
			raf.seek(raf.length());
			raf.write("׷�ӵ����ݣ�\n".getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
