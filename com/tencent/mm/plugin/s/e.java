package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class e {
    private static long nyZ = 0;

    @TargetApi(21)
    public static boolean aKo() {
        if (!d.eo(21)) {
            return false;
        }
        MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
        int length = codecInfos.length;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < length; i++) {
            String a = a(codecInfos[i]);
            if (!bg.mA(a)) {
                arrayList.add(Integer.valueOf(i));
                arrayList2.add(a);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return true;
    }

    public static boolean aKp() {
        if (bg.aA(nyZ) > 86400000) {
            return true;
        }
        return false;
    }

    public static String aKq() {
        w.d("MicroMsg.MediaCodecUtil", "check hevc info last rpt time[%d]", Long.valueOf(nyZ));
        try {
            nyZ = bg.Nz();
            if (!d.eo(21)) {
                return aKr();
            }
            int i;
            long NA = bg.NA();
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            int length = codecInfos.length;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (i = 0; i < length; i++) {
                String a = a(codecInfos[i]);
                if (!bg.mA(a)) {
                    arrayList.add(Integer.valueOf(i));
                    arrayList2.add(a);
                }
            }
            if (arrayList.isEmpty()) {
                return "";
            }
            Object obj = null;
            Object obj2 = null;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            length = 0;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            boolean z = false;
            Object obj3 = null;
            int i9 = 0;
            while (i9 < arrayList.size()) {
                Object obj4;
                int intValue = ((Integer) arrayList.get(i9)).intValue();
                String str = (String) arrayList2.get(i9);
                boolean isEncoder = codecInfos[intValue].isEncoder();
                obj = !codecInfos[intValue].isEncoder() ? 1 : null;
                CodecCapabilities capabilitiesForType = codecInfos[intValue].getCapabilitiesForType(str);
                if (capabilitiesForType != null) {
                    VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                    if (videoCapabilities != null) {
                        i2 = Math.max(((Integer) videoCapabilities.getBitrateRange().getLower()).intValue(), i2);
                        i3 = Math.max(((Integer) videoCapabilities.getBitrateRange().getUpper()).intValue(), i3);
                        i4 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getLower()).intValue(), i4);
                        i5 = Math.max(((Integer) videoCapabilities.getSupportedFrameRates().getUpper()).intValue(), i5);
                        i6 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getLower()).intValue(), i6);
                        i7 = Math.max(((Integer) videoCapabilities.getSupportedWidths().getUpper()).intValue(), i7);
                        i8 = Math.max(((Integer) videoCapabilities.getSupportedHeights().getLower()).intValue(), i8);
                        i = Math.max(((Integer) videoCapabilities.getSupportedHeights().getUpper()).intValue(), length);
                        length = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    } else {
                        i = length;
                        length = i8;
                        i8 = i7;
                        i7 = i6;
                        i6 = i5;
                        i5 = i4;
                        i4 = i3;
                        i3 = i2;
                    }
                    stringBuilder.append(codecInfos[intValue].getName()).append("|");
                    obj4 = obj2;
                    obj2 = 1;
                } else {
                    stringBuilder2.append(codecInfos[intValue].getName()).append("|");
                    obj2 = obj3;
                    int i10 = i8;
                    i8 = i7;
                    i7 = i6;
                    i6 = i5;
                    i5 = i4;
                    i4 = i3;
                    i3 = i2;
                    i2 = 1;
                    i = length;
                    length = i10;
                }
                i9++;
                obj3 = obj2;
                obj2 = obj4;
                i2 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i6;
                i6 = i7;
                i7 = i8;
                i8 = length;
                length = i;
                z = isEncoder;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(1).append(",");
            if (obj != null && z) {
                stringBuilder3.append(3).append(",");
            } else if (z) {
                stringBuilder3.append(2).append(",");
            } else {
                stringBuilder3.append(1).append(",");
            }
            if (obj3 != null && obj2 != null) {
                stringBuilder3.append(3).append(",");
            } else if (obj2 != null) {
                stringBuilder3.append(2).append(",");
            } else {
                stringBuilder3.append(1).append(",");
            }
            stringBuilder3.append(stringBuilder.toString()).append(",");
            stringBuilder3.append(stringBuilder2.toString()).append(",");
            stringBuilder3.append(i2).append(",").append(i3).append(",");
            stringBuilder3.append(i4).append(",").append(i5).append(",");
            stringBuilder3.append(i6).append(",").append(i7).append(",");
            stringBuilder3.append(i8).append(",").append(length);
            w.i("MicroMsg.MediaCodecUtil", "high api 21 cost[%d] hevc info %s", Long.valueOf(bg.aB(NA)), stringBuilder3.toString());
            return stringBuilder3.toString();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MediaCodecUtil", e, "report hevc info error %s", e.toString());
            return "";
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.MediaCodecUtil", e2, "report hevc info error %s", e2.toString());
            return "";
        }
    }

    private static String aKr() {
        long NA = bg.NA();
        int codecCount = MediaCodecList.getCodecCount();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < codecCount; i++) {
            String a = a(MediaCodecList.getCodecInfoAt(i));
            if (!bg.mA(a)) {
                arrayList.add(Integer.valueOf(i));
                arrayList2.add(a);
            }
        }
        if (arrayList.isEmpty()) {
            return "";
        }
        boolean z = false;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        Object obj = null;
        codecCount = 0;
        Object obj2 = null;
        Object obj3 = null;
        while (codecCount < arrayList.size()) {
            String str = (String) arrayList2.get(codecCount);
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(((Integer) arrayList.get(codecCount)).intValue());
            boolean isEncoder = codecInfoAt.isEncoder();
            Object obj4 = !codecInfoAt.isEncoder() ? 1 : null;
            if (codecInfoAt.getCapabilitiesForType(str) != null) {
                obj = 1;
                stringBuilder.append(codecInfoAt.getName()).append("|");
            } else {
                obj3 = 1;
                stringBuilder2.append(codecInfoAt.getName()).append("|");
            }
            codecCount++;
            obj2 = obj4;
            z = isEncoder;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(1).append(",");
        if (obj2 != null && z) {
            stringBuilder3.append(3).append(",");
        } else if (z) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        if (obj != null && obj3 != null) {
            stringBuilder3.append(3).append(",");
        } else if (obj3 != null) {
            stringBuilder3.append(2).append(",");
        } else {
            stringBuilder3.append(1).append(",");
        }
        stringBuilder3.append(stringBuilder.toString()).append(",");
        stringBuilder3.append(stringBuilder2.toString());
        w.i("MicroMsg.MediaCodecUtil", "below api 21 cost[%d] hevc info %s", Long.valueOf(bg.aB(NA)), stringBuilder3.toString());
        return stringBuilder3.toString();
    }

    private static String a(MediaCodecInfo mediaCodecInfo) {
        String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
        for (String str : supportedTypes) {
            if (!bg.mA(str) && str.contains("hevc")) {
                return str;
            }
        }
        return "";
    }
}
