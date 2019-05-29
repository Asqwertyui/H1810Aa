package com.ks.day02green;

import com.ks.day02green.dao.BeanDao;
import com.ks.day02green.dao.DaoMaster;
import com.ks.day02green.dao.DaoSession;

import java.util.List;

/**
 * Created by F0519 on 2019/5/29.
 */

public class Dbheap  {
    private static Dbheap dbheap;
    private final BeanDao mBeanDao;

    private Dbheap() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(App.getApp(), "cc.db");
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        DaoSession session = daoMaster.newSession();
        mBeanDao = session.getBeanDao();

    }

    public static Dbheap getDbheap() {
        if(dbheap==null){
            synchronized (Dbheap.class){
                if(dbheap==null){
                    dbheap=new Dbheap();
                }
            }
        }
        return dbheap;
    }
    public void insert(Bean bean){
        mBeanDao.insertOrReplaceInTx(bean);
    }
    public boolean has(Bean bean){
        List<Bean> list = mBeanDao.queryBuilder().where(BeanDao.Properties.Name.eq(bean.getName())).list();
        if(list!=null&&list.size()>0){
            return true;
        }
        return false;
    }
    public List<Bean> queryAll(){
        List<Bean> list = mBeanDao.queryBuilder().list();
        return list;
    }
}
