package ch3.arround_pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProcessFileV1 {

    public String processFile() throws IOException {
        try(BufferedReader br =
                new BufferedReader(new FileReader("test.txt"))) {
            return br.readLine();
        }
    }

}
