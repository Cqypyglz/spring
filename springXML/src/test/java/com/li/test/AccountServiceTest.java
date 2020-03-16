package com.li.test;

import com.li.Service.IAccountService;
import com.li.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class AccountServiceTest {

    @Test
    public void findAllTest(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("Bean.xml");
        IAccountService as = ac.getBean("accountService", IAccountService.class);
        try {
            List<Account> allAccount = as.findAllAccount();
            allAccount.forEach(account -> System.out.println(account));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testFindOne(){
        //1.获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //2.得到业务层对象
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        //3.执行方法
        Account account=as.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testSave(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as=ac.getBean("accountService",IAccountService.class);
        Account account =new Account();
        account.setMoney(200f);
        account.setName("DD");
        as.saveAccount(account);

    }
    @Test
    public void testUpdate(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as =ac.getBean("accountService",IAccountService.class);
        Account account =new Account();
        account.setId(4);
        account.setMoney(2000f);
        account.setName("test");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        IAccountService as =ac.getBean("accountService",IAccountService.class);
        as.deleteAccount(4);
    }
}
