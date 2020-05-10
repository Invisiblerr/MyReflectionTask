package ru.qdts.p1;

public class Mystery {
	
	public Mystery(boolean p4) {
		super();
		this.p4 = p4;
	}

	public Mystery(String p1, int p2, float p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}

	private String p1;
	private int p2;
	
	protected float p3;
	
	public boolean p4;
	
	public static int solved = -1;
	public static int bohemianField = -1;
	public static int mainQuestionAnswer = 42;
	
	public static final String CONSTRUCTOR_ARG1 = "ololo";
	public static final int CONSTRUCTOR_ARG2 = 123;
	public static final float CONSTRUCTOR_ARG3 = 678.9f;

	public String getP1() {
		return p1;
	}

	public int getP2() {
		return p2;
	}

	public void setP2(int p2) {
		this.p2 = p2;
	}

	public void setP3(float p3) {
		this.p3 = p3;
	}

	public boolean isP4() {
		return p4;
	}

	public void setP4(boolean p4) {
		this.p4 = p4;
	}
	
	public String solveMystery(int par1) {
		solved = par1;
		return "yee";
	}
	
	
	
}
