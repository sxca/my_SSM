package com.heima.ui;

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
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // 1.获取核心容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        // ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\Administrator\\Desktop\\bean.xml");
//         2.根据id获取Bean对象的两种方式
        IAccountService as = (IAccountService)ac.getBean("accountService");
        as.saveAccount();
        ac.close();

        //--------------BeanFactory----------------
//        Resource resource = new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        IAccountService as = (IAccountService)factory.getBean("accountService");
    }
}
