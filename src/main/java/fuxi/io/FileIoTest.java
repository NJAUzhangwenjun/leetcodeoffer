package fuxi.io;

import org.junit.Test;

import java.io.*;

/**
 * @Description: TODO
 * @author 张文军
 * @Company: njauit.cn
 * @version: 1.0
 * @date 2020/7/1420:32
 */
public class FileIoTest {
	File outfile = new File("a.txt");
	File infile = new File("commonCommands.sh");

	@Test
	public void fileOutputStreamTest() {


		byte[] bytes = new byte[1024];
		try (FileOutputStream fileOutputStream = new FileOutputStream(outfile, true);
				FileInputStream fileInputStream = new FileInputStream(infile)) {

			int off = 0;
			while ((off = fileInputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, off);
				System.out.println("off = " + off);
			}
			fileOutputStream.write("/r/n文件写入结束！".getBytes());
			System.out.println("/r/n文件写入结束！".getBytes().length);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void fileWRTest() {
		File outfile = new File("b.txt");
		File infile = new File("commonCommands.sh");


		try (Reader reader = new FileReader(infile); Writer writer = new FileWriter(outfile)) {
			char[] chars = new char[1024];
			int len = 0;
			while ((len = reader.read(chars)) != -1) {
				writer.write(chars, 0, len);
			}
			writer.write("Writer success");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	@Test
	public void ObjectXXXStream() {

		User user = new User();
		user.setUsername("123");
		user.setPassword("2131");
		user.setAge(10);
		user.setHobby("123");

		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("user.txt"));
				ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("user.txt"))) {

			outputStream.writeObject(user);

			//			User user1 = (User)inputStream.readObject();
			System.out.println("user = " + user);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}


