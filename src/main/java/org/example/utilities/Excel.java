package org.example.utilities;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.By;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Excel {
    private static final String filePath = "C:\\Users\\imane.jadid\\Desktop\\case.csv";

  public static List<String> extractEANCodes() throws CsvValidationException, IOException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[0]);
                }
            }
        }

        return list;
    }
    /*
    public static List<String> extractPUOrderQuantity() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[8]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static List<String> extractRhVitrollesQuantities() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[9]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static List<String> extractRhBonneveineQuantities() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[10]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static List<String> extractRhGrandLittoralQuantities() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[11]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public static List<String> extractRHCarrefourQuantities() throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    list.add(record[12]);
                }
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return list;
    }*/
    public static Map<String, List<String>> map() throws CsvValidationException, IOException {
        List<String> articles=new ArrayList<>();
        List<String> RHVITROLLESQuantities=new ArrayList<>();
        List<String> RHGRANDLITTORALQuantities=new ArrayList<>();
        List<String> RHBONNEVELESQuantities=new ArrayList<>();
        List<String> RHCARREFERENCESQuantities=new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    articles.add(record[0]);
                    RHVITROLLESQuantities.add(record[9]);
                    RHGRANDLITTORALQuantities.add(record[11]);
                    RHBONNEVELESQuantities.add(record[10]);
                    RHCARREFERENCESQuantities.add(record[12]);
                }
            }
        }
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<articles.size();i++){
            map.put(articles.get(i),List.of(RHVITROLLESQuantities.get(i),RHGRANDLITTORALQuantities.get(i),RHBONNEVELESQuantities.get(i)));
        }
        return map;
    }
    public static Map<String,Map<String,String>> maping() throws CsvValidationException, IOException {
        List<String> articles=new ArrayList<>();
        List<String> RHVITROLLESQuantities=new ArrayList<>();
        List<String> RHGRANDLITTORALQuantities=new ArrayList<>();
        List<String> RHBONNEVELESQuantities=new ArrayList<>();
        List<String> RHCARREFERENCESQuantities=new ArrayList<>();
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .build()) {

            String[] record;


            csvReader.readNext();

            while ((record = csvReader.readNext()) != null) {
                if (record.length > 0) {
                    articles.add(record[0]);
                    RHVITROLLESQuantities.add(record[9]);
                    RHGRANDLITTORALQuantities.add(record[11]);
                    RHBONNEVELESQuantities.add(record[10]);
                    RHCARREFERENCESQuantities.add(record[12]);
                }
            }
        }
        Map<String,String> map = new HashMap<>();
        Map<String,Map<String,String>> maping = new HashMap<>();
        for(int i=0; i<articles.size();i++){
            map.put("RH VITROLE",RHVITROLLESQuantities.get(i));
            map.put("RH GRAND LITTORAL",RHGRANDLITTORALQuantities.get(i));
            map.put("RH BONNEVE",RHBONNEVELESQuantities.get(i));
           /* map.put("RH CARREFOUR",RHCARREFERENCESQuantities.get(i));*/
            maping.put(articles.get(i),map);
        }
        return maping;
    }
}