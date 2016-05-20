package media;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.util.Log;

public class AudioCapture {
	
	private static final String LOG_TAG = "AudioRecordTest";
    private String mFileName = null;
    private MediaRecorder mRecorder = null;
    private MediaPlayer   mPlayer = null;
    public MediaRecorder getmyRecorder(){
    	return mRecorder;
    }
    public MediaPlayer getmyPlayer(){
    	return mPlayer;
    }
    public void setRecordnull(){
    	mRecorder=null;
    }
    public void setPlaynull(){
    	mPlayer=null;
    }
    public void setRecorderfile(String mFileName){
    	if(mFileName==null){
    	this.mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        this.mFileName += "/recordtest.3gp";
    	}
    	else
    		this.mFileName=mFileName;

    	
    }
    public void onRecord(boolean start) {
        if (start) {
            startRecording();
        } else {
            stopRecording();
        }
    }

    public void onPlay(boolean start) {
        if (start) {
            startPlaying();
        } else {
            stopPlaying();
        }
    }

    public void startRecording() {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
        	
            Log.e(LOG_TAG, "start record 1 failed"+e.getMessage());
        }
        catch (IllegalStateException e){
        	Log.e(LOG_TAG, "start record 2 failed"+e.getMessage());
        	
        }
        try{
        mRecorder.start();
        }catch (IllegalStateException e){
        	Log.e(LOG_TAG, "start record 3  failed"+e.getMessage());
        	mRecorder=null;
        	mRecorder=new MediaRecorder();
        }
    }
    public void stopRecording() {
    	try{
        mRecorder.stop();
        mRecorder.release();
    	}catch (NullPointerException e){
    		Log.e(LOG_TAG,"stop record 1 failed"+e.getMessage());
    	}catch (IllegalStateException e){
        	Log.e(LOG_TAG, "start record 2  failed"+e.getMessage());
        	mRecorder=null;
        	mRecorder=new MediaRecorder();
        }
        mRecorder = null;
    }
    public void startPlaying() {
        mPlayer = new MediaPlayer();
        try {
            mPlayer.setDataSource(mFileName);
            mPlayer.prepare();
            mPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "play the record failed");
        }
    }

    public void stopPlaying() {
    	try{
        mPlayer.release();
        mPlayer = null;
    	} catch(NullPointerException e){
    		Log.e(LOG_TAG, "stop play failed");
    	}
    }

    public String toString() {

        return "this is a class to record audio";

    }


}
