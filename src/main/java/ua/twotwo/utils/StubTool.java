package ua.twotwo.utils;

import java.io.InputStream;
import java.util.Scanner;

public class StubTool {
    private static final String rootFolderStubs = "stubs/";

    public static String readStubFromResource(final String pathToStub) {
        StringBuilder stubData = new StringBuilder("");
        ClassLoader classLoader = StubTool.class.getClassLoader();
        InputStream fileIS = classLoader.getResourceAsStream(rootFolderStubs.concat(pathToStub));
        try (Scanner scanner = new Scanner(fileIS)) {
            while (scanner.hasNext()) {
                stubData.append(scanner.nextLine().trim());
            }
        }
        return stubData.toString();
    }
}
