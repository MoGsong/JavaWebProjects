package com.gxlq.controller;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import com.gxlq.entity.Operator;
import com.gxlq.view.UI;

/**
 * ???????
 *
 * @author Administrator
 */
public class AllController {
    public static void main(String[] args) throws UnsupportedEncodingException {
        UI.show1();
        UI.show2();
        Operator op = OperatorController.Login();
        do {
            //UI.show3();
            UI.show4(op);
            Scanner scan = new Scanner(System.in);
            System.out.println("��������Ҫ�����Ĳ˵�ѡ��:");
            String input = scan.next();
            if ("��Ӳ˵�".equals(input)) {
                MenuController.addMenu();
            } else if ("ɾ���˵�".equals(input)) {
                MenuController.deleteMenu();
            } else if ("�޸Ĳ˵�".equals(input)) {
                MenuController.updateMenu();
            } else if ("Ȩ�޹���".equals(input)) {
                AuthorizationController.update();
            } else if ("�˳�".equals(input)) {
                scan.close();
                System.exit(0);
            } else {
                System.out.println("�ù��ܻ��ڽ�����......");
            }
        } while (true);
    }

}
