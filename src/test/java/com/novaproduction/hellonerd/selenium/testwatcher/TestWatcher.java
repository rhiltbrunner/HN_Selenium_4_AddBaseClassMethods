package com.novaproduction.hellonerd.selenium.testwatcher;

import java.util.logging.Logger;
import org.openqa.selenium.Cookie;
import com.novaproduction.hellonerd.selenium.BaseClass;
import com.novaproduction.hellonerd.selenium.performance.PerformanceMetrics;

public class TestWatcher extends BaseClass {
	
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@org.junit.Rule
    public TestWatcher testWatcher= new TestWatcher() {
        protected void failed(Throwable exceptionThrown) {
            LOGGER.info("--------------- TEST FAILED ----------------");
            Cookie cookie = new Cookie("zaleniumTestPassed", "false");
            if(wDriver!=null && wDriver.manage()!=null) {
            	wDriver.manage().addCookie(cookie);
            }
        }

        protected void succeeded() {
            LOGGER.info("--------------- TEST SUCCESSFUL ------------");
            Cookie cookie = new Cookie("zaleniumTestPassed", "true");
            if(wDriver!=null && wDriver.manage()!=null) {
            	wDriver.manage().addCookie(cookie);
            }
        }
        
        protected void finished() {
            LOGGER.info("Testing time: "+PerformanceMetrics.elapsedSeconds());
            closeDriver();
        }
    };
	
}
