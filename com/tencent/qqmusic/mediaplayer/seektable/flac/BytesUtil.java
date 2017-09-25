package com.tencent.qqmusic.mediaplayer.seektable.flac;

public class BytesUtil {
    public static int from(byte[] bArr) {
        if (bArr.length > 4) {
            throw new RuntimeException("bytes can't be greater than 32 bit!");
        } else if (bArr.length == 3) {
            return (((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255);
        } else {
            if (bArr.length == 2) {
                return ((bArr[0] & 255) << 8) | (bArr[1] & 15);
            }
            if (bArr.length == 1) {
                return bArr[0] & 255;
            }
            throw new RuntimeException("bytes must be greater than 8 bit!");
        }
    }
}
