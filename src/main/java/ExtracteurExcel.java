import java.io.File;
import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtracteurExcel {
    File file;
    FileInputStream fis = null;
    XSSFWorkbook wb;
    XSSFSheet sheetRock;
    XSSFSheet sheetNonRock;

    public ExtracteurExcel() {
        this.openFile();
    }

    private void openFile(){
        try {
            file = new File("sources/albumlist-Rock-Apres 1970.xlsx");
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            sheetRock = wb.getSheetAt(0);
            sheetNonRock = wb.getSheetAt(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int countMatch(int year, ArrayList<Integer> list){
        int nb = 0;
        for(int y : list){
            if(y == year){
                nb ++;
            }
        }
        return nb;

    }

    private ArrayList<Integer> countYear(ArrayList<Integer> list){
        ArrayList<Integer> countList = new ArrayList<Integer>();
        //supprime doublons
        Set<Integer> mySet = new HashSet<Integer>(list);
        for(int year: mySet){
            countList.add(year);
            countList.add(countMatch(year,list));
        }

        return countList;
    }

    public ArrayList<Integer> req1RockExcel(){
        ArrayList<Integer> listRock = new ArrayList<Integer>();
        // Onrécup les rock
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        for(Row row: sheetRock)     //iteration over row using for each loop
        {
            Cell cell = row.getCell(1);
                switch(formulaEvaluator.evaluateInCell(cell).getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type
                        //getting the value of the cell as a number
                        listRock.add((int)cell.getNumericCellValue());
                        break;
                    case Cell.CELL_TYPE_STRING:
                        if(!cell.getStringCellValue().equals("year"))
                            listRock.add(Integer.parseInt(cell.getStringCellValue()));
                        break;
                }
        }
        ArrayList<Integer> result = countYear(listRock);
        return result;
    }

    public ArrayList<Integer> req1NonRockExcel(){
        ArrayList listNonRock = new ArrayList();
        // Onrécup les NonRock
        FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();
        for(Row row: sheetNonRock)     //iteration over row using for each loop
        {
            Cell cell = row.getCell(1);
            switch(formulaEvaluator.evaluateInCell(cell).getCellType())
            {
                case Cell.CELL_TYPE_NUMERIC:   //field that represents numeric cell type
                    //getting the value of the cell as a number
                    listNonRock.add((int)cell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:    //field that represents string cell type
                    //getting the value of the cell as a string
                    if(!cell.getStringCellValue().equals("year"))
                        listNonRock.add(Integer.parseInt(cell.getStringCellValue()));
                    break;
            }
        }
        ArrayList<Integer> result = countYear(listNonRock);
        return result;
    }

}
