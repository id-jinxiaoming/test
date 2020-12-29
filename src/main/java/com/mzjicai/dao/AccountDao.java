package com.mzjicai.dao;

import com.mzjicai.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //此注解代表这是一个持久层(DAO)，用法类似@controller、@service
public interface AccountDao {

    @Select("SELECT * FROM ACCOUNT")
    List<Account> findAll();

    @Insert("insert into account (name,money) value(#{name},#{money})")
    void saveAccount(Account account);
}
