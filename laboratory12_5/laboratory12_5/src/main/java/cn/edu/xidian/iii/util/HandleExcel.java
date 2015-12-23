package cn.edu.xidian.iii.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class HandleExcel {
	/**
	 * 从前端收到的request获去excel文件的输入流
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws FileUploadException
	 */
	public  static InputStream getExcelInputStream(HttpServletRequest request) throws Exception {
		InputStream instream=null;  	
		FileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
			java.util.List<FileItem> items=upload.parseRequest(request);
			for(FileItem item:items)
			{
				
				
				if(item.isFormField()){}
				else if(item.getName()!=null&&!item.getName().equals("")&&item.getName().matches(".*xls")){
					instream=item.getInputStream();			
				}	
			}
			
		return instream;
		
		
	}
     /**
      * 从获得的excel输入流读取excel中的内容，返回list,每一个string[]对应excel表中的一行
      * @param instream
      * @return
      * @throws BiffException
      * @throws IOException
      */
	public static  List< String[] > readExcel(InputStream instream) throws Exception {
		
		List<String[]>  rowcontents=new ArrayList<String[]>();
		
			Workbook readex=Workbook.getWorkbook(instream);
			Sheet exSheet=readex.getSheet(0);
			
		    int columns=exSheet.getColumns();
			int rows=exSheet.getRows();
			for(int i=0;i<rows;i++){
				String[] rowcon=new String[columns];
				for(int j=0;j<columns;j++){
					
					Cell cell=exSheet.getCell(j,i);
					rowcon[j]=cell.getContents();
				}
				rowcontents.add(rowcon);
			}
			
		
		return rowcontents;
	}

}
