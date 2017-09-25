package com.tencent.qqmusic.mediaplayer.seektable;

import java.io.InputStream;

public interface SeekTable {
    void parse(InputStream inputStream);

    long seek(long j);
}
