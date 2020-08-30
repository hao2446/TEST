package test;

import dao.IUserDao;
import domin.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //第一步，读取配置文件
        InputStream in =Resources.class.getResourceAsStream("/SqlMapConfig.xml");
        //第二部，创建SqlSessionFactory工厂，
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //第三步，使用工厂生产SqlSession对象
        SqlSession session=factory.openSession();
        //第四步，使用SqlSession的代理对象
        IUserDao userDao= session.getMapper(IUserDao.class);
        //第五步，使用代理对象执行方法
        List<User> users=userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //第六步，释放资源
        session.close();

    }
}
