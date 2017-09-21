import static org.junit.Assert.*;

import org.junit.Test;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class TennisGameTest {
	
// Here is the format of the scores: "player1Score - player2Score"
// "love - love"
// "15 - 15"
// "30 - 30"
// "deuce"
// "15 - love", "love - 15"
// "30 - love", "love - 30"
// "40 - love", "love - 40"
// "30 - 15", "15 - 30"
// "40 - 15", "15 - 40"
// "player1 has advantage"
// "player2 has advantage"
// "player1 wins"
// "player2 wins"
	@Ignore
	public void testTennisGame_Start() {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Initial score incorrect", "love - love", score);		
	}
	
	@Test
	public void testTennisGame_EahcPlayerWin4Points_Score_Deuce() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		
		game.player2Scored();
		game.player2Scored();
		game.player2Scored();
		
		game.player1Scored();
		game.player2Scored();
		//Act
		String score = game.getScore() ;
		// Assert
		assertEquals("Tie score incorrect", "deuce", score);		
	}
	
	@Test (expected = TennisGameException.class)
	public void testTennisGame_Player1WinsPointAfterGameEnded_ResultsException() throws TennisGameException {
		//Arrange
		TennisGame game = new TennisGame();
		//Act
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		game.player1Scored();
		//Act
		// This statement should cause an exception
		game.player1Scored();			
	}
	@Test
	public void test_Player2Wins() throws TennisGameException{
	// Arrange
	TennisGame g = new TennisGame();
	//Act
	g.player2Scored();
	g.player2Scored();
	g.player2Scored();
	g.player2Scored();
	//g.player2Scored();
	
	assertEquals("player1 love","player2 wins",g.getScore());
	}
	
	@Test
	public void test_15_love() throws TennisGameException{
		//Arrange
		TennisGame g = new TennisGame();
		//Act
		g.player1Scored();
		assertEquals("player2love - player1wins1point","love - 15",g.getScore());
		
	}
	
	@Test
	public void test_15_15() throws TennisGameException{
		//Arrange
		TennisGame g = new TennisGame();
		//Act
		g.player1Scored();
		g.player2Scored();
		assertEquals("player2_15 - player1_15","15 - 15",g.getScore());
		
	}	

	@Test
	public void test_Deuce() throws TennisGameException{
		//Arrange
		TennisGame g = new TennisGame();
		//Act	
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		assertEquals("player2_3points - player1_3points","deuce",g.getScore());
	
	}
	@Test
	public void test_AdvPlayer2() throws TennisGameException{
		//Arrange
		TennisGame g = new TennisGame();
		//Act
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player2Scored();
		assertEquals("player2_5p,player1_4p","player2 has advantage",g.getScore());
	
	}	
	@Test
	public void test_AdvPlayer2_4_3() throws TennisGameException{
		//Arrange
		TennisGame g = new TennisGame();
		//Act
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player1Scored();
		g.player2Scored();
		g.player2Scored();
		assertEquals("player2_4p,player1_3p","player2 has advantage",g.getScore());
	
	}		
	
}
