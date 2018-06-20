package com.ruijie.greendaotest.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by panruijie on 2018/6/20.
 */
@Entity
public class Address {

    @Id(autoincrement = true)
    private Long mAddressId;
    private String mStreet;
    @Generated(hash = 1284108377)
    public Address(Long mAddressId, String mStreet) {
        this.mAddressId = mAddressId;
        this.mStreet = mStreet;
    }
    @Generated(hash = 388317431)
    public Address() {
    }
    public Long getMAddressId() {
        return this.mAddressId;
    }
    public void setMAddressId(Long mAddressId) {
        this.mAddressId = mAddressId;
    }
    public String getMStreet() {
        return this.mStreet;
    }
    public void setMStreet(String mStreet) {
        this.mStreet = mStreet;
    }

}
