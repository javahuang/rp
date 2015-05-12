//
package org.springframework.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.Lifecycle;
import org.springframework.core.env.Environment;
import org.springframework.test.bean.LifecycleBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * <p/>
 * <p>User: Huang rp
 * <p>Date: 2015年4月10日 下午9:35:02
 * <p>Version: 1.0
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:util-context/test-context.xml")
public class LifecycleBeanTest {

    @Autowired
    LifecycleBean bean;

    Lifecycle appContextLifeCycle;

    @Autowired
    Environment env;
    	
    @Autowired
    public void setLifeCycle(ApplicationContext context){
        this.appContextLifeCycle = (Lifecycle)context;
    }

    //@Test
    public void testLifeCycle(){
        //"start" application context
        appContextLifeCycle.start();

        bean.waitForTermination();
    }
}