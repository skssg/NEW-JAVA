package com.kh.etc.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	public static final String SERVICE_KEY = "ZHAG1AIMN9T42tM0JmWE%2FhRqbw6Tbph46PIiKgydF9UubVg3u7ZmwCIatOyX4M7Mmi%2B3Hq3o4QGLvX1qKudMVA%3D%3D";
	
	
	@ResponseBody
	@GetMapping(value="air", produces="application/json; charset=UTF-8")
	public String getAirInfo(String location) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&returnType=json";
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); //��û�� ���ް��� �ѱ��� ������ ���ڵ� �۾� �� �����ϱ�
		
		//1. ��û�ϰ����ϴ� url�� �����ϸ鼭 java.net.URL��ü ����
		URL requestURL = new URL(url);
		
		//2. ������� URL��ü�� ������ HttpURLConnection��ü ����
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		//3. ��û�� �ʿ��� Header���� �����ϱ�
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	
		String result = "";
		String line;
		while((line = br.readLine()) != null) {
			result += line;
		}
		
		br.close();
		urlConnection.disconnect();
		
		return result;
	}
	
}
