package ch3.arround_pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@FunctionalInterface
interface BufferedReaderProcessor {
    String process(BufferedReader br) throws IOException;
}

public class ProcessFileV2 {

    public static void main(String[] args) throws IOException {

        // 한 행을 처리하는 코드
        String oneLine = processFile((BufferedReader br) -> br.readLine());

        // 두 행을 처리하는 코드
        String twoLine = processFile((BufferedReader br) -> br.readLine() + br.readLine());

        // 한 행만 처리할 수 있는 V1에 비해 동작을 파라미터화했기에 더욱 유연한 코드가 되었다.
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try(BufferedReader br =
                new BufferedReader(new FileReader("test.txt"))) {
            return p.process(br);
        }
    }

}
