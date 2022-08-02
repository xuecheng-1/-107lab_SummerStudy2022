package com.itheima.string;

public class StringDemo3 {
    public static void main(String[] args) {

//        1.public int length():字符串的长度
        String name = "我爱你love";
        System.out.println(name.length());

//        2.public char charAt(int index):获取某索引位置的字符
        char c = name.charAt(1);
        System.out.println(c);
//fori遍历
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            System.out.println(ch);
        }
//        3.public char[] toCharArray():将字符串转换成字符数组
        char[] chars = name.toCharArray();
//        chars.fori
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            System.out.println(ch);
        }
//        4.public String substring(int beginIndex,int endIndex):左闭右开
        String name2 = "java是最nb的编程语言";
        System.out.println(name2.substring(0, 8));
//        5.public String substring(int beginIndex);从当前截取到末尾
        String rs = name2.substring(9);
//        6.public String replace(CharSequence target,CharSequence replacement)
//        返回一个新字符串（替换后）
        String name3 = "金三胖是哈哈哈，金三胖零零，交金三胖";
        String rs2 = name3.replace("金三胖","***");
        System.out.println(rs2);

//        7.public boolean contains(CharSequence s)
        System.out.println(name3.contains("金三胖"));

//        8.public boolean startWith(String prefix)
        System.out.println(name3.startsWith("金"));
        System.out.println(name3.startsWith("金三胖"));
//        9.public String[] split(String s):按照某个内容把字符串分割成字符数组返回
        String name4 = "王宝强，贾乃亮，陈羽凡";
        String[] names = name4.split("，");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
