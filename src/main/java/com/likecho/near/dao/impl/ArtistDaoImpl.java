package com.likecho.near.dao.impl;

import com.likecho.near.dao.ArtistDao;
import com.likecho.near.dao.SongMapper;
import com.likecho.near.model.Artist;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

public class ArtistDaoImpl implements ArtistDao {
    SqlSessionFactory sqlSessionFactory;

    public ArtistDaoImpl(DataSource dataSource) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SongMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public List<Artist> getAllArtist() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList("com.likecho.near.dao.ArtistMapper.getAllArtist");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Artist getArtist() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Artist result = sqlSession.selectOne("com.likecho.near.dao.ArtistMapper.getArtist");
            return result;
        } finally {
            sqlSession.close();
        }
    }
}
