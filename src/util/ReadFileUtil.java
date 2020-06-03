package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFileUtil {

	public static void main(String[] args) throws Exception {
		readFile();
	}
	
	public static void readFile() {
		try {
			XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(new File("SoHieu_UBNDQ7.xlsx")));
			Sheet sheet = workBook.getSheetAt(0);
			Iterator<Row> iterator = sheet.iterator();
			iterator.next();
			DataFormatter fmt = new DataFormatter();
			int total = 0;
			while (iterator.hasNext()) {
				Row currentRow = iterator.next();
				String code = fmt.formatCellValue(currentRow.getCell(0));
				System.out.println("code : "+code);
				total++;
			}
			System.out.println("total : "+total);
		} catch (FileNotFoundException e) {
			System.out.println("Khong tim thay File");
		} catch (IOException e) {
			System.out.println("Loi File");
		}
	}
}
