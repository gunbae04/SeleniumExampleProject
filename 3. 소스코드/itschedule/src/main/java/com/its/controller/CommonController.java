package com.its.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonController {

	private HashMap<String,Object> result;

	public boolean validationDate(String checkDate, String format){
		//���ڼ����� ��
		if(checkDate.length() != format.length()) {
			return false;
		}

		try{
			SimpleDateFormat  dateFormat = new  SimpleDateFormat(format);

			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			return  true;

		}catch (ParseException  e){
			return  false;
		}

	}
	
	public boolean validationParam(String param) {
		String YYYYMMDD = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
		String yyyyMMddHHmmss = "(19|20)\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])(0[0-9]|1[0-9]|2[0-3])([0-5][0-9])([0-5][0-9])";
		
		if(param != "" && param != null) {
			 if (param.matches(YYYYMMDD)) {
				 if(this.validationDate(param, "yyyyMMdd")) {
					 return true;
				 }
				 
			 }else if(param.matches(yyyyMMddHHmmss)) {
				 
				 if(this.validationDate(param, "yyyyMMddHHmmss")) {
					 return true;
				 }
			 }else {
				 return true;
			 }
		}else {
			return false;
		}
		
		return false;
		
		
	}
	
	public String getTodayDay(String type) {
		String result = "";
		if( type.equals("DATE") ) {
			//��¥
			Date time = new Date();
			SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy.MM.dd");
			result = format1.format(time);
		}else if(type.equals("TIME")) {
			Calendar calender = Calendar.getInstance();
			int hour = calender.get(Calendar.HOUR);
			int minute = calender.get(Calendar.MINUTE);
			int second = calender.get(Calendar.SECOND);
			
			result = hour+":"+minute+":"+second;
		}else if(type.equals("DAY")) {
			Calendar calender = Calendar.getInstance();
			int day = calender.get(Calendar.DAY_OF_WEEK);
			switch(day) {
			case 1:
				result = "SUN";
				break;
			case 2:
				result = "MON";
				break;
			case 3:
				result = "TUE";
				break;
			case 4:
				result = "WEN";
				break;
			case 5:
				result = "THU";
				break;
			case 6:
				result = "FRI";
				break;
			case 7:
				result = "SAT";
				break;
			}
		}
		
		return result;
	}
	
	public String replacePhone(String pnum) {
		if (pnum == null) {
			return "";
		}
		if (pnum.length() == 8) {
			return pnum.replaceFirst("^([0-9]{4})([0-9]{4})$", "$1-$2");
		} else if (pnum.length() == 12) {
			return pnum.replaceFirst("(^[0-9]{4})([0-9]{4})([0-9]{4})$", "$1-$2-$3");
		}
		return pnum.replaceFirst("(^02|[0-9]{3})([0-9]{3,4})([0-9]{4})$", "$1-$2-$3");
	}
	
	public String getBody(HttpServletRequest request) throws IOException{
		
		String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
 
        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }
 
        body = stringBuilder.toString();
        return body;
		
	}
	
	public void chekcParameter(HttpServletRequest request) {
		
		log.info("chekcParameter");
		
		Enumeration params = request.getParameterNames();
		while(params.hasMoreElements()) {
			String name = (String) params.nextElement();
			log.info(name + " : " + request.getParameter(name) + "     "); 
		}
	}
	
	public String makeUUID() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        
        return uuidAsString;
	}
	
	public String makeRandomCode(int len, int dupCd) {
		String result = "";
		
		//dupCd: 중복 허용 여부 (1: 중복허용, 2:중복제거)
		
		Random rand = new Random();
		for(int i=0;i<len;i++) {
            
            //0~9 까지 난수 생성
            String ran = Integer.toString(rand.nextInt(10));
            
            if(dupCd==1) {
                //중복 허용시 numStr에 append
            	result += ran;
            }else if(dupCd==2) {
                //중복을 허용하지 않을시 중복된 값이 있는지 검사한다
                if(!result.contains(ran)) {
                    //중복된 값이 없으면 numStr에 append
                	result += ran;
                }else {
                    //생성된 난수가 중복되면 루틴을 다시 실행한다
                    i-=1;
                }
            }
        }
		return result;
	}
	
}