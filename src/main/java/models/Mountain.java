package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Mountain {
    private String mountainCode;
    private String mountain;
    private String province;
    private String description;

    private static Set<String> validMountainCodes = new HashSet<>();

    public Mountain() {
    }

    public Mountain(String mountainCode, String mountain, String province, String description) {
        this.mountainCode = mountainCode;
        this.mountain = mountain;
        this.province = province;
        this.description = description;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public String getMountain() {
        return mountain;
    }

    public void setMountain(String mountain) {
        this.mountain = mountain;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Load mountain codes from MountainList.csv
    public static void loadMountainCodes() {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MountainList.csv"))) {
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    // Convert number to MT format
                    String formattedCode = String.format("MT%02d", Integer.parseInt(values[0].trim()));
                    validMountainCodes.add(formattedCode);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading MountainList.csv: " + e.getMessage());
        }
    }

    public static boolean isValidMountainCode(String mountainCode) {
        return validMountainCodes.contains(mountainCode);
    }

    public static String formatMountainCode(String mountainCode) {
        try {
            int number = Integer.parseInt(mountainCode.trim());
            return String.format("MT%02d", number);
        } catch (NumberFormatException e) {
            return mountainCode;
        }
    }
}
