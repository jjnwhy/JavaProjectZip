package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/*
 *  run을 누르면 로또번호 6개를 랜덤하게 출력하는 코드를 작성해보세요.
 *  1~45 사이의 숫자 중에 6개가 나와야 하며
 *  중복되는 숫자가 있으면 안되고 작은 숫자부터 큰숫자까지 정렬까지해서 출력해보세요.
 */
public class QuizMain {
	public static void main(String[] args) {
		// ***선생님 코드***
		Random ran = new Random();

		// 중복된 데이터가 저장되지 않는 정수를 저장할 수 있는 Set 객체 생성
		Set<Integer> st = new HashSet<>();

		// 무한 루프 돌면서
		while (true) {
			// 랜덤한 숫자를 얻어내서
			int ranNum = ran.nextInt(45) + 1;
			// Stack 객체에 누적 시키기
			st.add(ranNum);
			// 번호가 6개가 되면 탈출하기
			if (st.size() == 6) {
				break;
			}
		}

		// Set에 있는 데이터를 ArrayList에 담고
		List<Integer> nums = new ArrayList<>(st);
		Collections.sort(nums); // 정렬

		for (int tmp : nums) {
			System.out.print(tmp + " ");
		}

		/*
		 * ***내가 짠 코드*** 
		 * 
		 * List<List<Integer>> lottos = new ArrayList<>();
		 * 
		 * for(int i=0;i<3;i++) {
		 * 
		 * Set<Integer> num = new HashSet<>(); 
		 * List<Integer> lotto = new ArrayList<>();
		 * 
		 * while (num.size() < 6) { 
		 * Random ran = new Random(); 
		 * int tmp = ran.nextInt(45) + 1; 
		 * num.add(tmp); 
		 * } 
		 * 
		 * lotto.addAll(num); 
		 * Collections.sort(lotto);
		 * 
		 * lottos.add(lotto);
		 * } 
		 * 
		 * for(List<Integer> tmp:lottos) { 
		 * System.out.println(tmp); 
		 * }
		 */

	}

}
