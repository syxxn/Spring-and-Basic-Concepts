# RestTemplate

Spring 3.0부터 지원된 http 통신에 유용하게 쓸 수 있는 템플릿이다.

> org.springframework.http.client 패키지에 있다.

+ 기계적이고 반복적인 코드를 최대한 줄여줌
+ RESTful 형식에 맞춤
+ json, xml을 쉽게 응답받음
+ 많은 요청을 하면 TIME_WAIT로 인해 자원이 점점 부족해짐



```java
public String callAPI() {
 
        HashMap<String, Object> result = new HashMap<String, Object>();
 
        String jsonInString = "";
    	// 전달 받는 값은 json 형태이므로 String 자체로 받아 파싱해도 된다. -> RestTemplate은 다양한 형태로 데이터를 바로 파싱해서 받을 수 있다.
 
        try {
 
            // ----------------------------
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setConnectTimeout(5000); //타임아웃 설정 5초
            factory.setReadTimeout(5000);//타임아웃 설정 5초
            RestTemplate restTemplate = new RestTemplate(factory);
            // ----------------------------
            // 타임 아웃이 필요 없다면 RestTemplate resttemplate = new RestTemplate()처럼 생성해도 됨.
            
            HttpHeaders header = new HttpHeaders();
            HttpEntity<?> entity = new HttpEntity<>(header);
 
            String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
 
            UriComponents uri = UriComponentsBuilder.fromHttpUrl(url+"?"+"key=430156241533f1d058c603178cc3ca0e&targetDt=20120101").build();
 
            //이 한줄의 코드로 API를 호출해 MAP타입으로 전달 받는다.
            ResponseEntity<Map> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Map.class); 
            // 호출 결과로 http status code, 헤더 정보, body 정보를 확인할 수 있다.
 
            result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
            result.put("header", resultMap.getHeaders()); //헤더 정보 확인
            result.put("body", resultMap.getBody()); //실제 데이터 정보 확인
 
            LinkedHashMap lm = (LinkedHashMap)resultMap.getBody().get("boxOfficeResult");
            ArrayList<Map> dboxoffList = (ArrayList<Map>)lm.get("dailyBoxOfficeList");
            //Map은 키 : 밸류로 이루어진 형태
            LinkedHashMap mnList = new LinkedHashMap<>();
            for (Map obj : dboxoffList) {
                mnList.put(obj.get("rnum"),obj.get("movieNm"));
            }
            ObjectMapper mapper = new ObjectMapper();
            jsonInString = mapper.writeValueAsString(mnList);
 
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            result.put("statusCode", e.getRawStatusCode());
            result.put("body"  , e.getStatusText());
            System.out.println("dfdfdfdf");
            System.out.println(e.toString());
 
        } catch (Exception e) {
            result.put("statusCode", "999");
            result.put("body"  , "excpetion오류");
            System.out.println(e.toString());
        }
 
        return jsonInString;
 
    }
```

> 출처 : https://vmpo.tistory.com/27



> GET

```java
private Coordinate getCoordinate (String address) throws URISyntaxException, UnsupportedEncodingException, JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    headers.add("Accept-Language", "ko");
    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE
            + ";charset=UTF-8");

    URI url = new URI("https://apis.openapi.sk.com/tmap/geo/postcode?version=1&appKey="
            + appKey + "&addr=" + URLEncoder.encode(address,"UTF-8") + "&addressFlag=F00&format=json");

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Map> response = restTemplate.getForObject(url, Map.class);

    Map<String, Map> coordinate =
            mapper.readValue(mapper.writeValueAsString(response.get("coordinateInfo")), Map.class);
    List<Coordinate> info = Arrays.asList(mapper.readValue(mapper.writeValueAsString(coordinate.get("coordinate")), Coordinate[].class));

    return info.get(0);
}
```



> POST

```java
private RouteGuidanceResponse routeGuidance(RouteGuidanceRequest request) throws URISyntaxException, JsonProcessingException {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();

    RouteBody routeBody = RouteBody.builder()
            .endX(request.getEndX())
            .endY(request.getEndY())
            .startX(request.getStartX())
            .startY(request.getStartY())
            .totalValue(2)
            .build();

    headers.add("Accept-Language", "ko");
    headers.add("appKey",appKey);
    headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

    URI url = new URI("https://apis.openapi.sk.com/tmap/routes?version=1");

    ObjectMapper mapper = new ObjectMapper();
    HttpEntity<RouteBody> rq = new HttpEntity<>(routeBody, headers);
    Map<String, Map> response = restTemplate.postForObject(url, rq, Map.class);

    List<RouteGuidanceResponse> map =
            Arrays.asList(mapper.readValue(mapper.writeValueAsString(response.get("features")), RouteGuidanceResponse[].class));
    return map.get(0);
}
```