package test.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

/*
 *  run�� ������ �ζǹ�ȣ 6���� �����ϰ� ����ϴ� �ڵ带 �ۼ��غ�����.
 *  1~45 ������ ���� �߿� 6���� ���;� �ϸ�
 *  �ߺ��Ǵ� ���ڰ� ������ �ȵǰ� ���� ���ں��� ū���ڱ��� ���ı����ؼ� ����غ�����.
 */
public class QuizMain {
	public static void main(String[] args) {
		// ***������ �ڵ�***
		Random ran = new Random();

		// �ߺ��� �����Ͱ� ������� �ʴ� ������ ������ �� �ִ� Set ��ü ����
		Set<Integer> st = new HashSet<>();

		// ���� ���� ���鼭
		while (true) {
			// ������ ���ڸ� ����
			int ranNum = ran.nextInt(45) + 1;
			// Stack ��ü�� ���� ��Ű��
			st.add(ranNum);
			// ��ȣ�� 6���� �Ǹ� Ż���ϱ�
			if (st.size() == 6) {
				break;
			}
		}

		// Set�� �ִ� �����͸� ArrayList�� ���
		List<Integer> nums = new ArrayList<>(st);
		Collections.sort(nums); // ����

		for (int tmp : nums) {
			System.out.print(tmp + " ");
		}

		/*
		 * ***���� § �ڵ�*** 
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
