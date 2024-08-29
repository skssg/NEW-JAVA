package test240731.object1;

public class Vegetable extends Farm{
	private String neme;

	public Vegetable() {
		super();
	}

	public Vegetable(String kind, String neme) {
		super(kind);
		this.neme = neme;
	}

	public String getNeme() {
		return neme;
	}

	public void setNeme(String neme) {
		this.neme = neme;
	}

	@Override
	public String toString() {
		return "Vegetable [neme=" + neme + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
}
