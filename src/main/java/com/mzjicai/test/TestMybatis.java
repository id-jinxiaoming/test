package com.mzjicai.test;

import com.mzjicai.dao.AccountDao;
import com.mzjicai.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run1() throws IOException {
        Account account =new Account();
        account.setName("HAHAH");
        account.setMoney(200d);
        // 加载配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        SqlSession session = factory.openSession();

        AccountDao accountDao = session.getMapper(AccountDao.class);

        // 保存
        accountDao.saveAccount(account);

        // 提交事务
        session.commit();

        // 关闭资源
        session.close();
        in.close();
    }

    @Test
    public void run2() throws Exception {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);

        SqlSession session = factory.openSession();

        AccountDao dao = session.getMapper(AccountDao.class);

        List<Account> list = dao.findAll();
        for (Account account: list ) {
            System.out.println(account);
        }

        session.close();
        in.close();
    }

}
