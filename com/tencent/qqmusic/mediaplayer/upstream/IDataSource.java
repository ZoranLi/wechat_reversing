package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import java.io.Closeable;

public interface IDataSource extends Closeable {

    public interface Factory {
        IDataSource createDataSource();
    }

    AudioType getAudioType();

    long getSize();

    void open();

    int readAt(long j, byte[] bArr, int i, int i2);
}
