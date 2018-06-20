package com.ruijie.greendaotest.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by panruijie on 2018/6/20.
 *
 * // Flag to make an entity "active": Active entities have update,
 // delete, and refresh methods.
 active = true,

 // Specifies the name of the table in the database.
 // By default, the name is based on the entities class name.
 nameInDb = "AWESOME_USERS",

 */
@Entity(nameInDb = "user")
public class User {

    @Id(autoincrement = true)
    private Long mUserId; //主键必须为long/Long
    @NotNull
    @Property(nameInDb = "age")
    private Integer mAge;
    private String mName;
    @Generated(hash = 1515993321)
    public User(Long mUserId, @NotNull Integer mAge, String mName) {
        this.mUserId = mUserId;
        this.mAge = mAge;
        this.mName = mName;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getMUserId() {
        return this.mUserId;
    }
    public void setMUserId(Long mUserId) {
        this.mUserId = mUserId;
    }
    public Integer getMAge() {
        return this.mAge;
    }
    public void setMAge(Integer mAge) {
        this.mAge = mAge;
    }
    public String getMName() {
        return this.mName;
    }
    public void setMName(String mName) {
        this.mName = mName;
    }




}
