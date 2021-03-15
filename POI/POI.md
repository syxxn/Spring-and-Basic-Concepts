# POI



아파치 POI(Poor Obfuscation Implementation)는 아파치 소프트웨어 재단에서 만든 라이브러리로서, 마이크로소프트 오피스 파일 포맷을 순수 자바 언어로서 읽고 쓰는 기능을 제공한다. 

> HSSF : 마이크로소프트 엑셀 파일 포맷을 읽고 씀
>
> XSSF : 엑셀 2007부터 지원하는 `.xlsx` 파일을 읽고 씀
>
> HSLF : 마이크로소프트 파워포인트 파일을 읽고 쓰는데 사용되는 컴포넌트이다.



+ `Workbook` : 엑셀 워크북 : 파일을 저장할 때는 워크북 단위로 저장되기 때문에, 보통 엑셀 파일이라고 칭하는 것은 워크북이라고 생각하면 된다. 

  ```java
  Workbook workbook = new SXSSFWorkbook(); //HSSFWorkbook
  ```

  > 엑셀 97-2003까지는 HSSF, 엑셀 2007 이상은 XSSF

+ `Sheet` : 통합 문서 내의 각각의 페이지를 시트 또는 워크시트라고 한다.

  ```java
  private final Sheet sheet = workbook.createSheet("applicant information");
  ```

  > workbook.createSheet("<이름>");

+ `Row` : 행 생성

  ```java
  Row row = sheet.createRow(0); //행과 열의 처음 시작은 0번부터
  ```

+ `Cell` :  셀은 행 객체의 메소드로 생성하며, 0번부터 시작한다.

  ```java
  Row row = sheet.createRow(0);
  
  row.createCell(0).setCellValue("수험번호"); // 셀의 값을 입력할 때는 cell.setCellValue() 메소드를 사용한다.
  ```

+ `CellStyle` : 워크북(엑셀 파일)의 createCellStyle() 메소드를 이용해서 CelStyle 객체를 생성한다.

+ 출력하기

  1. 컨텐츠타입과 파일명 지정

     ```java
     response.setContentType("application/vnd.ms-excel");
     
     response.setHeader("Content-Disposition", "attachment;filename=test.xls");
     ```

  2. 클라이언트로 출력

     ```java
     wb.write(response.getOutputStream());
     
     wb.close();
     ```

     