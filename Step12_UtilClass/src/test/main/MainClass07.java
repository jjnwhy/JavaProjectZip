package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * HashMap<key값의 type, value값의 type>
		 * key의 Generic class는 String으로 지정하는 것이 일반적이다.
		 * value의 Generic class는 담을 데이터 type을 지정하면 된다.
		 * 여러 개의 type을 섞어서 담을거면 Object로 지정하면 된다.
		 * 
		 */
		final Map<String, Object> map1 = new HashMap<>();
		
		
		/*
		 *  위에서 생성한 HashMap 객체에 다음과 같은 정보 3가지를 담아보세요.
		 *  번호 : 1
		 *  이름 : 김구라
		 *  남자인지 여부 : true
		 */
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("isMan", true);
		
		// map1에 담긴 번호는 num, 이름은 name, 남자인지 여부는 isMan 이라는 지역변수에 담아보세요.
		int num = (int) map1.get("num");
		String name = (String) map1.get("name");
		boolean isMan = (boolean) map1.get("isMan");
		
		// 동일한 key값으로 다시 담으면 수정
		map1.put("name", "에이콘");
		
		// 특정 key값으로 담긴 내용 삭제, 성공하면 true, 실패하면 false return;
		map1.remove("isMan");
		
		// 모두 삭제
		map1.clear();
		
	}
}
