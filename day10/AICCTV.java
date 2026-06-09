package day10;

class CCTV {
	private String resolution;
	
	// 생성자 
	public CCTV(String resolution) { 
		this.resolution = resolution; 
	}
	
	// getter() 메소드 
	public String getResolution() { 
		return resolution; 
	}
}


public class AICCTV extends CCTV {
	boolean facecheck;
	public AICCTV(String resolution, boolean facecheck) {
		super(resolution);
		this.facecheck = facecheck;
	}
	
	//get 사용
	String re = super.getResolution(); 
	public void printInfo() {
		if(re.equals("FHD")) {
			System.out.println("CCTV는 FHD급 해상도이고, 현재 얼굴인식 작동중.");
		}
		else {
			System.out.println("해상도가 낮습니다.");
		}
	}
	
	public static void main(String[] args) {
		AICCTV ai = new AICCTV("FHD", true);
		ai.printInfo();
	}

}
