package test.main;

/*
 * 4. 논리연산자 테스트
 */
public class MainClass04 {
	public static void main(String[] args) {
		// or연산
		/*
		 * 또는 이라고 읽으면 된다. 어느 하나만 true면 결과는 true, 모두 false일때만 false
		 */
		boolean result1 = false || false; // false
		boolean result2 = false || true; // true
		boolean result3 = true || false; // true
		boolean result4 = true || true; // true
		// and연산
		/*
		 * 그리고 라고 읽으면 된다. 모두 true일때만 true 어느 하나만 false면 결과는 false
		 */
		boolean result5 = false && false; // false
		boolean result6 = false && true; // false
		boolean result7 = true && false; // false
		boolean result8 = true && true; // true
		// not연산
		/*
		 * ~가 아니면 이라고 읽으면 된다. boolean값을 반전시킨다.
		 */
		boolean result9 = !true; // false
		boolean result10 = !false; // true

	}
}
