package com.util.sql;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.database.DatabaseMeta;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.repository.RepositoryDirectoryInterface;
import org.pentaho.di.repository.kdr.KettleDatabaseRepository;
import org.pentaho.di.repository.kdr.KettleDatabaseRepositoryMeta;

/**
 * Created by 31767 on 2017/8/16.
 */
public class KettleEnvironments {
    public  static KettleDatabaseRepository repository;
    public  static DatabaseMeta databaseMeta;
    public  static KettleDatabaseRepositoryMeta kettleDatabaseMeta;
    public  static RepositoryDirectoryInterface directory;
    /*
     * KETTLE初始化*/
    public static  String  KettleEnvironments() {
        try {
            KettleEnvironment.init();repository = new KettleDatabaseRepository();
            databaseMeta = new DatabaseMeta("ETL", "mysql", "Native", "192.168.2.240","mysql", "3306",
                    "root", "root");//资源库数据库地址，我这里采用oracle数据库
            kettleDatabaseMeta = new KettleDatabaseRepositoryMeta("ETL", "ERP",
                    "Transformation description", databaseMeta);
            repository.init(kettleDatabaseMeta);
            repository.connect("admin", "admin");//资源库用户名和密码
            directory = repository.loadRepositoryDirectoryTree();
        } catch (KettleException e) {
            e.printStackTrace();
            return  e.getMessage();
        }
        return null;
    }

}
