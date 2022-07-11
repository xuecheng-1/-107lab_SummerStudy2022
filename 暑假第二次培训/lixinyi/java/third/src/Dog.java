public class Dog {
    String type;
    String name;
    int age;
    float weight;

    public static void main(String[] args) {
        Dog jinzi = new Dog();
        jinzi.name = "金子";
        jinzi.type = "金毛";
        jinzi.age = 2;
        jinzi.weight = 10.2f;
        Dog halilu = new Dog();
        halilu.name = "哈里鹿";
        halilu.type = "哈士奇";
        halilu.age = 10;
        halilu.weight = 12.3f;
        System.out.println(jinzi.name + "是一只" + jinzi.age + "岁的" + jinzi.type);
        System.out.println(halilu.name + "是一只" + halilu.age + "岁的" + halilu.type);
    }
}
