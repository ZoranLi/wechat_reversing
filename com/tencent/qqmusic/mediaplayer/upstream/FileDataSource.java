package com.tencent.qqmusic.mediaplayer.upstream;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioRecognition;
import java.io.RandomAccessFile;

public class FileDataSource implements IDataSource {
    private long currentPosition;
    private final String filePath;
    private RandomAccessFile randomAccessFile;

    public FileDataSource(String str) {
        this.filePath = str;
    }

    public void open() {
        this.randomAccessFile = new RandomAccessFile(this.filePath, "r");
        this.currentPosition = 0;
    }

    public int readAt(long j, byte[] bArr, int i, int i2) {
        if (this.currentPosition != j) {
            this.randomAccessFile.seek(j);
            this.currentPosition = j;
        }
        int read = this.randomAccessFile.read(bArr, i, i2);
        if (read >= 0) {
            this.currentPosition += (long) read;
        }
        return read;
    }

    public long getSize() {
        return this.randomAccessFile.length();
    }

    public AudioType getAudioType() {
        return AudioRecognition.recognitionAudioFormatExactly(this.filePath);
    }

    public void close() {
        if (this.randomAccessFile != null) {
            this.randomAccessFile.close();
        }
    }
}
