package com.likecho.near.dao.impl;

import com.likecho.near.dao.AlbumDao;
import com.likecho.near.dao.SongDao;
import com.likecho.near.dao.SongMapper;
import com.likecho.near.model.Album;
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

public class AlbumDaoImpl implements AlbumDao {
    SqlSessionFactory sqlSessionFactory;

    public AlbumDaoImpl(DataSource dataSource) {
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SongMapper.class);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    }

    @Override
    public List<Album> getAllAlbum() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            return sqlSession.selectList("com.likecho.near.dao.AlbumMapper.getAllAlbum");
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public Album getAlbum() {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        try {
            Album result = sqlSession.selectOne("com.likecho.near.dao.AlbumMapper.getAlbum");
            return result;
        } finally {
            sqlSession.close();
        }
    }
}
