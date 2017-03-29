package webApp.tester;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
//import com.homeoffice.bdd.framework.utilities.DataMapper;
import java.util.List;
import java.util.Scanner;

public class Main {
	BufferedReader crunchifyBuffer = null;
	
	public static void main(String[] args) {
		runLoginPageTest();
		runPersonPageTest();		

		//runLoginPageLocally();
		//runPersonSearchLocally();		
	}

	public static void runLoginPageTest(){ 
		LoginPage loginPage = new LoginPage();
		String loginFile = "loginPage.csv";
		File lFile = new File(loginFile);

		// this gives you a 2-dimensional array of strings
		List<List<String>> lines = new ArrayList<>();
		Scanner inputStream;

		try {
			inputStream = new Scanner(lFile);
			while (inputStream.hasNext()) {
				String line = inputStream.next();
				String[] values = line.split(",");
				// this adds the currently parsed line to the 2-dimensional
				// string array
				lines.add(Arrays.asList(values));
			}

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String[][] loginData = new String[10][4];

		// the following code lets you iterate through the 2-dimensional array
		int lineNo = 0;
		for (List<String> line : lines) {
			int columnNo = 0;
			for (String value : line) {
				// System.out.println("Line " + lineNo + " Column " + columnNo +
				// ": " + value);
				loginData[lineNo][columnNo] = value;
				columnNo++;
			}
			columnNo = 0;
			lineNo++;
		}

		for (int row = 0; row < loginData.length; row++) {
			// for (int col=0; col<loginData[0].length; col++) {
			// System.out.printf("%s:",loginData[row][col]);
			// }
			// System.out.println();
			loginPage.login(loginData[row][0], loginData[row][1], loginData[row][2],
					Boolean.parseBoolean(loginData[row][3]));
		}

		loginPage.close();
	}

	public static void runPersonPageTest(){
		// ======================================================================================
		// Person search
		PersonSearchPage personPage = new PersonSearchPage();
		String personFile = "personPage.csv";
		File pFile = new File(personFile);

		// this gives you a 2-dimensional array of strings
		List<List<String>> plines = new ArrayList<>();
		Scanner inputStreamp;

		try {
			inputStreamp = new Scanner(pFile);
			while (inputStreamp.hasNext()) {
				String line = inputStreamp.next();
				String[] values = line.split(",");
				plines.add(Arrays.asList(values));
			}

			inputStreamp.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		String[][] personData = new String[10][5];

		// the following code lets you iterate through the 2-dimensional array
		int lineNop = 0;
		for (List<String> line : plines) {
			int columnNo = 0;
			for (String value : line) {
				// System.out.println("Line " + lineNo + " Column " + columnNo +
				// ": " + value);
				personData[lineNop][columnNo] = value;
				columnNo++;
			}
			columnNo = 0;
			lineNop++;
		}

		for (int row = 0; row < personData.length; row++) {
			for (int col = 0; col < personData[0].length; col++) {
				System.out.printf("%s:", personData[row][col]);
			}
			System.out.println();
			String browser = personData[row][0];
			String firstName = personData[row][1];
			String lastName = personData[row][2];
			String other = personData[row][3];
			boolean isPass = Boolean.parseBoolean(personData[row][4]);

			personPage.personSearch(browser, firstName, lastName, other, isPass);
		}

		personPage.close();
	}
	
	public static void runLoginPageLocally(){
		LoginPage loginPage = new LoginPage();
		 
		String[][] loginData = {
		 {"chrome", "youcefg","steve", "false"},
		 {"chrome", "youcefg","","false"},
		 {"chrome", " ","steve","false"},
		 {"chrome", "steve","steve","true"},
		 {"chrome", " "," ","false"},
		
		 {"firefox", "youcefg","steve", "false"},
		 {"firefox", "youcefg","","false"},
		 {"firefox", " ","steve","false"},
		 {"firefox", "steve","steve","true"},
		 {"firefox", " "," ","false"},
		
		 };
		
		 //int c=0;
		 for (int r = 0; r < 10; r++){
			 // System.out.println("r = " + r + ", c = " + c + ": " +testData[r][0]
			 // + ":" + testData[r][1] + ":" + testData[r][2] + ":" + testData[r][3]
			 // + ":");
			 // c += 4;
			 loginPage.login(loginData[r][0], loginData[r][1], loginData[r][2],Boolean.parseBoolean(loginData[r][3]));
		 }
		 
		loginPage.close();			
	}
	
	public static void runPersonSearchLocally(){
		PersonSearchPage personPage = new PersonSearchPage();
		String[][] personData = {
				{"chrome", "Joe", "Bloggs","detrimental", "false"},
				{"chrome", "youcefg"," "," ", "false"},
				{"chrome", " ", " ","steve","false"},
				{"chrome", "steve","steve"," ", "true"},
				{"chrome", " "," "," ", "false"},

				{"firefox", " ", "youcefg","steve", "false"},
				{"firefox", " ", "youcefg","","false"},
				{"firefox", " ", " ","steve","false"},
				{"firefox", "marnie","steve","steve","true"},
				{"firefox", " "," ", " ","false"},
				
				};
		//int c = 0;
		for (int r = 0; r < 10; r++){
			//System.out.println("r = " + r + ", c = " + c + ": " +testData[r][0] + ":" + testData[r][1] + ":" + testData[r][2] + ":" + testData[r][3] + ":");
			//c += 4;
			personPage.personSearch(personData[r][0],personData[r][1],personData[r][2], personData[r][3], Boolean.parseBoolean(personData[r][4]));
		}
		
		personPage.close();			
	}
}
