package com.likecho.near.dao.impl;

import com.likecho.near.dao.PoiDao;
import com.likecho.near.dao.PoiMapper;
import com.likecho.near.model.Poi;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

public class PoiDaoImpl implements PoiDao {
    SqlSessionFactory sqlSessionFactory;

    public PoiDaoImpl(DataSource dataSource) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(PoiMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public List<Poi> getAllPoi() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList("com.likecho.near.dao.PoiMapper.getAllPoi");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Poi getPoi() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Poi result = sqlSession.selectOne("com.likecho.near.dao.PoiMapper.getPoi");
            return result;
        } finally {
            sqlSession.close();
        }
    }
}
