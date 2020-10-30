public class ActivityLog {
	private double playTime;
	private final double maxTime = 24.0;
	@SuppressWarnings("unused")
	private boolean studAdmitted;
	
	public ActivityLog(){
		this.playTime = 8.0;
		this.studAdmitted = false;
	}
	
	public void addPlayTime(double time) {
		this.playTime += time;
	}
	
	public double getPlayTime() {
		return this.playTime;
	}
	
	public void setAdmission() {
		this.studAdmitted = true;
	}
	
	public boolean isTimeDone() {
		if (this.playTime >= this.maxTime) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void Reset(){ //Should be the same as the default constructor
		this.playTime = 8.0;
		this.studAdmitted = false;
	}
	
}
