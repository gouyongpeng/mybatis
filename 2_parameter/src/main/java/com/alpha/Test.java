/***********************
 * 关注点：mybatis使用的基本套路
 * 1、session：构建者模式，读取mybatis配置文件
 * 2、Mapper：XML文件和接口文件，mybatis自动生成实现类
 * ***********************/

package com.alpha;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Test {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory = MybatisUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TodoMapper mapper = sqlSession.getMapper(TodoMapper.class);
        Backlog backlog = mapper.getById(2L);
        System.out.println(backlog.getTitle());
        System.out.println(backlog.getDescription());
        System.out.println(backlog.getDueTime());
        System.out.println(backlog.getPath());
        System.out.println(backlog.getState());
        /*Set<Backlog> allPendings = mapper.getAllPendings();
        allPendings.forEach(backlog -> {
            System.out.println(backlog.getTitle());
        });*/
        sqlSession.close();
    }
}
