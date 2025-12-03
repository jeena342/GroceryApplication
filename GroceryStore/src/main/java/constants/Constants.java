package constants;

public class Constants {
	//we can add constants capital letter
	public static final String CONFIGFILE= System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	//user.dir = is the system local adderss
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	
	//"C:\\Users\\91996\\eclipse-workspace\\GroceryStore";
	public static final String VALIDCREDENTIALERROR= "User is not able to login";
	public static final String INVALIDCREDENTIALERROR="User is unable to open the home page";
	public static final String INVALIDPASSWORDVALIDUSERNAME="User is unable to open the home page";
	public static final String INVALIDUSERNAMEVALIDPASSWORD="User is unable to open the home page";
	public static final String LOGOUTERROR="User is unable to open the home page";
	public static final String ADMINNEWPAGEERROR="User is unable to open the new page";
	public static final String ADMINSEARCHERROR="User is unable to search admin";
	public static final String ADMINRESETERROR="User is unable to reset page";
	public static final String ADDNEWNEWSERROR= "User is unable to locate the new button";
	public static final String SEARCHNEWSERROR="User is unable to locate the Search button";
	
}
