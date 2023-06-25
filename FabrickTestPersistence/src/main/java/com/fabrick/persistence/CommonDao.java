package com.fabrick.persistence;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommonDao {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    protected SqlSession sqlSession;

    @Autowired
    public void setDataSource(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


}