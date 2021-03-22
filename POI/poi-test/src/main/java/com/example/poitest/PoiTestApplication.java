package com.example.poitest;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class PoiTestApplication {

	public static void main(String[] args) throws IOException {
		SchoolInfo schoolInfo = new SchoolInfo("대덕소프트웨어마이스터고등학교","1992년 3월", "창의", "042-866-8822","대전광역시 유성구 가정북로 76 (장동 23-9)");
		schoolInfo.format();
		schoolInfo.getWorkbook().write(new FileOutputStream("./학교 정보.xls"));
	}

}
