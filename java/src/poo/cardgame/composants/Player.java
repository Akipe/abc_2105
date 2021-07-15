

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class Player {

	private String nickname;
	private String firstName;
	private String lastName;
	private String email;
	private Card cards;
	public Player m_Player;

	public Player(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param _nickname
	 * @param _firstName
	 * @param _lastName
	 * @param _email
	 */
	public Player(String _nickname, String _firstName, String _lastName, String _email){

	}

	/**
	 * 
	 * @param _nickname
	 */
	public Player setNickname(String _nickname){
		return null;
	}

	public String getNickname(){
		return "";
	}

	public String getFirstName(){
		return "";
	}

	public String getEmail(){
		return "";
	}

	/**
	 * 
	 * @param _player
	 */
	public Player setOpponent(Player _player){
		return null;
	}

	public Player getOpponent(){
		return null;
	}

	public Player removeOpponent(){
		return null;
	}

	public Card[] getHand(){
		return null;
	}

	public Player clearHand(){
		return null;
	}

	/**
	 * 
	 * @param _card
	 */
	public Player addCard(Card _card){
		return null;
	}

	/**
	 * 
	 * @param _card
	 */
	public Player removeCard(Card _card){
		return null;
	}

}