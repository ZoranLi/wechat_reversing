package com.tencent.mm.modelvideo;

import android.media.MediaExtractor;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;

public final class q {
    private static String D(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(toHexString);
        }
        return stringBuilder.toString();
    }

    public static boolean lo(String str) {
        w.d("MicroMsg.VideoFile", " filepath " + str);
        if (bg.mA(str)) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[10];
            fileInputStream.read(bArr, 0, 10);
            String toUpperCase = D(bArr).toUpperCase();
            fileInputStream.close();
            w.d("MicroMsg.VideoFile", "file type " + toUpperCase);
            if (!toUpperCase.contains("00000014667479707174")) {
                return false;
            }
            w.d("MicroMsg.VideoFile", "file type qt ");
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.VideoFile", "exception:%s", bg.g(e));
            return false;
        }
    }

    public static boolean lp(String str) {
        if (!e.aO(str)) {
            return false;
        }
        w.d("MicroMsg.VideoFile", "check is h265 video %s", str);
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            mediaExtractor.setDataSource(str);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                String str2 = null;
                str2 = mediaExtractor.getTrackFormat(i).getString("mime");
                if ("video/hevc".equalsIgnoreCase(str2)) {
                    return true;
                }
                if ("video/hevc".equalsIgnoreCase(str2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.VideoFile", th, "check is h265 video %s", str);
            return false;
        }
    }

    public static boolean lq(String str) {
        w.d("MicroMsg.VideoFile", " filepath " + str);
        if (bg.mA(str)) {
            return false;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[7];
            fileInputStream.read(bArr, 0, 7);
            String toUpperCase = D(bArr).toUpperCase();
            fileInputStream.close();
            w.d("MicroMsg.VideoFile", "file type " + toUpperCase);
            if (!toUpperCase.contains("234558544D3355")) {
                return false;
            }
            w.d("MicroMsg.VideoFile", "it is m3u8 file");
            return true;
        } catch (Throwable e) {
            w.e("MicroMsg.VideoFile", "exception:%s", bg.g(e));
            return false;
        }
    }
}
