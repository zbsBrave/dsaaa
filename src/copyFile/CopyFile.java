package copyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFile {
	//s  source  ,    t  target
	public static void copyFile(String s,String t) {
		File sFile = new File(s);
		if(!sFile.exists()) throw new RuntimeException("�ļ�������: " + s);
		try(FileChannel in = new FileInputStream(sFile).getChannel();
				FileChannel out = new FileOutputStream(createFile(t)).getChannel()){
			long position = 0;
			long size = in.size();
			while(size > 0) {
				long count = in.transferTo(position, size, out);
				size -= count;
				position += count;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//����Ŀ���ļ�ʱ�����û���ļ������Զ�����
	public static File createFile(String target) {
		File file = new File(target);
		File parentFile = file.getParentFile();
		if(parentFile!=null && !parentFile.exists()) {
			parentFile.mkdirs();
		}
		return file;
	}
	public static void main(String[] args) throws IOException {
		//File f = new File("C:/Users/zbs/Desktop/q/2.txt");
		CopyFile.copyFile("1.txt", "2.txt");
	}
}
