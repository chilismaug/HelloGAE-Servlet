package com.example;

import static org.hamcrest.CoreMatchers.hasItems;

import java.io.*;
import java.io.FileReader;
import java.io.InputStream;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class PhraseOMatic_Mark4 {
   public static String makePhrase() throws FileNotFoundException {

     // make three sets of words to choose from
        String[] wordListOne = {"skin-deep", "24/7",  "pervasive" ,"occasionally available", "globally-scraped", "hybrid", "fructitious"};
        String[] wordListTwo = {"sticky", "creepy",  "clustered", "flustered", "conversational", "fractal", "smyrckled"};
        String[] wordListThree = {"tripping-point", "solution", "fission", "surface", "topology", "borogroves"};

       // String listFolderPath = "C:\\\\Users\\\\charles\\\\Documents\\\\workspace-spring-tool-suite-4-4.1.2.RELEASE\\\\KathyServlet\\\\WebContent\\\\WEB-INF\\\\classes\\\\";

        List<String> wordList1  = new ArrayList<String>();
        List<String> wordList2  = new ArrayList<String>();
        List<String> wordList3  = new ArrayList<String>();

        try {
        	InputStream instrm_1 = Thread.currentThread().getContextClassLoader().getResourceAsStream("wordlist1.txt");
	        Scanner scan_1 = new Scanner(instrm_1).useDelimiter(",");

	        while(scan_1.hasNext() )
	        {
	        	wordList1.add(scan_1.next());
	        }
	        scan_1.close();
        }
        catch(NullPointerException ex) {
            System.out.println("Caught nullptr excptn getting instream.");
        }

        try {
	        InputStream instrm_2 = Thread.currentThread().getContextClassLoader().getResourceAsStream("wordlist2.txt");
	        Scanner scan_2 = new Scanner(instrm_2).useDelimiter(",");

	        while(scan_2.hasNext() )
	        {
	        	wordList2.add(scan_2.next());
	        }
	        scan_2.close();
	        }
        catch(NullPointerException ex) {
            System.out.println("Caught nullptr excptn getting instream.");
        }

        try {
	        InputStream instrm_3 = Thread.currentThread().getContextClassLoader().getResourceAsStream("wordlist3.txt");
	        Scanner scan_3 = new Scanner(instrm_3).useDelimiter(",");

	        while(scan_3.hasNext() )
	        {
	        	wordList3.add(scan_3.next());
	        }
	        scan_3.close();
	        }
        catch(NullPointerException ex) {
            System.out.println("Caught nullptr excptn getting instream.");
        }

		// find out how many words are in each list
		int oneLength = wordList1.size();
		wordList1 = oneLength < 1 ?  Arrays.asList(wordListOne): wordList1;
		oneLength = wordList1.size();

		int twoLength = wordList2.size();
		wordList2 = twoLength < 1 ?  Arrays.asList(wordListTwo): wordList2;
		twoLength = wordList2.size();

		int threeLength = wordList3.size();
		wordList3 = threeLength < 1 ?  Arrays.asList(wordListThree): wordList3;
		threeLength = wordList3.size();

		System.out.println ("wordList1 : " + wordList1 );
		System.out.println ("oneLength : " + oneLength);


		// generate three random numbers, to pull random words from each list
		int rand1 = (int) (Math.random() * oneLength);
		int rand2 = (int) (Math.random() * twoLength);
		int rand3 = (int) (Math.random() * threeLength);


		System.out.println ("rand1 : " + rand1);
 		System.out.println ("wordList1. get(rand1) : " + wordList1.  get(rand1));


		// now make a phrase, bubba

		String phrase = wordList1.get(rand1).trim().replaceAll("^\"|\"$", "") + " " + wordList2.get(rand2).trim().replaceAll("^\"|\"$", "") + " " + wordList3.get(rand3).trim().replaceAll("^\"|\"$", "") + "." ;
	//	String string = phrase.replaceAll("^\"|\"$", "");  to strip quotes, thanx BalusC on Stack-Ovrflow
		return ("What we need is a " + phrase);

	}
  }






