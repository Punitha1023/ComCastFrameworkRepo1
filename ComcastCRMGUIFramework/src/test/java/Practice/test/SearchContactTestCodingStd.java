package Practice.test;
/**
 * test class of contact module
 * @author pugazh
 */

import org.testng.annotations.Test;

import com_comcast_crm_basetest.BaseClass;
import com_comcast_generic_ObjectRepositoryUtility.LoginPage;

public class SearchContactTestCodingStd extends BaseClass{
	/**
	 * 
	 * Scenerio: login()==>navigate to Contact==>create contact()==>verify
	 * 
	 */
	@Test
	public void searchcontactTest() {
		
		/*Step1: login to application*/
      LoginPage lp =new LoginPage(driver);
      lp.loginToapp("URL", "USERNAME", "PASSWORD");
      
	}
	
	

}
