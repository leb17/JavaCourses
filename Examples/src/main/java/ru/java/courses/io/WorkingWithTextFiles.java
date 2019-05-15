package ru.java.courses.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;

public class WorkingWithTextFiles {

    public static void main(String[] args) {
        copy();
    }

    private static final Logger LOG = LoggerFactory.getLogger(WorkingWithTextFiles.class);

    public static void copy() {
        File inputFile = new File("files/input.txt");
        File outputFile = new File("files/output2.txt");
        final char buffSize = 1024;

        LOG.info(
                "Trying to copy file. Source: {} and destination: {}, buf {}",
                inputFile.getAbsolutePath(),
                outputFile.getAbsolutePath(),
                buffSize
        );

        if (inputFile.isDirectory() || !inputFile.exists()) {
            IllegalStateException e = new IllegalStateException("File not found");
            LOG.error("File not found", e);
            throw e;
        }

        if (outputFile.isDirectory()) {
            throw new IllegalStateException("Invalid path to file");
        }

        if (outputFile.exists()) {
            LOG.warn("Destination file exists");
            boolean deleted = outputFile.delete();
            if (!deleted) {
                throw new RuntimeException("Can't remove file " + outputFile.getAbsolutePath());
            }
        }

        try (
                FileReader fr = new FileReader(inputFile);
                BufferedReader br = new BufferedReader(fr, buffSize);

                FileWriter fw = new FileWriter(outputFile);
                BufferedWriter bw = new BufferedWriter(fw, buffSize);
        ) {

            char[] buf = new char[buffSize];
            int off = 0;
            int count = 0;

            while (-1 != br.read(buf)) {
                bw.write(buf, off, buf.length);
                off += buf.length;
                count++;
            }

            bw.flush();

        } catch (IOException e) {
            LOG.error("Error while creating a copy of file", e);
            // shit happens
        }
    }
}
