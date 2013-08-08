package Automation;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * User: KHALLBEC
 * Date: 8/6/13
 * Time: 2:22 PM
 */
public class TestDataHolder {
    private static final long serialVersionUID = 1L;
    private ArrayList<HashMap<String,String>> dataRows;
    private int numberOfDataSources;

    public TestDataHolder(){
        dataRows = new ArrayList<HashMap<String,String>>();
        numberOfDataSources = 0;
    }

    public void addDataLocation(String fileLocation) throws FileNotFoundException {
        addDataLocation(new FileReader(fileLocation));
    }

    public void addDataLocation(Reader csvReader){
        try{
            final CSVReader cs = new CSVReader(csvReader);
            final String [] headings = cs.readNext();

            int rowNumber = 0;
            int rowsToUpdateWithWrappingValues = 0;
            String [] nextLine;
            while ((nextLine = cs.readNext()) != null) {
                if (dataRows.size() <= rowNumber){
                    dataRows.add(rowNumber,new HashMap<String,String>());
                    //case that this data file has more rows than the datastore
                    rowsToUpdateWithWrappingValues++;
                }
                for(int i = 0; i < nextLine.length; i++){
                    dataRows.get(rowNumber).put(headings[i], nextLine[i]);
                }
                dataRows.get(rowNumber).put("rownumber", Integer.toString(rowNumber));
                rowNumber++;
            }
            if(rowNumber > 0){ this.numberOfDataSources++; }

            //case that the data file has less rows than the datastore
            if(rowsToUpdateWithWrappingValues == 0 && rowNumber < this.dataRows.size()){
                rowsToUpdateWithWrappingValues = this.dataRows.size() - rowNumber;
            }

            //to account for data files with different lengths, if a file is
            //added with more rows, the data attributes will recycle for data
            //files with less elements
            /*if(this.numberOfDataSources > 1 && rowsToUpdateWithWrappingValues > 0){
                populateValuesForNulls(rowsToUpdateWithWrappingValues);
            }*/
        }catch(IOException ie){
            System.out.println("A data file couldn't be loaded");
        }
    }

    public Object[][] getAllDataRows(){
        Object[][] returnObject = new Object[this.dataRows.size()][1];
        for(int itemIndex = 0; itemIndex < this.dataRows.size(); itemIndex++){
            returnObject[itemIndex][0] = this.dataRows.get(itemIndex);
        }
        return returnObject;
    }

    /*private void populateValuesForNulls(int rowsToUpdateWithWrappingValues){
        final int resultsBeforeUpdate = (this.dataRows.size() - rowsToUpdateWithWrappingValues);
        //get first list item's key set
        final Set keySet = this.dataRows.get(0).keySet();

        for(int itemNeedsUpdate = 0; itemNeedsUpdate < rowsToUpdateWithWrappingValues;
            itemNeedsUpdate++){
            int itemCurrentlyChecking = (resultsBeforeUpdate+itemNeedsUpdate);
            // iterate over the keys, check if they are in the current item, if not add them
            final Set currKey = this.dataRows.get(0).keySet() ;
            for (currKey : keySet)  {
                if(!(this.dataRows.get(itemCurrentlyChecking).containsKey(currKey))){
                    final int itemToUse = (itemNeedsUpdate % resultsBeforeUpdate);
                    final String itemToUseValue = this.dataRows.get(itemToUse).get(currKey);
                    this.dataRows.get(itemCurrentlyChecking).put(currKey,itemToUseValue);
                }
            }
        }*/
   // }


   /* private Object[][] getTableArray(String s, String eightyFiveMinutes, String nilnilFootball) {
        return new Object[0][];  //To change body of created methods use File | Settings | File Templates.
    }*/

    /*public Object[][] createData2() {
        Object[][] retObjArr= getTableArray("c:\\temp\\data1.xls",
                "DataPool", "imdbTestData1");
        return(retObjArr);
    }*/
}
