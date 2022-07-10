if(布尔表达式)
{
   //如果布尔表达式为true将执行的语句
}
public class Test {
 
    public static void main(String args[]){
       int x = 10;
  
       if( x < 20 ){
          System.out.print("这是 if 语句");
       }
    }
 }
 if(布尔表达式){
    //如果布尔表达式的值为true
 }else{
    //如果布尔表达式的值为false
 }
 public class Test {
 
    public static void main(String args[]){
       int x = 30;
  
       if( x < 20 ){
          System.out.print("这是 if 语句");
       }else{
          System.out.print("这是 else 语句");
       }
    }
 }
 public class Test {
    public static void main(String args[]){
       int x = 30;
  
       if( x == 10 ){
          System.out.print("Value of X is 10");
       }else if( x == 20 ){
          System.out.print("Value of X is 20");
       }else if( x == 30 ){
          System.out.print("Value of X is 30");
       }else{
          System.out.print("这是 else 语句");
       }
    }
 }