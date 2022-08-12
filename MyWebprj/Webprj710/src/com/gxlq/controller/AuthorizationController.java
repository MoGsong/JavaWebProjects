package com.gxlq.controller;
import java.util.Scanner;
import com.gxlq.entity.Authorization;
import com.gxlq.entity.Menu;
import com.gxlq.entity.Role;
import com.gxlq.service.IAuthorizationService;
import com.gxlq.service.IMenuService;
import com.gxlq.service.IRoleService;
import com.gxlq.service.imp.AuthorizationService;
import com.gxlq.service.imp.MenuService;
import com.gxlq.service.imp.RoleService;

/**
 * Ȩ�޿�����
 * @author johny
 * �ֿ�
 */
public class AuthorizationController {
    //Ȩ�޵��ȣ����޸�Ȩ��
    public static  void update() {
        //����ҵ�񷽷�����ʾ���н�ɫ,citing service method to display all roles
        IRoleService irs = new RoleService();
        //findAll roles data
        Role[] roles = irs.find();
        //output roles id and name
        StringBuffer msg = new StringBuffer("");
        for (Role role : roles) {
            msg.append(role.getId()+"��"+role.getName()+"\t");
        }
        System.out.println(msg);
        //input roleId to select authorization info by findByRole() method order to alert authorities
        Scanner sc = new Scanner(System.in);
        System.out.println("�������ɫ��ţ�");
        int roleid = sc.nextInt();

        System.out.println("���������Ȩ�޵��ȵĲ������͡�ɾ��Ȩ��|���Ȩ�ޡ���");
        String op = sc.next();
        if("ɾ��Ȩ��".equals(op)) {
            //��ǰ��ɫ�Ѿ�ӵ��Ȩ�޷��ʵĲ˵���Ϣ����ѯȨ�ޱ�
            IAuthorizationService ias = new AuthorizationService();
            Authorization[] authorizations = ias.findByRole(roleid);  //authorization[]:{roleId,menu}
            StringBuffer msg3 = new StringBuffer("");
            for(Authorization au:authorizations) {
                msg3.append(au.getMenu().getId()+"��"+au.getMenu().getName()+"\t");
            }
            System.out.println(msg3);
            System.out.println("������Ҫ����Ȩ�޵Ĳ˵���ţ�");
            int menuid = sc.nextInt();  //4

            //����ҵ�񷽷�����Ȩ�ޱ���ɾ��һ����¼
            //��ʾ����Ȩ����Ϣ��ѭ��ÿ��Ȩ����Ϣ�����뵱ǰ��ɫ�Ͳ˵�ƥ���Ȩ����Ϣ��������ɾ��
            authorizations = ias.find(); //{1,1,8  1,1,9}
            for (Authorization au : authorizations) {
                if(au.getMenu().getId()==menuid && au.getRole().getId()==roleid) {
                    ias.remove(au.getId());
                }
            }
            System.out.println("�����ɹ���");
        }else if("���Ȩ��".equals(op)) {
            //��ʾ���е�ǰ��ɫ��δӵ��Ȩ�޷��ʵĲ˵���Ϣ
            //��ѯ���в˵�
            IMenuService ims = new MenuService();
            Menu[] menus = ims.find();  //{id=1,2,3,4,5,6,7,8,9}
            //��ǰ��ɫ�Ѿ�ӵ��Ȩ�޷��ʵĲ˵���Ϣ����ѯȨ�ޱ�
            IAuthorizationService ias = new AuthorizationService();
            //role data  of authorization table
            Authorization[] authorizations = ias.findByRole(roleid);  //{3,8   3,9}
            //use StringBuffer to improve jvm efficiency
            StringBuffer msg2 = new StringBuffer("");
            //����menus���飬��ĳ��Ԫ����authorizations�����е�����Ԫ�ؽ��бȽϣ���������ȣ����ʾ�ò˵��ǵ�ǰ��ɫ��û��Ȩ�޷��ʵĲ˵�
            for(Menu menu:menus) {
                //��ʶ������ͨ������ʼֵ��ͨ����ֵ�Ƿ񱻸��ģ����ж�ĳ������Ƭ���Ƿ�ִ�й�
                boolean flag = false;
                for(Authorization au:authorizations) {
                    //���Ѿ�ӵ�иò˵���Ӧ�ķ���Ȩ�ޣ������ѭ����ͨ��break���Ƽ���ѭ���Ĵ������������
                    if(menu.getId()==au.getMenu().getId()) { //8,9
                        flag = true;
                        break;
                    }
                }
                //if(flag==false) {
                if(!flag) {
                    msg2.append(menu.getId()+"��"+menu.getName()+"|");
                }
            }

            System.out.println(msg2);
            System.out.println("������Ҫ����Ȩ�޵Ĳ˵���ţ�");
            int menuid = sc.nextInt();  //4
            //����ҵ�񷽷�����Ȩ�ޱ������һ����¼,only input one have roleId and menuId in an authorization
            Role role =new Role(); //{id=0,name=null}
            role.setId(roleid);     //{id=3,name=null}
            Menu menu = new Menu();//{id=0,name=null,parent=}
            menu.setId(menuid);//{id=4,name=null,parent=}
            Authorization  authorization = new Authorization(role,menu);
            ias.add(authorization);

            System.out.println("��Ȩ�ɹ���");

        }else {
            System.out.println("��������");
        }
        System.out.println("Ȩ�޵�����ɣ�");
    }
}
