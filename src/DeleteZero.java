import java.io.*;

public class DeleteZero {

    public static void main(String[] args) throws IOException {

        String inDirectory = "h:/tmp/example.jpg";
        String outDirectory = "h:/tmp/example_.jpg";

        File inFile = null;
        File outFile = null;
        InputStream in = null;
        OutputStream out = null;

        try {
            inFile = new File(inDirectory);
            outFile = new File(outDirectory);

            in = new BufferedInputStream(new FileInputStream(inFile), 64 * 1024);
            out = new BufferedOutputStream(new FileOutputStream(outFile, false), 64 * 1024);

            long startTime = System.currentTimeMillis();
            copyWithoutZero(in, out);
            long deltaTime = System.currentTimeMillis() - startTime;
            System.out.println("deltaTime: " + deltaTime);

        } catch (IOException e) {
            closeOut(out);
            deleteFile(outFile);
            throw new IOException("Exception when copy from file '" + inFile + "' to file '" + outFile + "'", e);


        } finally {
            closeIn(in);
            closeOut(out);
        }
    }

    private static void copyWithoutZero(InputStream in, OutputStream out) throws IOException {
        boolean hasData = false;
        byte[] buff = new byte[64 * 1024];
        int value;

        while ((value = in.read(buff)) != -1) {
            int begin = 0;
            for (int index = 0; index < value; index++) {
                if (index == value - 1 && buff[index] != 0) {
                    out.write(buff, begin, index + 1 - begin);
                    hasData = false;
                    break;
                }
                if (buff[index] == 0) {
                    if (hasData) {
                        out.write(buff, begin, index - begin);
                        hasData = false;
                    }
                    begin = index + 1;
                } else {
                    hasData = true;
                }
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

    private static void deleteFile(File file) {

        if (file != null) {
            try {
                file.delete();
            } catch (RuntimeException ignore) {
                //NOP
            }
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
}
