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
 	public static Profile readInProfile(){
 		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\myProfile.txt");
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
	public static Contact[] readInContacts(){
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\contactList.txt");
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
		
		return contactList.toArray(new Contact[0]);
	}//readInContacts()
	
	/**
	 * Initializes all the recipes stored in the recipe data file and populates the recipe list.
	 * recipeFile form:
	 * (Advanced) Glassware
	 * Recipe Name
	 * Ingredient...
	 * Ingredient Colour code...
	 * *Prep...
	 * 
	 * @param file
	 * @return The Recipes stored in data.
	 */
	public static Recipe[] readInRecipes(){
		ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
		ArrayList<String> temp;
		ArrayList<Ingredient> tempIngredients;
		Ingredient[] ingredients = new Ingredient[0];
		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\drinkRecipes.txt");
		String[] prep, stringArray = new String[0];
		String recipeName, next;
		Glass glass;
		boolean advanced = false;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				temp = new ArrayList<String>();						//Resets the ArrayList to flush out data already used.
				tempIngredients = new ArrayList<Ingredient>();
				
				if((next = in.nextLine()).contains("ADVANCED")){
					advanced = true;
					glass = Glass.valueOf(next.substring(9));		//Takes the part after "ADVANCED " only.
				}else{
					glass = Glass.valueOf(next);
				}
				recipeName = in.nextLine();
				
				while((next = in.nextLine()).charAt(0) != '*'){		//Reads in ingredients.//TODO Verify this reads in correctly, first need to get file with codes from Mr. Deevy.
					tempIngredients.add(new Ingredient(next, in.nextInt(), in.nextInt(), in.nextInt()));
				}
				ingredients = tempIngredients.toArray(ingredients);
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
		return recipeList.toArray(new Recipe[0]);
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
	public static Bar[] readInBars(){
		ArrayList<Bar> barList = new ArrayList<Bar>();
		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\bars.txt");
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
		
		return barList.toArray(new Bar[0]);
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
	public static Taxi[] readInTaxis(){
		ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\taxiInfo.txt");
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
		
		return taxiList.toArray(new Taxi[0]);
	}//readInTaxis()
	
	/**
	 * Initializes the list of potential challenge events for the evening.
	 * @return The events listed in the file.
	 */
	public static Event[] readInEvents(){
		ArrayList<Event> eventList = new ArrayList<Event>();
		File file = new File("C:\\users\\eric\\dropbox\\JustAddFriends\\doc\\events.txt");
		String name, description;
		
		try{
			Scanner in = new Scanner(new FileReader(file));
			while(in.hasNext()){
				name = in.nextLine();
				description = in.nextLine();
				eventList.add(new Event(name, description));
			}
			in.close();
		}catch(FileNotFoundException fnfe){ fnfe.getMessage(); }
		catch(InputMismatchException ime){ ime.getMessage(); }
		
		return eventList.toArray(new Event[0]);
	}//readInEvents()
}//DataLoader

//TODO determine the file locations upon install.
