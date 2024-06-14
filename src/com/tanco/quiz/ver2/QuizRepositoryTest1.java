package com.tanco.quiz.ver2;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import com.tanco.quiz.DBConnectionManager;

public class QuizRepositoryTest1 {

	public static void main(String[] args) {
		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();
		try (Connection conn = DBConnectionManager.getConnection(); 
				Scanner scanner = new Scanner(System.in))  {
			while (true) {
				printMenu();

				int choice = scanner.nextInt(); // 블로킹

				if (choice == 1) {
					// 퀴즈 문제 추가 --> 함수로 만들기
					scanner.nextLine();
					// 문제를 적어주세요
					System.out.println("문제를 입력해 주세요.");
					String question = scanner.nextLine();
					// 답을 적어주세요
					System.out.println("정답을 입력해 주세요.");
					String answer = scanner.nextLine();
					quizRepositoryImpl.addQuizQuestion(question, answer);
				} else if (choice == 2) {
					// 퀴즈 문제 조회 --> 함수로 만들기
					quizRepositoryImpl.viewQuizQuestion();
					List<QuizDTO> quizDTO = quizRepositoryImpl.viewQuizQuestion();
					for (QuizDTO quizDTO2 : quizDTO) {
						System.out.println(quizDTO2);
					}
					System.out.println("Enter 키 를 눌러주세요");
					scanner.next();
				} else if (choice == 3) {
					// 퀴즈 게임 시작 --> 함수로 만들기
					quizRepositoryImpl.playQuizGame();
					QuizDTO dto = quizRepositoryImpl.playQuizGame();
					System.out.println(dto.getQuestion());
					scanner.nextLine();
					String userAnswer = scanner.nextLine();
					if(dto.getAnswer().equalsIgnoreCase(userAnswer)) {
						
						System.out.println("정답");
					} else {
						System.out.println("오답");
					}
					System.out.println("Enter 키 를 눌러주세요");
					scanner.nextLine();
				} else if (choice == 4) {
					System.out.println("프로그램을 종료 합니다");
					break;
				} else {
					System.out.println("잘못된 선택입니다. 다시 시도하세요");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void printMenu() {
		System.out.println();
		System.out.println("------------------------------------------");
		System.out.println("1. 퀴즈 문제 추가");
		System.out.println("2. 퀴즈 문제 조회");
		System.out.println("3. 퀴즈 게임 시작");
		System.out.println("4. 종료");
		System.out.println("옵션을 선택 하세요 : ");
		
	}
}