public class Sushu {
  public String issushu (int n){
      System.out.println(n);
      int f=1;
      if(n==2)return "是素数";
      else{
          for(int i=2;i<n;i++){
              if(n%i==0)
              {
                  f=0;
                  i=n;
                  return "不是素数";

              }
          }
          if(f==1) return "是素数";
      }

      return null;
  }
    public static void main(String[] args) {
        int b=2;
        Sushu a=new Sushu();//创建一个素数类
        System.out.println(a.issushu(b));

    }

}
