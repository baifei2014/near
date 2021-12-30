package com.likecho.near.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.likecho.near.InitException;
import com.likecho.near.common.PropertyFactory;
import com.likecho.near.dao.SongDao;
import com.likecho.near.dao.impl.SongDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

@Service("SongService")
public class SongService {
    private Logger logger = LoggerFactory.getLogger(PositionService.class);
    DruidDataSource dataSource;
    SongDao dao;
    public SongService() throws SQLException, InitException {
        Properties properties = PropertyFactory.getProperties();
        dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getProperty(Constants.NEAR_JDBC_URL));
        dataSource.setUsername(properties.getProperty(Constants.NEAR_JDBC_USERNAME));
        dataSource.setPassword(properties.getProperty(Constants.NEAR_JDBC_PASSWORD));
        dataSource.init();
        dao = new SongDaoImpl(dataSource);
    }

    public List getAllSong() {
        return dao.getAllSong();
    }
}
