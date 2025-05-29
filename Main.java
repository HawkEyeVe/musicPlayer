import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String FilePath = "src\\Blah Blah Blah).wav";
        File file = new File(FilePath);

        try (AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);) {
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            Scanner sc = new Scanner(System.in);
            String response = "";
            while (!response.equals("Q")) {
                System.out.println("P = play, S = stop, R = reset, Q = quit");
                System.out.print("Enter your choice: ");
                response = sc.next();
                switch (response) {
                    case ("P"):
                        clip.start();
                        break;
                    case ("S"):
                        clip.stop();
                        break;
                    case ("R"):
                        clip.setMicrosecondPosition(0);
                        break;
                    case ("Q"):
                        clip.close();
                        break;
                    default:
                        System.out.println("Not a valid response");
                        break;
                }
            }
            sc.close();


            System.out.println("Playing...");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (
                UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("Done");

        }
    }
}



