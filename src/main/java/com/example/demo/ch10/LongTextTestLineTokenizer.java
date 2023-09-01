package com.example.demo.ch10;

import java.util.ArrayList;
import java.util.List;
import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FieldSetFactory;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class LongTextTestLineTokenizer implements LineTokenizer {

    private String delimiter = "delimiter;";

    private String[] columns = new String[] {
            "content", "name", "desc1", "desc2", "age"
    };

    private FieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();

    @Override
    public FieldSet tokenize(String record) {
        String[] fields = record.split(delimiter);

        List<String> parsedFields = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {
            parsedFields.add(fields[i]);
        }

        return fieldSetFactory.create(parsedFields.toArray(String[]::new), columns);
    }

}
