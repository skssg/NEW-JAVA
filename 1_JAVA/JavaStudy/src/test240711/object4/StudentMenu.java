package test240711.object4;

public class StudentMenu { // 학생정보와 성적, 결과 출력하는 기본생성자
	private StudentController ssm = new StudentController();

	public StudentMenu() {
		// StudentController에 printStudent()의 반환 값을 통해 학생 정보 출력
		System.out.println("========== 학생 정보 출력 ==========");
		Student[] stArr = ssm.printStudent();
		for(int i=0; i<stArr.length; i++) {
			String stInfo = stArr[i].inform();
			System.out.println(stInfo);
		}
	
		// StudentController에 avgScore()를 통해 점수 합계와 평균 출력
		System.out.println("========== 학생 성적 출력 ==========");
		double[] avgArr = ssm.avgScore();
		System.out.println("학생 점수 합계 : " + avgArr[0]);
		System.out.println("학생 점수 평균 : " + avgArr[1]);
		
		// 학생의 점수가 CUT_LINE 미만이면 재시험 대상, 이상이면 통과 출력
		System.out.println("========== 성적 결과 출력 ==========");
		for(int i=0; i < stArr.length; i++) {
			if(ssm.CUT_LINE > stArr[i].getScore()) {
				System.out.println(stArr[i].getName() + "학생은 재시험 대상입니다.");
			} else {
				System.out.println(stArr[i].getName() + "학생은 통과입니다.");
			}
		}
		
	}
	
}
