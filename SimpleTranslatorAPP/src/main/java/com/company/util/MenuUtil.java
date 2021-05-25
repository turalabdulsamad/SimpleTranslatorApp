/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.util;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author dell
 */
public class MenuUtil {

    private static int option;
    private static final String fileName = "words.txt";
    private static HashMap hMap;

    public static void Menu() throws Exception {
        System.out.println("Do you want your question in Azerbaijani (enter 1) or English (enter 2)?");
        hMap = getOption();
        ask(hMap);
    }

    public static HashMap<String, String> getOption() throws Exception {
        Scanner sc = new Scanner(System.in);
       

//        HashMap<String, String> hMap = new HashMap<>();
        while (true) {
            option = sc.nextInt();
            if (option == 1) {
                return FileUtil.getMapFromAZtoENG(fileName);
            } else if (option == 2) {
                return FileUtil.getMapFromENGtoAZ(fileName);
            }
            System.out.println("Please enter a correct option number..");
        }
    }

    public static List getWords() throws Exception {
        while (true) {
            if (option == 1) {
                return FileUtil.azWords(fileName);
            } else if (option == 2) {
                return FileUtil.engWords(fileName);
            } else {
                System.out.println("Please enter a correct option..");
            }
        }
    }

    public static void ask(HashMap<String, String> hMap) throws Exception {
        List<String> list = getWords();
        int count = 0;
        int index = 0;
        Random r = new Random();
        for (int i = 0; i < list.size(); i++) {
            while (count < 3) {
                index = r.nextInt(list.size() - 1);
                System.out.println("What is the translation of: " + list.get(index));
                Scanner sc = new Scanner(System.in);
                String answer = sc.nextLine();

                if (answer.equalsIgnoreCase(hMap.get(list.get(index)))) {
                    System.out.println("Correct answer!");

                } else {
                    System.out.println("Incorrect answer!");
                    System.out.println("Please try again..");
                    count++;
                }
            }
            System.out.println("GAME OVER!");

            if (list.size() > 0) {
                System.out.println("YOU LOST!");
                System.out.println("Correct answer is: " + hMap.get(list.get(index)));
                break;
            }

        }
    }
}
