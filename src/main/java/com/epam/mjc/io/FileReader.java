package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] userTokens = ReadFileDataIntoString(file);
        return new Profile(userTokens[0],
                            Integer.parseInt(userTokens[1]),
                            userTokens[2],
                            Long.parseLong(userTokens[3]));
    }

    public String[] ReadFileDataIntoString(File file){
        StringBuilder strBuilder = new StringBuilder();
        String rawData;
        try (FileInputStream inputStream = new FileInputStream(file)) {
            int ch;
            while ((ch = inputStream.read()) != -1) strBuilder.append((char)ch);
            rawData = strBuilder.toString();
        } catch (IOException e) {
            throw new FileReaderException("Unable to read data...", e);
        }

        String[] keyValuePairs = rawData.split("\n");
        String[] userProfileFields = new String[keyValuePairs.length];
        for (int i = 0; i < keyValuePairs.length; i++) {
            userProfileFields[i] = keyValuePairs[i].split(": ")[1];
        }
        return userProfileFields;
    }
}
