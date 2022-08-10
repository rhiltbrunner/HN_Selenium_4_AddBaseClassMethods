package com.novaproduction.hellonerd.selenium.elementfinder;

import java.io.IOException;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;

public class LocateElement {
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static final int ABOVE=1;
	public static final int BELOW=2;
	public static final int TOLEFTOF=3;
	public static final int TORIGHTOF=4;
	public static final int NEAR=5;
	
	public LocateElement() throws IOException {
		
	}
	
	/**
	 * available positionIdentifier
	 * 
	 * ABOVE
	 * BELOW
	 * TOLEFTOF
	 * TORIGHTOF
	 * NEAR
	 * 
	 * elementToFind
	 * 
	 * input
	 * button
	 * label
	 * ...
	 * 
	 * nextToElementID
	 * 
	 * password
	 * email
	 * username
	 * ...
	 * 
	 * @param positionIdentifier
	 * @return
	 */
	public By getLocatedElement(int positionIdentifier, String elementToFindByName, String nextToElementID) {
		By element = null;
		if(positionIdentifier == ABOVE) {
			element = RelativeLocator.with(By.tagName(elementToFindByName)).above(By.id(nextToElementID));
		} else if(positionIdentifier == BELOW) {
			element = RelativeLocator.with(By.tagName(elementToFindByName)).below(By.id(nextToElementID));
		}else if(positionIdentifier == TOLEFTOF) {
			element = RelativeLocator.with(By.tagName(elementToFindByName)).toLeftOf(By.id(nextToElementID));
		}else if(positionIdentifier == TORIGHTOF) {
			element = RelativeLocator.with(By.tagName(elementToFindByName)).toRightOf(By.id(nextToElementID));
		}else if(positionIdentifier == NEAR) {
			element = RelativeLocator.with(By.tagName(elementToFindByName)).near(By.id(nextToElementID));
		}else {
			LOGGER.info("positionIdentifier not known: "+positionIdentifier);
		}
		return element;
	}
}
