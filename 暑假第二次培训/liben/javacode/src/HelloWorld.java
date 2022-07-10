import java.io.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) throws IOException {
        String dirname = "F:\\javacode\\first\\first";
        File d = new File(dirname);
        System.out.println(d.exists());
        // 现在创建目录
        String s[] = d.list();// 返回字符串数组，不能遍历子目录
        for (int i = 0; i < s.length; i++) {
            File f = new File(dirname + "/" + s[i]);
            if (f.isDirectory()) {
                System.out.println(s[i] + ":是一个目录");
            } else {
                System.out.println(s[i] + ":不是一个目录");
            }
        }
        File f = new File("F:\\javacode\\first\\first\\src");
        // 是否存在
        System.out.println(f.exists());
        // 是否是一个目录,如果目录存在返回true，如果不是目录或目录不存在则返回false
        System.out.println(f.isDirectory());
        // 是否是一个文件
        System.out.println(f.isFile());
        // 创建一个新目录，如果不存在就创建，存在就删除。
        File f1 = new File("F:\\javacode\\first\\first\\src\\日记1.text");
        // File f1=new File("F:\\javacode\\first\\first\\src","日记1.text");
        if (!f1.exists())
            f1.createNewFile();
        else
            f1.delete();
        // 常用的File对象的API
        System.out.println(f1);// f1.toString()的内容
        System.out.println(f1.getAbsoluteFile());
        System.out.println(f1.getName());
        System.out.println(f1.getParent());// f1的上一级目录
        // 遍历子目录下的文件
        listFiles(new File("F:\\javacode\\first\\first"));
        // RandomAccessFile java 可以访问文件，读文件，写文件
        // (1)java 文件模型，在硬盘上的文件是byte byte byte存储的，是数据的集合
        // (2)打开文件
        // 'rw'(读写)，‘r’(只读)
        // RandomAccessFile raf =new RandomAccessFile(f2,"rw");
        // (3)写方法
        // raf.write(int)只写一个字节（后8位）,同时指针指向下一个位置
        // (4)读方法
        // int b=raf.read()读一个字节
        // (5)文件读写完成后一定要关闭，raf.close();
        File demo = new File("demo");
        if (!demo.exists())
            demo.mkdir();
        File f2 = new File(demo, "raf.dat");
        if (!f2.exists())
            f2.createNewFile();
        RandomAccessFile raf = new RandomAccessFile(f2, "rw");
        System.out.println(raf.getFilePointer());// 获取指针
        raf.write('a');// 只写了一个字节
        System.out.println(raf.getFilePointer());
        int i = 100;
        raf.writeInt(i);// 写入int类型数据，int类型占4个字节
        System.out.println(raf.getFilePointer());
        String a = "中";
        byte[] gbk = a.getBytes("gbk");// 转换成gbk的字节数组
        raf.write(gbk);// 中文占两个字节
        System.out.println(raf.getFilePointer());
        System.out.println(raf.length());// 整个文件的指针长度
        // 读文件，必须把指针移到头部
        raf.seek(0);
        // 一次性读取，把文件中的内容都读到字节数组中
        byte[] buf = new byte[(int) raf.length()];
        raf.read(buf);
        System.out.println(Arrays.toString(buf));
        // 读取单个字
        raf.seek(6);
        System.out.println(raf.read());
        raf.close();// 读取完成后关闭文件
        // 1.字节流
        // InputStream（读取）、OutputStream（写出）抽象类
        // EOF=End 读到-1就读到结尾
        // int b=in.read();
        // in.read(byte[] buf) 读取数据填充到字节数组buf
        // in.read(byte[] buf,int start,int size)读取数据到字节数组buf，从buf的start位置开始存放size长度的数据
        // out.write(int b) 写出一个byte到流，b的低8位，一个字节
        // out.write(byte[] buf)将buf字节数组都写入到流
        // out.write(byte[] buf,int start,int size)字节数组buf从start位置开始写size长度的字节到流
        // FileInputStream在文件上读取数据，把文件作为一个字节流进行读取操作
        // FileOutputStream实现了项文件中写出byte数据的方法

        // 如果文件不存在，则直接创建，如果存在，则把该文件删除后创建，（括号里面没true，且该文件为空，或者不想要该文件里的内容），若括号里面有true，则直接在该文件内部追加内容
        FileOutputStream out = new FileOutputStream("日记1.text");
        out.write('A');// 写出了A的低八位
        int g = 1;// write只能写8位，那么写一个int需要4次每次八位
        out.write(g >>> 24);
        out.write(g >>> 16);
        out.write(g >>> 8);
        out.write(g);
        FileInputStream in = new FileInputStream("日记1.text");
        int b;
        int c = 1;
        while ((b = in.read()) != -1) {
            System.out.println(Integer.toHexString(b) + " ");
            if (c++ % 10 == 0) {
                System.out.println();
            }
        }

        // 拷贝文件
        // DataOutputStream/DataInputStream,对“流”功能的扩展，可以更加方便的读取int，龙，字符等类型数据
        // DataOutStream:writeInt()/writeDouble()/writeUTF()(utf-8编码形式的文字）
        DataOutputStream dos = new DataOutputStream(out);// 括号里面的文件必须是outputstream文件
        dos.writeInt(10);
        dos.writeDouble(1.2);
        dos.writeUTF("Chinese");
        DataInputStream dot = new DataInputStream(in);
        System.out.println(dot.readInt());
        System.out.println(dot.readDouble());
        System.out.println(dot.readUTF());
        in.close();
        out.close();
        dot.close();
        dos.close();
        // BufferedInputStream /Bufferedoutputstream（常用于文本文件）这两个流类位IO提供了带缓冲区的操作，
        // 一般打开文件进行写入，或读取操作，都会加上缓冲，这种流模式提高了IO的性能
        // 拷贝文件同上

        // 字符流
        // （1）编码问题（2）认识文本和文本文件，java的文本（char）是16位无符号整数，是字符的unicode编码（双字节编码），
        // 文本是bytebyte byte。。。的数据序列
        // ，文本文件是文本（char）序列按照某种编码方案（utf-8，utf-16，该板块）序列化为byte的存储
        // （3）字符流（Reader Writer）字符的处理，一次处理一个字符，字符的底层任然是基本的字节序列
        // 字符流的基本实现
        // InputStreamReader 完成byte流解析为char流，按照编码解析
        // OutputStreamWriter提供char流到byte流，按照编码处理

        // FileReader/FileWriter

        // 字符流的过滤器 BufferedReader 一次读一行 BufferedWriter/PrintWriter 一次写一行，
        // printWriter新建时较简单，直接在括号里写文件名即可，较推荐使用
        File f3 = new File(demo, "rat.text");
        f3.createNewFile();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f3)));

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);// 一次读一行，并不能识别换行，
            // System.out.print(line);所读的文字全部位于一行

        }
        // 对象的序列化，反序列化(1)对象序列化，就是将Object转换成byte序列，反之叫对象的反序列化
        // （2）序列化流（ObjectOutputStream),是过滤流--writeObject
        // 反序列流（ObjectInputStream）--readObject
        // （3）序列化接口（Serializable）
        // 对象必须实现序列化接口，才能进行序列化，否则将出现异常
        // 这个接口，没有任何方法，只是一个标准

    }

    public static void listFiles(File f) {
        walkDir(f, 0);
    }

    private static void walkDir(File f, int level) {
        if (f.isDirectory()) {

            for (File t : f.listFiles()) {

                walkDir(t, level + 1);
            }
        } else {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("\t");
            }
            System.out.println(f.getName());
        }
    }

    // 拷贝文件
    public static void copyFile(File srcFile, File destFile) throws IOException {
        if (!srcFile.exists()) {
            throw new IllegalArgumentException("文件" + srcFile + "不存在");
        }
        if (!srcFile.isFile()) {
            throw new IllegalArgumentException(srcFile + "不是文件");

        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8 * 1024];
        int a;
        while ((a = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, a);
            out.flush();// 刷新缓冲区，在BukfferedIntputStream中必须写，此处可以不必写
        }
        in.close();
        out.close();
    }

}