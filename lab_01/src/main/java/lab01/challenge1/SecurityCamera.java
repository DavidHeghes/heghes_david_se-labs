package lab01.challenge1;

public class SecurityCamera extends Device {
    private boolean isRecording;

    public SecurityCamera(String name){
        super(name);
        this.isRecording = false;
    }

    public void startRecording(){
        this.isRecording = true;
    }

    public void stopRecording(){
        this.isRecording = false;
    }

    @Override
    public double powerUsage() {
        if (!isOn()){
            return 0.0;
        }

        if (isRecording){
            return 8.0;
        } else {
            return 5.0;
        }
    }

    @Override
    public String status() {
        return "Camera " + getName() + " are starea " + (isOn() ? "pornit si " + (isRecording ? "inregistreaza" : "nu inregistreaza") : "oprit");
    }
}