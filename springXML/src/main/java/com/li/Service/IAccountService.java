package com.li.Service;

import com.li.domain.Account;

import java.sql.SQLException;
import java.util.List;


public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws SQLException;

    /**
     * 查询一个
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param
     */
    void deleteAccount(Integer accountId);
}
