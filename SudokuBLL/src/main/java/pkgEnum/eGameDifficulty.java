package pkgEnum;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public enum eGameDifficulty {

	EASY(100), MEDIUM(500), HARD(1000);

	private final int iDifficulty;
	
	public int MaxMistakes(int iDifficulty) {
		int mistakes = 0;
		if(getiDifficulty() >= 100) {
			mistakes = 5;
		} else if(getiDifficulty() >= 500) {
			mistakes = 4;
		} else {
			mistakes = 3;
		} return mistakes;
		
	}

	private static final Map<Integer, eGameDifficulty> lookup = new HashMap<Integer, eGameDifficulty>();

	static {
		for (eGameDifficulty d : eGameDifficulty.values()) {
			lookup.put(d.getiDifficulty(), d);
		}
	}

	private eGameDifficulty(int iDifficulty) {
		this.iDifficulty = iDifficulty;
	}

	public int getiDifficulty() {
		return iDifficulty;
	}

	@Override
	public String toString() {
		return this.name().substring(0, 1).toUpperCase() + this.name().substring(1).toLowerCase();
	}

	/**
	 * get - return the right enum by name
	 * 
	 * @param strName
	 * @return
	 */
	public static eGameDifficulty get(String strName) {
		for (eGameDifficulty eGD : eGameDifficulty.values()) {
			System.out.println(eGD.name().toUpperCase());
			if (eGD.name().toUpperCase().equals(strName.toUpperCase())) {
				return eGD;
			}
		}
		return null;
	}

	/**
	 * get - return the right enum by iDifficulty score.
	 * 
	 * @param strName
	 * @return
	 */

	public static eGameDifficulty get(int iDifficulty) {

		Iterator it = lookup.entrySet().iterator();
		eGameDifficulty eGD = null;

		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			eGameDifficulty enumDifficulty = (eGameDifficulty) pair.getValue();
			int iDifficultyValue = (int) pair.getKey();
			if (iDifficulty > iDifficultyValue) {
				eGD = enumDifficulty;
			}
		}
		return eGD;
	}
}
