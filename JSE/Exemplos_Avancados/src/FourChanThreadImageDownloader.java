import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FourChanThreadImageDownloader {

    private static void usage() {
        System.out.println("java FourChanThreadImageDownloader <url> <folder>");
        System.exit(1);
    }

    public static void main(String[] args) {
        if(args.length < 2)
            usage();

        final String url = args[0];
        final String targetDirName = args[1];
        final Pattern imageUrlSyntax =
                Pattern.compile("(//i\\.4cdn\\.org/\\w+/\\d+\\.(?:jpg|webm|gif|png))");
        boolean successfull = false;

        final File targetDir = new File(targetDirName);
        if(!targetDir.exists()) {
            System.out.println("Creating destination directory");
            if(!targetDir.mkdir()) {
                System.out.println("Could not create target directory");
                System.exit(1);
            }
        } else if(!targetDir.canWrite()) {
            System.out.println("Cannot put downloaded images inside destination folder:" +
                " you have not permission to write in this directory.");
            System.exit(1);
        }

        final URL fourChan;
        try {
            fourChan = new URL(url);
        } catch(MalformedURLException e) {
            System.err.println("Mistyped URL");
            return;
        }

         try(final Reader inputReader = new InputStreamReader(fourChan.openStream());
            final BufferedReader bufReader = new BufferedReader(inputReader)) {
            System.out.println("Connecting OK, trying to download images");

            final StringBuilder pageContent = new StringBuilder();

            int c;
            while((c = bufReader.read()) != -1)
                pageContent.append((char) c);

            final Matcher finder = imageUrlSyntax.matcher(pageContent.toString());
            while(finder.find()) {
                final String currImage = "http:" + finder.group();
                final String imageName = currImage.split("/")[4];

                try(final BufferedInputStream targetStream =
                    new BufferedInputStream(new URL(currImage).openStream());
                final ByteArrayOutputStream recipient = new ByteArrayOutputStream()) {
                    System.out.println("Downloading: " + currImage);

                    int d;
                    int notifyCounter = 0;
                    while((d = targetStream.read()) != -1) {
                        recipient.write(d);
                        if(notifyCounter == 8196) {
                            System.out.print('.');
                            notifyCounter = 0;
                        }
                        notifyCounter++;
                    }

                    System.out.println("\nImage successfully downloaded");
                    final File nextImage = new File(targetDir, imageName);
                    final BufferedOutputStream image =
                        new BufferedOutputStream(new FileOutputStream(nextImage));
                    System.out.println("Saving image in " + nextImage.toString());
                    recipient.writeTo(image);
                    image.flush();
                    image.close();
                    successfull = true;
                }
            }
        } catch(IOException e) {
            if(e instanceof FileNotFoundException)
                System.out.println("Cannot download images: Thread not found (404)");
            else
                System.out.println("An error occurred: " + e.getLocalizedMessage());
            successfull = false;
        }

        if(successfull)
            System.out.println("Success");
    }
}