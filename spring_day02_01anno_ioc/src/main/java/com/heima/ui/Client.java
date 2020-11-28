package com.heima.ui;

import com.heima.dao.IAccountDao;
import com.heima.service.IAccountService;
import com.heima.service.impl.AccountServiceImpl;
import com.sun.xml.internal.bind.v2.util.XmlFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 *
 * 曾经的xml的配置：
 * <bean id="accountService" class="com.heima.service.impl.AccountServiceImpl"
 *     scope="" init-method="" destory_method="">
 *     <property name="" value=""|ref=""></property>
 * </bean>
 *
 * 用于创建对象的
 *      他们的作用就和在xml配置文件中编写一个<bean>标签实现的功能是一样的
 *      Component:
 *          作用：把当前类对象存入spring容器中
 *          属性：value：用于指定bean的id。当我们不写时，他的默认值是当前类名，且首字母改小写
 *      Controller：一般用于表现层
 *      Service：一般用在业务层
 *      Repository：一般用于持久层
 *      以上三个注解他们的作用和属性与component是一模一样的。
 *      他们三个是spring框架为我们提供明确的三层使用的注解，使我们的三层对象更加清晰
 *
 * 用于注入数据的
 *      他们的作用就和在xml配置文件中的bean标签中写一个<property>标签的作用的是一样的
 *      Autowired:
 *          作用：自动按照类型注入。只要容器中有唯一的一个bean对象类型和要注入的变量类型匹配，就可以注入成功
 *              如果ioc容器中没有任何bean的类型和要注入的变量类型匹配，则报错。
 *              如果Ioc容器中有多个类型匹配时：看变量名和配置的value值（id）是否有相同，有相同的则注入该类型，否则报错。
 *          出现位置：
 *              可以是变量上，也可以是方法上
 *      Qualifier：
 *          作用：在按照类注入的基础之上再按照名称注入。他在给类成员注入时不能单独使用。但是在给方法参数注入时可以（稍后讲）
 *          给类成员注入时要和@Autowired一起用
 *          属性：
 *              value：用于指定bean的id
 *      Resource:
 *          作用：直接按照bean的id注入。它可以独立使用
 *          属性：
 *              name：用于指定bean的id。
 *      以上三个注入都只能注入其他bean类型的数据，而基本类型和String类型无法使用上述注解实现。
 *      另外，集合类型的注入只能通过XML来实现。
 *
 *      Value：
 *          作用：用于注入基本类型和String类型的数据
 *          属性：
 *              value：用于指定数据的值。它可以使用spring中SpEL（也就是spring的el表达式）
 *                  SpEL的写法：${表达式}
 * 用于改变作用范围的
 *      他们的作用就和在<bean>标签中使用scope属性实现的功能是一样的
 *      Scope:
 *          作用：用于指定bean的作用范围
 *          属性：
 *              value：指定范围的取值。常用取值：singleton、prototype
 * 和生命周期相关(了解)
 *      他们的作用就和在bean标签中使用init-method和destory-method的作用是一样的
 *      PreDestroy：
 *          作用：用于指定销毁方法
 *      PostConstruct
 *          作用：用于指定初始化方法
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // 2.根据id获取Bean对象的两种方式
        IAccountService as = (IAccountService)ac.getBean("accountService");
//        IAccountService as2 = (IAccountService)ac.getBean("accountService");
//        System.out.println(as);
//        System.out.println( as == as2);
        /*IAccountDao adao = ac.getBean("accountDao",IAccountDao.class);
        System.out.println(adao);*/
        as.saveAccount();
        ac.close();
    }
}
