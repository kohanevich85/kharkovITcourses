import java.io.*;
import java.net.URL;

public class DownloadFromInternet {

    public static void main(String[] args) throws IOException {

        URL url = null;
        File file1 = null;
        File file2 = null;
        InputStream in = null;
        OutputStream out1 = null;
        OutputStream out2 = null;

        try {

            url = new URL("http://www.google.com");
            file1 = new File("h:/tmp/page1.html");
            file2 = new File("h:/tmp/page2.html");
            in = url.openStream();
            out1 = new FileOutputStream(file1, false);
            out2 = new FileOutputStream(file2, false);

            copyToHTML(in, out1, out2);

        } catch (IOException e) {

            closeOut(out1);
            closeOut(out2);
            deleteFile(file1);
            deleteFile(file2);
            throw new IOException("Exception when copy from url '" + url + "' to files '" + file1 + "' and '" + file2 + "'", e);

        } finally {

            closeIn(in);
            closeOut(out1);
            closeOut(out2);
        }

    }

    private static void closeIn(InputStream in) {

        if (in != null) {
            try {
                in.close();
            } catch (Exception ignore) {
                //NOP
            }
        }
    }

    private static void deleteFile(File file) {

        if (file != null) {
            try {
                file.delete();
            } catch (RuntimeException ignore) {
                //NOP
            }
        }
    }

    private static void closeOut(OutputStream out) {
        if (out != null) {
            try {
                out.flush();
            } catch (Exception ignore) {
                //NOP
            }
            try {
                out.close();
            } catch (Exception ignore) {
                //NOP
            }
        }
    }

    private static void copyToHTML(InputStream in, OutputStream out1, OutputStream out2) throws IOException {
        int value;
        byte[] buff = new byte[64 * 1024];
        while ((value = in.read(buff)) != -1) {
            out1.write(buff);
            out2.write(buff);
        }
    }
}