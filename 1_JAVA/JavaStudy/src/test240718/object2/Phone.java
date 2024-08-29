package test240718.object2;

public interface Phone {
	// static final (생략가능)
	static final char[] NUMBERPAD = {'1','2','3','4','5','6','7','8','9','*','0','#'}; 
	
	// public abstract (생략가능)
	public abstract String makeCall();
	public abstract String takeCall(); 
}
