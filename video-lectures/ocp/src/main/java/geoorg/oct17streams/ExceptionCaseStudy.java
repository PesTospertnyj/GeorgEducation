package geoorg.oct17streams;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public class ExceptionCaseStudy {
    private static List<String> create() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) throws IOException {
        create().stream().count();

        Supplier<List<String>> listSupplier1 = ExceptionCaseStudy::createSafe;

        Supplier<List<String>> listSupplier = new Supplier<List<String>>() {
            @Override
            public List<String> get() {
                try {
                    return create();
                } catch (IOException e) {
                    return null;
                }
            }
        };
    }

    private static List<String> createSafe()  {
        try {
            return ExceptionCaseStudy.create();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } }
}