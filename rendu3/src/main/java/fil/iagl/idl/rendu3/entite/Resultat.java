package fil.iagl.idl.rendu3.entite;

public class Resultat {
	int blackSuccess;
	int blackFail;
	int whiteSuccess;
	int whiteFail;

	public int getBlackSuccess() {
		return blackSuccess;
	}

	public void setBlackSuccess(int blackSuccess) {
		this.blackSuccess = blackSuccess;
	}

	public int getBlackFail() {
		return blackFail;
	}

	public void setBlackFail(int blackFail) {
		this.blackFail = blackFail;
	}

	public int getWhiteSuccess() {
		return whiteSuccess;
	}

	public void setWhiteSuccess(int whiteSuccess) {
		this.whiteSuccess = whiteSuccess;
	}

	public int getWhiteFail() {
		return whiteFail;
	}

	public void setWhiteFail(int whiteFail) {
		this.whiteFail = whiteFail;
	}

	@Override
	public String toString() {
		return "Resultat [blackSuccess=" + blackSuccess + ", blackFail=" + blackFail + ", whiteSuccess=" + whiteSuccess
				+ ", whiteFail=" + whiteFail + "]";
	}

	public boolean isBetterThan(Resultat max) {
		return this.getWhiteSuccess() + this.getBlackSuccess() > max.getBlackSuccess() + max.getWhiteSuccess();
	}

}
