package backend;
/**
 * @author Eric Le Fort
 * @version 01
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class DataLoader{
	private static File recipeFile = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\drinkRecipes.txt"), //TODO determine the file locations upon install.
					taxiFile = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\taxiInfo.txt"),
					barFile = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\bars.txt"),
					contactListFile = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\contactList.txt"),
					profileFile = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\myProfile.txt");
	private static Profile profile = readInProfile(profileFile);
	private static Contact[] contacts = readInContacts(contactListFile);
	private static Recipe[] recipes = readInRecipes(recipeFile);
	private static Bar[] bars = readInBars(barFile);
	private static Taxi[] taxis = readInTaxis(taxiFile);
	
	/**
	 * Initializes the user's profile data.
	 * File is of the form:
	 * name
	 * gender
	 * streetNum streetName
	 * postalCode
	 * 
	 * @param file
	 * @return The user's profile stored in data.
	 */
	public static Profile readInProfile(File file){
		String name = "", streetName = "", postalCode = "";
		Gender gender = Gender.M;
		int streetNum = 0;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			name = in.nextLine();
			gender = Gender.valueOf(in.nextLine());
			streetNum = in.nextInt();
			streetName = in.nextLine();
			postalCode = in.nextLine();
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }

		return new Profile(new Address(streetNum, streetName, postalCode), name, gender);
	}//readInProfile()
	
	/**
	 * Initializes the user's contact data.
	 * File is of the form:
	 * name
	 * gender
	 * number
	 * 
	 * @param file
	 * @return The contacts stored in the data file.
	 */
	public static Contact[] readInContacts(File file){
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		Contact[] contacts = new Contact[0];
		String name, number;
		Gender gender;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				name = in.nextLine();
				gender = Gender.valueOf(in.nextLine());
				number = in.nextLine();
				contactList.add(new Contact(name, number, gender));
			}
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }
		
		return contactList.toArray(contacts);
	}//readInContacts()
	
	/**
	 * Initializes all the recipes stored in the recipe data file and populates the recipe list.
	 * recipeFile form:
	 * (Advanced) Glassware
	 * Recipe Name
	 * Ingredients...
	 * *Prep...
	 * 
	 * @param file
	 * @return The Recipes stored in data.
	 */
	public static Recipe[] readInRecipes(File file){
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		ArrayList<String> temp;
		Recipe[] recipes = new Recipe[0];
		String[] ingredients = new String[0], prep = new String[0], stringArray = new String[0];
		String recipeName, next;
		Glass glass;
		boolean advanced = false;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				temp = new ArrayList<String>();
				
				if((next = in.nextLine()).contains("ADVANCED")){
					advanced = true;
					glass = Glass.valueOf(next.substring(9));		//Takes the part after "Advanced " only.
				}else{
					glass = Glass.valueOf(next);
				}
				recipeName = in.nextLine();
				
				while((next = in.nextLine()).charAt(0) != '*'){		//Reads in ingredients.
					temp.add(next);
				}
				ingredients = temp.toArray(stringArray);
				temp = new ArrayList<String>();
				
				do{													//Reads in prep.
					temp.add(next);
				}while(in.hasNext() && !(next = in.nextLine()).equals(""));
				prep = temp.toArray(stringArray);
				
				recipeList.add(new Recipe(recipeName, glass, advanced, ingredients, prep));
				advanced = false;
			}
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }
		return recipeList.toArray(recipes);
	}//readInRecipes()
	
	/**
	 * Initializes the list of local bars stored in data.
	 * name
	 * type
	 * streetNumber streetName
	 * postalCode
	 * 
	 * @param file
	 * @return The list of local bars in data.
	 */
	public static Bar[] readInBars(File file){
		ArrayList<Bar> barList = new ArrayList<Bar>();
		Bar[] bars = new Bar[0];
		String name, type, streetName, postalCode, number;
		int streetNumber, open, close;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				name = in.nextLine();
				type = in.nextLine();
				streetNumber = in.nextInt();
				streetName = in.nextLine();
				postalCode = in.nextLine();
				open = in.nextInt();
				close = in.nextInt();
				in.nextLine();
				number = in.nextLine();
				barList.add(new Bar(name, type, number, open, close, new Address(streetNumber, streetName, postalCode)));
			}
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }
		
		return barList.toArray(bars);
	}//readInBars()
	
	/**
	 * Initializes the info about the taxi companies stored in data.
	 * recipeFile form:
	 * name
	 * number
	 * tollFree (may not have for this company)
	 * region
	 * 
	 * @param file
	 * @return The taxi companies stored in the data file.
	 */
	public static Taxi[] readInTaxis(File file){
		ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
		Taxi[] taxis = new Taxi[0];
		String name, number, tollFree, region, next;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				name = in.nextLine();
				number = in.nextLine();
				if(Character.isDigit((next = in.nextLine()).charAt(0))){
					tollFree = next;
					region = in.nextLine();
					taxiList.add(new Taxi(name, number, tollFree, region));
				}else{
					region = next;
					taxiList.add(new Taxi(name, number, region));
				}
			}
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }
		
		return taxiList.toArray(taxis);
	}//readInTaxis()
	
}//DataLoader
