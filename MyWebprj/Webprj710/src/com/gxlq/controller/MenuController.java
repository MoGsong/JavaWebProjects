package com.gxlq.controller;

import java.util.Scanner;

import com.gxlq.entity.Menu;
import com.gxlq.service.IMenuService;
import com.gxlq.service.imp.MenuService;

/**
 * ??????????��????????
 *
 * @author Administrator
 */

public class MenuController {
    //?????
    public static void addMenu() {
        IMenuService ims = new MenuService();
        //???????????��??
        Menu[] fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "��" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????????
        Scanner sc = new Scanner(System.in);
        System.out.println("��������ӵĲ˵����(0�Ǹ��˵�):");
        int parent = sc.nextInt();

        System.out.println("����������ӵĲ˵���:");
        String name = sc.next();

        System.out.println("����������ӵĲ˵���url:");
        String url = sc.next();

        Menu menu = new Menu(name, parent, url);
        ims.add(menu);
        System.out.println("��Ӳ˵��ɹ�");
    }

    //??????
    public static void deleteMenu() {
        IMenuService ims;
        ims = new MenuService();
        //???????????��??
        Menu[] fathers;
        fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "��" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫɾ���Ĳ˵����:");
        int id = sc.nextInt();
        ims.remove(id);
        System.out.println("ɾ���ɹ�");

    }

    //?????
    public static void updateMenu() {
        IMenuService ims = new MenuService();
        //???????????��??
        Menu[] fathers = ims.find();
        StringBuffer msg = new StringBuffer();
        for (Menu father : fathers) {
            msg.append(father.getId() + "��" + father.getName() + "\t");
        }
        System.out.println(msg);
        //??????????????
        Scanner sc = new Scanner(System.in);
        System.out.println("�������޸ĵĲ˵����:");
        int id = sc.nextInt();

        System.out.println("�޸ĺ�ĸ��˵����:");
        int parent = sc.nextInt();

        System.out.println("�޸ĺ�Ĳ˵���:");
        String name = sc.next();

        System.out.println("�޸ĺ�Ĳ˵�url:");
        String url = sc.next();

        Menu menu = new Menu(id, name, parent, url);
        ims.update(menu);
        System.out.println("�޸ĳɹ�");
    }
}
