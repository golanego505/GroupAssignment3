package mylittlemozart;

public class MyLittleMozartMain {

	public static void main(String[] args) {
		
		boolean testResult;
		
		testResult = TestClass.testParse();
		
		if(testResult)
		{
			System.out.println("File Parsed Successfully.");
		}
		else
		{
			System.out.println("Test Failed.");
		}
		System.out.println("Tests finished...");
	}

}
