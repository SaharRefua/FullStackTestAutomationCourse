package Lesson05;

import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String[] args) {
        //Part 1
        List<String> visitedCountries = new ArrayList<String>();
        visitedCountries.add("Netherlands");
        visitedCountries.add("Vienna");
        visitedCountries.add("Hungary");
        
        //Part 2
        System.out.println("The countries that I traveled to are: " + visitedCountries);
        //Part 3
        System.out.println("The Number of countries are: " + visitedCountries.size());
        //Part 4
         visitedCountries.set(1, "USA");
        System.out.println("The countries that I love to traveled are: " + visitedCountries);
        //Part 5
        if (visitedCountries.contains("Germany")){
            System.out.println("Germany index is: "+ visitedCountries.indexOf("Germany"));
        }
        else{
            System.out.println("I never visited in Germany");
        }
        //Part 6
        int lastIndex =  visitedCountries.size() - 1;
        System.out.println("The last country is : " +  visitedCountries.get(lastIndex));
        //Part 7
        List<String> NeedToVisit = new ArrayList<String>();
        NeedToVisit.add("Germany");
        NeedToVisit.add("USA");
         visitedCountries.addAll(NeedToVisit);
        for (String country : visitedCountries)
            System.out.println(country);

    }


}
