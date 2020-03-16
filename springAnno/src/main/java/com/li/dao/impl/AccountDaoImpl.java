package com.li.dao.impl;

import com.li.dao.IAccountDao;
import com.li.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;


    /**
     * 查询所有
     *
     * @return
     */
    public List<Account> findAllAccount() {
        String sql="select * from account";
        try {
            return runner.query(sql,new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询一个
     *
     * @param accountId
     * @return
     */
    public Account findAccountById(Integer accountId) {
        String sql ="select * from account where id=?";
        try {
            return runner.query(sql,new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存
     *
     * @param account
     */
    public void saveAccount(Account account) {
        String sql ="insert into account(name,money) values(?,?)";
        try {
            runner.update(sql,account.getName(),account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新
     *
     * @param account
     */
    public void updateAccount(Account account) {
          String sql ="update account set name=?,money=? where id=?";
        try {
            runner.update(sql,account.getName(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除
     *
     * @param
     */
    public void deleteAccount(Integer accountId) {
          String sql ="delete from account where id=?";
        try {
            runner.update(sql,accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
