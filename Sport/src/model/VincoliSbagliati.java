package model;

public class VincoliSbagliati extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VincoliSbagliati()
	{
		super("I dati inseriti non rispettano i vincoli");
	}
}
