
import java.io.*;

public class FileLab_LookFor {
    public static void main(String[] args) throws  IOException{

        File[] bigImages = lookForBigImage(new File("H:\\tmp\\"));
        for(File file: bigImages){
            System.out.println(file);
        }
    }

    public static File[] lookForBigImage(File root) {

        File [] result = {};
        if(root.isFile()){
            if(isValid(root)){
                result = new File[]{root};
            }
        }else{
            File[] fileArray = root.listFiles();
            if(fileArray != null){
                for (File file : fileArray) {
                    result = concatenate(result, lookForBigImage(file));
                }
            }
        }
        return result;
    }

    public static File[] concatenate(File[] file0, File[] file1) {
        File[] result = new File[file0.length + file1.length];
        System.arraycopy(file0, 0, result, 0, file0.length);
        System.arraycopy(file1, 0, result, file0.length, file1.length);
        return result;
    }

    public static boolean isValid (File file){

        boolean valid = false;

        if(file.length() < 1024 * 1024){
            return false;
        }
        if(file.getName().endsWith(".jpg")){
            valid = true;
        }
        if(file.getName().endsWith(".png")){
            valid = true;
        }
        if(file.getName().endsWith(".bmp")){
            valid = true;
        }
        if(file.getName().endsWith(".gif")){
            valid = true;
        }
        if(file.getName().endsWith(".JPG")){
            valid = true;
        }
        return valid;
    }
}