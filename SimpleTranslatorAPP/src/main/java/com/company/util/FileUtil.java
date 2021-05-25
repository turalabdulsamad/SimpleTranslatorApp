/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author dell
 */
public class FileUtil {

    private static BufferedReader WordReader(String fileName) throws Exception {

        Reader reader = new FileReader(fileName);
        BufferedReader br = new BufferedReader(reader);
        return br;
    }

    public static List azWords(String fileName) throws Exception {
        BufferedReader br = WordReader(fileName);
        String line;
        List<String> list = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] lineArr = line.split(", ");
            list.add(lineArr[1]);         
        }
        return list;
    }
     public static List engWords(String fileName) throws Exception {
        BufferedReader br = WordReader(fileName);
        String line;
        List<String> list = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            String[] lineArr = line.split(", ");
            list.add(lineArr[0]);         
        }
        return list;
    }
    

    public static HashMap<String, String> getMapFromAZtoENG(String fileName) throws Exception {
        HashMap<String, String> AZtoENGhMap = new HashMap<>();
        BufferedReader br = WordReader(fileName);
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineArr = line.split(", ");

            AZtoENGhMap.put(lineArr[1], lineArr[0]);
        }
        return AZtoENGhMap;
    }

    public static HashMap<String, String> getMapFromENGtoAZ(String fileName) throws Exception {
        HashMap<String, String> ENGtoAZhMap = new HashMap<>();
        BufferedReader br = WordReader(fileName);
        String line;

        while ((line = br.readLine()) != null) {
            String[] lineArr = line.split(", ");
            ENGtoAZhMap.put(lineArr[0], lineArr[1]);
        }
        return ENGtoAZhMap;
    }
}
