package wzg;
import java.io.RandomAccessFile;
public class RandomAccessFileTest {
	public static void main(String[] args) {
		try(RandomAccessFile raf=new RandomAccessFile("src/wzg/RandomAccessFileTest.java", "r")) {
			//��ȡ�ļ�ָ���λ�ã���ʼֵΪ0��
			System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ�ã�"+raf.getFilePointer());
			//�����ļ�ָ���λ��
			raf.seek(85);
			byte[] buf=new byte[1024];
			int hasRead=0;
			while((hasRead=raf.read(buf))!=-1){
				//��ӡ���ָ��Ϊ85λ�ú��������
				System.out.println(new String(buf,0,hasRead));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
