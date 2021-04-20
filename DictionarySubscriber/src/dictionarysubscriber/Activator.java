package dictionarysubscriber;

import dictionaryserviceproducer.ServicePublish;

import java.util.ArrayList;
import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class Activator implements BundleActivator {

	ServiceReference serviceReference;
	int option;
	String word = "";
	ArrayList<String> syns = new ArrayList<String>();

	public void start(BundleContext bundleContext) throws Exception {
		serviceReference = bundleContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) bundleContext.getService(serviceReference);
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Find Meaning...");
		System.out.println("2. Find Synonyms...");
		System.out.println("3. Find an example...");
		System.out.print("Choose option:- ");
		option = sc.nextInt();
		
		switch(option) {
			case 1:
				System.out.print("Enter a word to Search (powered by Google Dictionary):- ");
				word = sc.next();
				System.out.println("Definition:- " + servicePublish.getMeaning(word));
				break;
			case 2:
				System.out.print("Enter a word to find synonyms (powered by Google Dictionary):- ");
				word = sc.next();
				syns = servicePublish.getSynonyms(word);
				System.out.print("Synonyms are :- ");
				for(int i = 0; i < syns.size(); i++) {
					System.out.print(syns.get(i) + ", ");
				}
				System.out.println();
				break;
			case 3:
				System.out.print("Enter a word to get example sentence (powered by Google Dictionary):- ");
				word = sc.next();
				System.out.println("Eg:- " + servicePublish.getExample(word));
				break;
			default: 
				System.out.println("INVALID OPTION");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Unsubscribing Dictionary Service...");
		bundleContext.ungetService(serviceReference);
	}

}
