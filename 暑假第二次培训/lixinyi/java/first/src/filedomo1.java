import java.io.*;

public class filedomo1 {
    /*
    * file:文件；
    * directory:文件夹、目录；
    * path:路径；
    * String pathSeparator
    * char pathSeparatorChar
    * String Separator
    * char SeparatorChar
    * */


    public static void main(String[] args) {
        //file类的构造方法
        try {
            byte bWrite[] = { 11, 21, 3, 40, 5 };
            OutputStream os = new FileOutputStream("test.txt");
            for (int x = 0; x < bWrite.length; x++) {
                os.write(bWrite[x]); // writes the bytes
            }
            os.close();

            InputStream is = new FileInputStream("test.txt");
            int size = is.available();

            for (int i = 0; i < size; i++) {
                System.out.print((char) is.read() + "  ");
            }
            is.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }




}
