import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileOutputTest {
    public static void main(String[] args){
        String randomStr = "specialComponent";
        String path = "d://"+randomStr+".xml";
        try {
            FileInputStream out = new FileInputStream(path);
            //FileOutputStream out = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
