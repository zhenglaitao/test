package com.zlt.test.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class NIOComparator {
	public void IOMethod(String TPATH) {
		long start = System.currentTimeMillis();//��ʼ ʱ��
		try {
			DataOutputStream dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File(
							TPATH))));// �����
			for (int i = 0; i < 4000000; i++) {
				dos.writeInt(i);// д�� 4000000 ������
			}
			if (dos != null) {
				dos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();// ����ʱ��
		System.out.println(end - start+"  -----IOMethod   д��4000000��������ʱ��");
		start = System.currentTimeMillis();
		try {
			DataInputStream dis = new DataInputStream(new BufferedInputStream(
					new FileInputStream(new File(TPATH))));
			for (int i = 0; i < 4000000; i++) {
				dis.readInt();
			}
			if (dis != null) {
				dis.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void ByteMethod(String TPATH) {
		long start = System.currentTimeMillis();
		try {
			FileOutputStream fout = new FileOutputStream(new File(TPATH));
			FileChannel fc = fout.getChannel();// �õ��ļ�ͨ��
			ByteBuffer byteBuffer = ByteBuffer.allocate(4000000 * 4);// ����
																		// Buffer
			for (int i = 0; i < 4000000; i++) {
				byteBuffer.put(int2byte(i));// ������תΪ����
			}
			byteBuffer.flip();// ׼��д
			fc.write(byteBuffer);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start+"  -----ByteMethod   д��4000000��������ʱ��");

		start = System.currentTimeMillis();
		FileInputStream fin;
		try {
			fin = new FileInputStream(new File(TPATH));
			FileChannel fc = fin.getChannel();// ȡ���ļ�ͨ��
			ByteBuffer byteBuffer = ByteBuffer.allocate(4000000 * 4);// ����
																		// Buffer
			fc.read(byteBuffer);// ��ȡ�ļ�����
			fc.close();
			byteBuffer.flip();// ׼����ȡ����
			while (byteBuffer.hasRemaining()) {
				byte2int(byteBuffer.get(), byteBuffer.get(), byteBuffer.get(),
						byteBuffer.get());// �� byte תΪ����
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	public void mapMethod(String TPATH) {
		long start = System.currentTimeMillis();
		// ���ļ�ֱ��ӳ�䵽�ڴ�ķ���
		try {
			FileChannel fc = new RandomAccessFile(TPATH, "rw").getChannel();
			IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0,
					4000000 * 4).asIntBuffer();
			for (int i = 0; i < 4000000; i++) {
				ib.put(i);
			}
			if (fc != null) {
				fc.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start+"  -----mapMethod   д��4000000��������ʱ��");

		start = System.currentTimeMillis();
		try {
			FileChannel fc = new FileInputStream(TPATH).getChannel();
			MappedByteBuffer lib = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			lib.asIntBuffer();
			while (lib.hasRemaining()) {
				lib.get();
			}
			if (fc != null) {
				fc.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static byte[] int2byte(int res) {
		byte[] targets = new byte[4];
		targets[3] = (byte) (res & 0xff);// ���λ
		targets[2] = (byte) ((res >> 8) & 0xff);// �ε�λ
		targets[1] = (byte) ((res >> 16) & 0xff);// �θ�λ
		targets[0] = (byte) ((res >>> 24));// ���λ���޷�������
		return targets;
	}

	public static int byte2int(byte b1, byte b2, byte b3, byte b4) {
		return ((b1 & 0xff) << 24) | ((b2 & 0xff) << 16) | ((b3 & 0xff) << 8)
				| (b4 & 0xff);
	}

	public static void main(String[] args) {
		NIOComparator nio = new NIOComparator();
		nio.IOMethod("d:\\IOMethod.txt");
		nio.ByteMethod("d:\\ByteMethod.txt");
		nio.mapMethod("d:\\mapMethod.txt");
	}
}