package com.example.assignment.backend.services;

import com.example.assignment.backend.models.SystemConfig;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;


public class Utils {
    String configFilePath = "/Users/mac/Documents/UoN_MS_Computing/Visual_Object_Software/assignment/config/config.properties";

    public void readFile(String filePath, String delimiter){
        String line;
//        String delimiter = ","; // Define the delimiter (comma)

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // Split the line into values using the delimiter
                String[] values = line.split(delimiter);

                // Print the values (or process them as needed)
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }


    public SystemConfig readConfiguration() throws ConfigurationException {
        SystemConfig systemConfig = new SystemConfig();
        Configurations configs = new Configurations();
        PropertiesConfiguration config = configs.properties(new File(configFilePath));

        // Access properties
        String host = config.getString("database.host");
        int port = config.getInt("database.port");
        boolean isProduction = config.getBoolean("app.production");

        System.out.println("Host: " + host);
        System.out.println("Port: " + port);
        System.out.println("Production: " + isProduction);

        return systemConfig;
    }


    public void readExcel(String filePath){
        try (FileInputStream fis = new FileInputStream(filePath)) {
            // Open the workbook
            Workbook workbook = WorkbookFactory.create(fis);

            int noOfSheets = workbook.getNumberOfSheets();

            if(noOfSheets > 2) noOfSheets = 2;

            // Get the first sheet (or iterate through sheets as needed)
            Sheet sheet = workbook.getSheetAt(0);

            // Iterate through the rows
            for (Row row : sheet) {
                // Iterate through the cells in the row
                for (Cell cell : row) {
                    // Get cell value based on its type
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                System.out.print(cell.getDateCellValue() + "\t");
                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t");
                            }
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case FORMULA:
                            System.out.print(cell.getCellFormula() + "\t");
                            break;
                        default:
                            System.out.print(" " + "\t");
                            break;
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
