package wzg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void main(String[] args) throws Exception {
		intsert("file/wzg.txt",45,"���������");
	}
	private static void intsert(String fileName, int pos, String instertContent) throws Exception {
		//����һ����ʱ�ļ�������Ϊtmp����׺��Ϊ��
		File tmp=File.createTempFile("tmp", null);
		//����RandomAccessFile�����Կɶ���д�ķ�ʽ�����ļ�
		RandomAccessFile raf=new RandomAccessFile(fileName, "rw");
		//�����������������
		FileOutputStream fos=new FileOutputStream(tmp);
		FileInputStream fis=new FileInputStream(tmp);
		//������Ҫ��ʲôλ�ò�������
		raf.seek(pos);
		byte [] bbuf=new byte[64];
		int hasRead=0;
		while((hasRead=raf.read(bbuf))!=-1){
			//����ȡ�����ݴ��뵽��ʱ�ļ���
			fos.write(bbuf, 0, hasRead);
		}
		//���������ļ�ָ���λ��Ϊpos��
		raf.seek(pos);
		//׷����Ҫ�������������
		raf.write(instertContent.getBytes());
		//׷����ʱ�ļ��е�����
		while((hasRead=fis.read(bbuf))!=-1){
			raf.write(bbuf, 0, hasRead);
			
		}
		raf.close();
		fos.close();
		fis.close();
	}
}