class ColorPoint extends MyPoint {
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void showColorPoint() {
		System.out.println(color);
		showPoint();
		
	}

}