package com.likecho.near.service;

import com.alibaba.druid.pool.DruidDataSource;
import com.likecho.near.Constants;
import com.likecho.near.InitException;
import com.likecho.near.common.PropertyFactory;
import com.likecho.near.dao.PoiDao;
import com.likecho.near.dao.impl.PoiDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Properties;

@Service("PositionService")
public class PositionService {
    private Logger logger = LoggerFactory.getLogger(PositionService.class);
    DruidDataSource dataSource;
    public PositionService() throws SQLException, InitException {
        Properties properties = PropertyFactory.getProperties();
        dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getProperty(Constants.NEAR_JDBC_URL));
        dataSource.setUsername(properties.getProperty(Constants.NEAR_JDBC_USERNAME));
        dataSource.setPassword(properties.getProperty(Constants.NEAR_JDBC_PASSWORD));
        dataSource.init();
        PoiDao dao = new PoiDaoImpl(dataSource);
    }
}
