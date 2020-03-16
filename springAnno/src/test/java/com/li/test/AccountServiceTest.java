package com.li.test;

import com.li.Service.IAccountService;
import com.li.config.SpringConfiguration;
import com.li.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {
    @Autowired
    private IAccountService as=null;
    @Test
    public void findAllTest(){
               try {
            List<Account> allAccount = as.findAllAccount();
            allAccount.forEach(account -> System.out.println(account));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testFindOne(){
          //3.执行方法
        Account account=as.findAccountById(2);
        System.out.println(account);
    }
    @Test
    public void testSave(){
         Account account =new Account();
        account.setMoney(200f);
        account.setName("DD");
        as.saveAccount(account);

    }
    @Test
    public void testUpdate(){
      Account account =new Account();
        account.setId(4);
        account.setMoney(2000f);
        account.setName("test");
        as.updateAccount(account);
    }
    @Test
    public void testDelete(){
        as.deleteAccount(4);
    }
}
