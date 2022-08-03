package com.atguigu.fruit.view;

import com.atguigu.fruit.controller.Menu;

import java.sql.SQLException;

public class Client {

    public static void main(String[] args) throws SQLException {
                boolean flag = true;
                while (flag){
                    //调用显示主菜单方法
                    Menu m =new Menu();
                    int slt = m.showMainMenu();
                    switch(slt){
                        case 1:
                            //显示库存列表
                            m.showFruitList();

                            break;

                        case 2:
                            m.addFruit();
                            break;
                        case 3:
                            m.shouFruitInfo();
                            break;
                        case 4:
                    m.delFruit();
                    break;
                case 5:
                flag = m.exit();
                    break;
                default:
                    System.out.println("youaresilly");
                    break;
            }

        }
        System.out.println("谢谢使用再见!");
    }

}
