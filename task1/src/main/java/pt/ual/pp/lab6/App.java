package pt.ual.pp.lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//class FilterPredicate implements Predicate<String>{
//    @Override
//    public boolean test(String s) {
//        return s.charAt(0) == 'A';
//    }
//}


public class App
{
//    public static boolean filter(String s){
//        return s.charAt(0) == 'A';
//    }


    public static List<String> filterStrings(List<String> strings, Predicate<String> predicate){
//        List<String> result = new ArrayList<>();
//        for(final var string : strings){
//            if(filter(string)){
//                if(new FilterPredicate().test(string)){
//                    result.add(string);
//                }
//            }
//        }
//        return result;

//        return strings.stream().filter((string) -> string.charAt(0) == 'A').collect(Collectors.toList());

        //return strings.stream().filter(string -> predicate.test(string)).collect(Collectors.toList());

        //return strings.stream().filter(string -> string.length() > 10).collect(Collectors.toList());

        return strings.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main( String[] args )
    {
        List<String> strings = Arrays.asList(
                "As the asteroid hurtled toward earth, Becky was upset her dentist appointment had been canceled.",
                "Malls are great places to shop; I can find everything I need under one roof.",
                "The blue parrot drove by the hitchhiking mongoose.",
                "It was a really good Monday for being a Saturday.",
                "The sudden rainstorm washed crocodiles into the ocean."
        );


        //a)
        System.out.println("string.startsWith(\"A\")");
        strings.stream().filter(string -> string.startsWith("A")).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("\nMétodo filterStrings : string.startsWith(\"A\")");
        filterStrings(strings, string ->string.startsWith("A")).forEach(System.out::println);


        System.out.println("\nstring.length() > 10");
        strings.stream().filter(string -> string.length() > 10).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("\nMétodo filterStrings : string.length() > 10");
        filterStrings(strings, string -> string.length() > 10).forEach(System.out::println);


        System.out.println("\nstring.split(\" \").length > 8");
        strings.stream().filter( string -> string.split(" ").length > 8).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("\nMétodo filterStrings : string.split(\" \").length > 8");
        filterStrings(strings, string -> string.split(" ").length > 8).forEach(System.out::println);

        //b)
        //Strings com todas as palavras com 3 ou mais letras;
        System.out.println("\nb)i)");
        //strings.stream().filter(string -> string.split(" ").length >= 3).collect(Collectors.toList()).forEach(System.out::println);
        strings.stream().filter(
                string ->  filterStrings(Arrays.asList(string.split(" ")), s -> s.length() < 3).size() == 0 ).forEach(System.out::println);

        System.out.println("\nb)ii)");

        filterStrings(strings, string ->
                (string.length() - string.replace("w", "").length()) % 2 == 0 &&
                        (string.length() - string.replace("w", "").length()) != 0)
                .forEach(System.out::println);
    }
}
