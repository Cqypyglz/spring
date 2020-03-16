package com.li.Service.impl;

import com.li.Service.IAccountService;
import com.li.dao.IAccountDao;
import com.li.dao.impl.AccountDaoImpl;
import com.li.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


@Service
public class AccountServiceImpl implements IAccountService {


  private IAccountDao accountDao;


  public void setAccountDao(IAccountDao accountDao) {
    this.accountDao = accountDao;
  }

  /**
   * 查询所有
   *
   * @return
   */
  public List<Account> findAllAccount() throws SQLException {
    return accountDao.findAllAccount();
  }

  /**
   * 查询一个
   *
   * @param accountId
   * @return
   */
  public Account findAccountById(Integer accountId) {
    return accountDao.findAccountById(accountId);
  }

  /**
   * 保存
   *
   * @param account
   */
  public void saveAccount(Account account) {
    accountDao.saveAccount(account);
  }

  /**
   * 更新
   *
   * @param account
   */
  public void updateAccount(Account account) {
          accountDao.updateAccount(account);
  }

  /**
   * 删除
   *
   * @param
   */
  public void deleteAccount(Integer accountId) {
       accountDao.deleteAccount(accountId);
  }
}
