

/**
 * @author Stagiaire
 * @version 1.0
 * @created 15-juil.-2021 09:17:59
 */
public class CardClass extends Card {

	private int classID;
	private String className;
	private String classDescription;
	private Energy classEnergy;

	public CardClass(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	/**
	 * 
	 * @param _name
	 * @param _description
	 * @param _energy
	 */
	public CardClass(String _name, String _description, Energy _energy){

	}

	public int getClassID(){
		return 0;
	}

	public String getClassName(){
		return "";
	}

	/**
	 * 
	 * @param _description
	 */
	public CardClass setClassDescription(String _description){
		return null;
	}

	public String getClassDescription(){
		return "";
	}

	public Energy getClassEnergy(){
		return null;
	}

	private CardClass autoIncrementClassID(){
		return null;
	}

}