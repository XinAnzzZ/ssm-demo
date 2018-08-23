package com.xinan.common.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Formatter;
import java.util.Properties;

/**
 * @author XinAnzzZ
 * @date 2018/8/14 13:59
 */
@Slf4j
public class EnvironmentContextListener implements ServletContextListener {

    public EnvironmentContextListener() {
        super();
        log.debug("{[]} initialize start...", EnvironmentContextListener.class.getSimpleName());
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info(getInitializeInfo());
        log.info(getInitializeLogo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private String getInitializeInfo() {
        Properties properties = System.getProperties();
        Formatter formatter = new Formatter();
        formatter.format("\n******************** init(SSM Demo) *******************\n");
        formatter.format("Java Home: %s\n", properties.get("java.home"));
        formatter.format("Java Vendor: %s\n", properties.get("java.vendor"));
        formatter.format("Java Version: %s\n", properties.get("java.version"));
        formatter.format("OS Architecture: %s\n", properties.get("os.arch"));
        formatter.format("OS Name: %s\n", properties.get("os.name"));
        formatter.format("OS Version: %s\n", properties.get("os.version"));
        formatter.format("*******************************************************\n");
        return formatter.toString();
    }

    private String getInitializeLogo() {
        Formatter formatter = new Formatter();
        formatter.format("\n//=======================================================\n");
        formatter.format("//\t\t\t\t          .----.\n");
        formatter.format("//\t\t\t\t       _.'__    `. \n");
        formatter.format("//\t\t\t\t  .--(^)(^^)---/#\\\n");
        formatter.format("//\t\t\t\t .' @          /###\\\n");
        formatter.format("//\t\t\t\t :         ,   #####\n");
        formatter.format("//\t\t\t\t  `-..__.-' _.-\\###/\n");
        formatter.format("//\t\t\t\t        `;_:    `\"'\n");
        formatter.format("//\t\t\t\t      .'\"\"\"\"\"`.\n");
        formatter.format("//\t\t\t\t     /,  ya ,\\\\\n");
        formatter.format("//\t\t\t\t    //狗年大吉  \\\\\n");
        formatter.format("//\t\t\t\t    `-._______.-'\n");
        formatter.format("//\t\t\t\t    ___`. | .'___\n");
        formatter.format("//\t\t\t\t   (______|______)\n");
        formatter.format("//=======================================================\n");
        return formatter.toString();
    }
}
