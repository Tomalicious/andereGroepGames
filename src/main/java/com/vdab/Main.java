package com.vdab;

import com.vdab.commandpattern.Invoke;

import com.vdab.repositories.NotFoundException;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static List<Invoke> commandList = Arrays.stream(Invoke.values()).collect(Collectors.toList());
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            try {
                commandList.forEach(invoke -> System.out.println(invoke.getDisplayOptions()));
                System.out.println();
                System.out.println("Choose an option : ");
                chooseAnOption();
            } catch (Exception | NotFoundException e) {
                System.out.println("Error" + e.getMessage());
                scanner.nextLine();
            } finally {
                System.out.println();
                System.out.println("Do you want to continue ? (yes/no) ");
                if(scanner.next().equals("no")){
                    break;
                }
            }

        }
    }

    private static void chooseAnOption() throws Exception, NotFoundException {

        String optionId = scanner.next();
        commandList.stream().filter(invoke -> invoke.getId().equals(optionId))
                .findFirst()
                .orElseThrow(() -> new Exception("option not found"))
                .getCommand()
                .execute();

    }
    }








