package com.tanco.quiz.ver2;

import java.sql.SQLException;
import java.util.List;

public class MainTest1 {

	public static void main(String[] args) {
		QuizRepositoryImpl quizRepositoryImpl = new QuizRepositoryImpl();
		try {
			List<QuizDTO> quizDtos = quizRepositoryImpl.viewQuizQuestion();
			for (QuizDTO quizDTO : quizDtos) {
				System.out.println(quizDTO);
			}
			
			QuizDTO dto = quizRepositoryImpl.playQuizGame();
			System.out.println(dto);
			
			System.out.println("정답을 맞춰 주세요");
			System.out.println(dto.getQuestion());
			String userInput = "한국";
			if(dto.getAnswer().equalsIgnoreCase(userInput)) {
				System.out.println("정답입니다");
			} else {
				System.out.println("오답이겠지뭐");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
