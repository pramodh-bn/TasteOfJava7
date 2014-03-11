package org.test.pran.main;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dyanna on 3/11/14.
 */
public class SimpleReading {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Map<Integer, Map<String, String>> userList = new HashMap<>();
        /*Path listing = Paths.get("c:/study/Job search");
        System.out.println(listing.getFileName());
        System.out.println(listing.getNameCount());
        System.out.println(listing.getParent());
        System.out.println(listing.getRoot());
        System.out.println(listing.subpath(0,1));
        System.out.println(Paths.get("c:/study/coursera").toAbsolutePath());     */
        try{
            Path cr8 = Paths.get("c:/study/CreateiveLive.txt");
            List<String> lines = Files.readAllLines(cr8, StandardCharsets.UTF_8);
            byte[] bytes = Files.readAllBytes(cr8);
            System.out.println(lines);
            System.out.println(bytes);
        } catch (final Exception ex){
            ex.printStackTrace();
        }

    }
}
