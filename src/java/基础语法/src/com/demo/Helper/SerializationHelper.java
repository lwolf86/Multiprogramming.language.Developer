package com.demo.Helper;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;

public class SerializationHelper {
    public static <T> T FromXml(String xml) {
        var in = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        var bufer = new BufferedInputStream(in);
        try (var decoder = new XMLDecoder(bufer)) {
            return (T) decoder.readObject();
        }
    }

    public static <T> String ToXml(T entity) {
        var out = new ByteArrayOutputStream();
        var bufer = new BufferedOutputStream(out);
        try (var encoder = new XMLEncoder(bufer)) {
            encoder.writeObject(entity);
            encoder.flush();
            encoder.close();
            return out.toString(StandardCharsets.UTF_8);
        }


    }
}
