package org.nanwarin.scrapdata;


import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ScrapCalPolyPomonaClassSchedule {

	public static void main(String[] args){
		
		String cppClassURL = "http://schedule.cpp.edu/";
		
		//Quarter Selection
		//<select name="ctl00$ContentPlaceHolder1$TermDDL" id="ctl00_ContentPlaceHolder1_TermDDL" class="InputDDL" style="width:50%;">
		//Will pull data from Winter2017 value = "2181"
		//Class Subjects 
		//Will focus on CS first
		//<input name="ctl00$ContentPlaceHolder1$ClassSubject" type="text" maxlength="10" size="6" id="ctl00_ContentPlaceHolder1_ClassSubject" class="InputTXT" style="width:4em;" />

		
		
		try {
			Connection.Response cppClass = Jsoup.connect(cppClassURL).method(Connection.Method.GET).execute();
			
			//Need to fix this part, document returned wrongly
			Document document = Jsoup.connect(cppClassURL + "index.aspx")
								.data("cookieexists", "false")
								.data("ctl00$ContentPlaceHolder1$ClassSubject", "CS")
								.cookies(cppClass.cookies())
								.post();
		
			System.out.println("Log -- document: " + document.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
}
