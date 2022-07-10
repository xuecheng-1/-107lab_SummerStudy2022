public class ClassName {
   // ...
   }
   private boolean myFlag;
   static final double weeks = 9.5;
   protected static final int BOXWIDTH = 42;

   public static void main(String[] arguments) {
      // 方法体
   }

   String version = "1.5.1";

   boolean processOrder() {
      return true;
   }

   public class Logger {
      private String format;

      public String getFormat() {
         return this.format;
      }

      public void setFormat(String format) {
         this.format = format;
      }
   }

   class AudioPlayer {
      protected boolean openSpeaker(Speaker sp) {
         // 实现细节
      }
   }

   class StreamingAudioPlayer extends AudioPlayer {
      protected boolean openSpeaker(Speaker sp) {
         // 实现细节
      }
   }

   public class InstanceCounter {
      private static int numInstances = 0;

      protected static int getCount() {
         return numInstances;
      }

      private static void addInstance() {
         numInstances++;
      }

      InstanceCounter() {
         InstanceCounter.addInstance();
      }

      public static void main(String[] arguments) {
         System.out.println("Starting with " +
               InstanceCounter.getCount() + " instances");
         for (int i = 0; i < 500; ++i) {
            new InstanceCounter();
         }
         System.out.println("Created " +
               InstanceCounter.getCount() + " instances");
      }
   }

   public class Test {
      final int value = 10;
      // 下面是声明常量的实例
      public static final int BOXWIDTH = 6;
      static final String TITLE = "Manager";

      public void changeValue() {
         value = 12; // 将输出一个错误
      }
   }

   abstract class Caravan {
      private double price;
      private String model;
      private String year;

      public abstract void goFast(); // 抽象方法

      public abstract void changeColor();
   }

   public abstract class SuperClass {
      abstract void m(); // 抽象方法
   }

   class SubClass extends SuperClass {
      // 实现抽象方法
      void m(){
          .........
      }
   }

public class MyRunnable implements Runnable
{
    private volatile boolean active;
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}