package com.talentica.code.print;

import java.io.FileOutputStream;
import java.time.LocalDate;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.talentica.code.exception.InvoicePrintException;
import com.talentica.code.model.Invoice;

/**
 * Print the invoice 
 * 
 * @author Sayantan Ganguly
 *
 */
public class PrintInvoice {

	/**
	 * Print the invoice 
	 * for products
	 * 
	 * @param invoice
	 * @throws InvoicePrintException 
	 */
	public void printForProducts(Invoice invoice) throws InvoicePrintException{
		try {
			String INVOICE_FILE_NAME = "E:/Programming/TalenticaDocuments/Invoice-"+LocalDate.now().toString()+".xlsx";
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(LocalDate.now().toString());
			

			int[] rowNum = {0};
			int[] colNum = {0};
			
			//Create and set header row and cell
			Row headerRow = sheet.createRow(rowNum[0]++);
			Cell headerCell = headerRow.createCell(colNum[0]++);
			headerCell.setCellValue("NAME");
			headerCell = headerRow.createCell(colNum[0]++);
			headerCell.setCellValue("QTY");
			headerCell = headerRow.createCell(colNum[0]++);
			headerCell.setCellValue("UNIT_COST");
			headerCell = headerRow.createCell(colNum[0]++);
			headerCell.setCellValue("COST");
			
			//New row column starts from 0
			colNum[0] = 0;
			
			
			//Create and set row and cell for product
			invoice.getProductList().stream().forEach(
					product-> {
						
						//Create and set Product row and cell
						Row row = sheet.createRow(rowNum[0]++);
						Cell cell = row.createCell(colNum[0]++);
						cell.setCellValue(product.getProductName());
						cell = row.createCell(colNum[0]++);
						cell.setCellValue(String.valueOf(product.getQuantity()));
						cell = row.createCell(colNum[0]++);
						cell.setCellValue(product.getPerUnitAmount().toString());
						cell = row.createCell(colNum[0]++);
						cell.setCellValue(product.getBeforeAnyTaxAmount().toString());
						
						//New row column starts from 0
						colNum[0] = 0;
						
						//Create and set VAT row and cell for the product
						row = sheet.createRow(rowNum[0]++);
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("Value Added Tax:");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue(product.getVatAmount().toString());
						
						//New row column starts from 0
						colNum[0] = 0;
						
						//Create and set import tax row and cell for the product
						row = sheet.createRow(rowNum[0]++);
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("Additional Tax:");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue(product.getImportTaxAmount().toString());
						
						//New row column starts from 0
						colNum[0] = 0;
						
						//Create and set blank row and cell for the product
						row = sheet.createRow(rowNum[0]++);
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						cell = row.createCell(colNum[0]++);
						cell.setCellValue("");
						
						//New row column starts from 0
						colNum[0] = 0;
					}	
			);
			
			//New row column starts from 0
			colNum[0] = 0;
			
			//Create and set blank row and cell for the product
			Row row = sheet.createRow(rowNum[0]++);
			Cell cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			
			//New row column starts from 0
			colNum[0] = 0;
			
			//Create and set total row and cell for all product
			row = sheet.createRow(rowNum[0]++);
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("SubTotal:");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue(invoice.getTotalAmount().toString());
			
			//New row column starts from 0
			colNum[0] = 0;
			
			//Create and set VAT row and cell for all product
			row = sheet.createRow(rowNum[0]++);
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("Value Added Tax:");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue(invoice.getTotalVatAmount().toString());
			
			//New row column starts from 0
			colNum[0] = 0;
			
			//Create and set import tax row and cell for all product
			row = sheet.createRow(rowNum[0]++);
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("Additional Tax:");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue(invoice.getTotalimportTaxAmount().toString());
			
			//New row column starts from 0
			colNum[0] = 0;
			
			//Create and set net amount row and cell for all product
			row = sheet.createRow(rowNum[0]++);
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("Total:");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue("");
			cell = row.createCell(colNum[0]++);
			cell.setCellValue(invoice.getNetAmount().toString());
			
			//Adjust all columns based on max data size
			sheet.autoSizeColumn(0);
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
		
		
			//Print the excel data in excel file for invoice
			FileOutputStream outputStream = new FileOutputStream(INVOICE_FILE_NAME);
			workbook.write(outputStream);
			outputStream.close();
			
		} catch (Exception e) {
			throw new InvoicePrintException("Failed to print invoice file", e);
		}
		
		
		
	}

}
