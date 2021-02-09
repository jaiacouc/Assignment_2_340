package edu.uncg;
/*
02/4/2021
This class is where the program will execute and pull a random quote from the QuoteAPI class.
John Iacoucci
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Creating a quote object.
        QuoteAPI quote = new QuoteAPI();
        // Calling the getQuote method.
        quote.getQuote();
    }
}
