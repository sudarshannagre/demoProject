package com.demo.demoProject.cofiguration;

import com.amazonaws.services.polly.AmazonPolly;
import com.amazonaws.services.polly.AmazonPollyClientBuilder;
import com.amazonaws.services.polly.model.OutputFormat;
import com.amazonaws.services.polly.model.SynthesizeSpeechRequest;
import com.amazonaws.services.polly.model.SynthesizeSpeechResult;
import com.amazonaws.services.polly.model.VoiceId;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
 
public class SynthesizeSpeechSample {
    AmazonPolly client = AmazonPollyClientBuilder.standard().build();
 
    public void synthesizeSpeech() {
        String outputFileName = "d:\\/tmp/speech.mp3";
 
        SynthesizeSpeechRequest synthesizeSpeechRequest = new SynthesizeSpeechRequest()
                .withOutputFormat(OutputFormat.Mp3)
                .withVoiceId(VoiceId.Joanna)
                .withText("This is a sample text to be synthesized.");
 
        try (FileOutputStream outputStream = new FileOutputStream(new File(outputFileName))) {
            SynthesizeSpeechResult synthesizeSpeechResult = client.synthesizeSpeech(synthesizeSpeechRequest);
            byte[] buffer = new byte[2 * 1024];
            int readBytes;
 
            try (InputStream in = synthesizeSpeechResult.getAudioStream()){
                while ((readBytes = in.read(buffer)) > 0) {
                    outputStream.write(buffer, 0, readBytes);
                }
            }
        } catch (Exception e) {
            System.err.println("Exception caught: " + e);
        }
    }
    
   // AmazonPolly client = AmazonPollyClientBuilder.standard().build();
    SynthesizeSpeechRequest request = new SynthesizeSpeechRequest().withLexiconNames("example").withOutputFormat("mp3").withSampleRate("8000")
            .withText("All Gaul is divided into three parts").withTextType("text").withVoiceId("Joanna");
    SynthesizeSpeechResult response = client.synthesizeSpeech(request);
}

class Demo{
	public static void main(String[] args) {
		new SynthesizeSpeechSample().synthesizeSpeech();
	}
}