package com.qq.taf.jce.dynamic;

import com.qq.taf.jce.JceDecodeException;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.nio.ByteBuffer;

public final class DynamicOutputStream extends JceOutputStream {
    public DynamicOutputStream(ByteBuffer byteBuffer) {
        super(byteBuffer);
    }

    public DynamicOutputStream(int i) {
        super(i);
    }

    public final void write(JceField jceField) {
        int i = 0;
        int tag = jceField.getTag();
        if (jceField instanceof ZeroField) {
            write(0, tag);
        } else if (jceField instanceof IntField) {
            write(((IntField) jceField).get(), tag);
        } else if (jceField instanceof ShortField) {
            write(((ShortField) jceField).get(), tag);
        } else if (jceField instanceof ByteField) {
            write(((ByteField) jceField).get(), tag);
        } else if (jceField instanceof StringField) {
            write(((StringField) jceField).get(), tag);
        } else if (jceField instanceof ByteArrayField) {
            write(((ByteArrayField) jceField).get(), tag);
        } else if (jceField instanceof ListField) {
            ListField listField = (ListField) jceField;
            reserve(8);
            writeHead((byte) 9, tag);
            write(listField.size(), 0);
            JceField[] jceFieldArr = listField.get();
            int length = jceFieldArr.length;
            while (i < length) {
                write(jceFieldArr[i]);
                i++;
            }
        } else if (jceField instanceof MapField) {
            MapField mapField = (MapField) jceField;
            reserve(8);
            writeHead((byte) 8, tag);
            tag = mapField.size();
            write(tag, 0);
            while (i < tag) {
                write(mapField.getKey(i));
                write(mapField.getValue(i));
                i++;
            }
        } else if (jceField instanceof StructField) {
            StructField structField = (StructField) jceField;
            reserve(2);
            writeHead((byte) 10, tag);
            for (JceField write : structField.get()) {
                write(write);
            }
            reserve(2);
            writeHead(JceStruct.STRUCT_END, 0);
        } else if (jceField instanceof LongField) {
            write(((LongField) jceField).get(), tag);
        } else if (jceField instanceof FloatField) {
            write(((FloatField) jceField).get(), tag);
        } else if (jceField instanceof DoubleField) {
            write(((DoubleField) jceField).get(), tag);
        } else {
            throw new JceDecodeException("unknow JceField type: " + jceField.getClass().getName());
        }
    }
}
