package com.ruijie.greendaotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ruijie.greendaotest.greendao.bean.Address;
import com.ruijie.greendaotest.greendao.bean.User;
import com.ruijie.greendaotest.greendao.gen.AddressDao;
import com.ruijie.greendaotest.greendao.gen.UserDao;
import com.ruijie.greendaotest.manager.DBManager;

import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

import java.util.List;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDao userDao = DBManager.getInstance().getDaoSession().getUserDao();

        User user = new User();
        user.setMAge(18);
        user.setMName("Gomo");

        //插入
        userDao.insert(user);
        //删除
        userDao.delete(user);
        //查询是否存在
        userDao.hasKey(user);
        //更新
        userDao.update(user);

        //条件查询
        QueryBuilder queryBuilder = userDao.queryBuilder();
        queryBuilder.where(UserDao.Properties.MAge.eq("Gomo"))
                .orderAsc(UserDao.Properties.MName)
                .list();

        //First name is “ruijie” AND (age is greater than 15 OR (age is 18 AND id is equal to 1).
        QueryBuilder qb = userDao.queryBuilder();
        qb.where(UserDao.Properties.MName.eq("ruijie"),
                qb.or(UserDao.Properties.MAge.gt(15),
                        qb.and(UserDao.Properties.MAge.eq(18),
                                UserDao.Properties.MUserId.eq(1))));
        List userList = qb.list();

        //sql查询
        Query query = userDao.queryBuilder().where(
                new WhereCondition.StringCondition("select user_id from user where age = 18")).build();

        //连表查询
        QueryBuilder<User> joinQb = userDao.queryBuilder();
        joinQb.join(Address.class, AddressDao.Properties.MAddressId)
                .where(AddressDao.Properties.MStreet.eq("Zhong Shan San Lu"));
        List<User> joinUserList = queryBuilder.list();


    }
}
