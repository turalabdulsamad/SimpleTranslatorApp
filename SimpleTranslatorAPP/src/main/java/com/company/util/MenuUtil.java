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
    public static final String fileName = "words.txt";
    public static HashMap hMap;

    public static void Menu() throws Exception {
        System.out.println("Do you want your question in Azerbaijani (enter 1) or English (enter 2)?");
        hMap = getOption();
        ask(hMap);
    }

    public static HashMap<String, String> getOption() throws Exception {
        Scanner sc = new Scanner(System.in);
        option = sc.nextInt();

        HashMap<String, String> hMap = new HashMap<>();
        if (option == 1) {
            hMap = FileUtil.getMapFromAZtoENG(fileName);
        } else if (option == 2) {
            hMap = FileUtil.getMapFromENGtoAZ(fileName);
        }
        return hMap;
    }

    public static List getWords() throws Exception {

        if (option == 1) {
            return FileUtil.azWords(fileName);
        } else {
            return FileUtil.engWords(fileName);
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
}
