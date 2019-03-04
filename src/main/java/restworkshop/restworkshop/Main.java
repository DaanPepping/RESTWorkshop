package restworkshop.restworkshop;

import restworkshop.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		PersoonService service = ServiceProvider.getPersoonService();
		
		System.out.println(service.geefAllePersonen());
		service.addPersoon("kees", "achternaam", 18);
		System.out.println(service.geefPersoonMetNaam("kees"));
		System.out.println(service.geefAllePersonen());

		
	
	}
}
