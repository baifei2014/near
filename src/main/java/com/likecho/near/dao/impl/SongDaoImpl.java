package com.likecho.near.dao.impl;

import com.likecho.near.dao.SongDao;
import com.likecho.near.dao.SongMapper;
import com.likecho.near.model.Song;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.util.List;

public class SongDaoImpl implements SongDao {
    SqlSessionFactory sqlSessionFactory;

    public SongDaoImpl(DataSource dataSource) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SongMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public List<Song> getAllSong() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList("com.likecho.near.dao.SongMapper.getAllSong");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Song getSong() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Song result = sqlSession.selectOne("com.likecho.near.dao.SongMapper.getSong");
            return result;
        } finally {
            sqlSession.close();
        }
    }
}
