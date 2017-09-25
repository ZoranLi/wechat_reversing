package com.tencent.mm.plugin.fts.a;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public final class c {
    public static final int[] lZd = new int[]{65536};
    public static final int[] lZe = new int[]{196608};
    public static final int[] lZf = new int[]{262144};
    public static final int[] lZg = new int[]{327680};
    public static final int[] lZh = new int[]{393216};
    public static final int[] lZi = new int[]{131073, 131074};
    public static final int[] lZj = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076};
    public static final int[] lZk = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131076};
    public static final int[] lZl = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    public static final int[] lZm = new int[]{131073, 131074};
    public static final int[] lZn = new int[]{131077, 131078};
    public static final int[] lZo = new int[]{131079, 131080};
    public static final Map<Integer, Integer> lZp;
    public static final int[] lZq = new int[]{2, 3, 6, 7};
    public static final int[] lZr = new int[]{29, 30, 31, 34, 35, 36, 33, 32, 37};
    public static final int[] lZs;
    public static final int[] lZt;
    public static final int[] lZu = new int[43];
    public static final int[] lZv = new int[27];
    public static final String lZw = (com.tencent.mm.loader.stub.a.hgu + "fts/");

    public static final class a {
        public static final Pattern lZA = Pattern.compile("‌");
        public static final Pattern lZB;
        public static final Pattern lZC;
        public static final Pattern lZD = Pattern.compile("\\s+");
        public static final Pattern lZE = Pattern.compile(",");
        public static final Pattern lZx = Pattern.compile(";");
        public static final Pattern lZy = Pattern.compile(" ");
        public static final Pattern lZz = Pattern.compile("​");

        static {
            Pattern compile = Pattern.compile("‍");
            lZB = compile;
            lZC = compile;
        }
    }

    static {
        int i;
        int i2 = 0;
        int[] iArr = new int[]{8, 9, 10};
        lZs = iArr;
        lZt = iArr;
        int[] iArr2 = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131073, 131074, 131075, 131076, 131077, 131078, 131079, 131080};
        int[] iArr3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 17, 18, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 0};
        int[] iArr4 = new int[]{1, 2, 3, 4, 5, 6, 8, 19, 20, 21, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 7, 0};
        Map hashMap = new HashMap();
        for (i = 0; i < 9; i++) {
            hashMap.put(Integer.valueOf(iArr2[i]), Integer.valueOf(i));
        }
        lZp = Collections.unmodifiableMap(hashMap);
        for (i = 0; i < 43; i++) {
            lZu[iArr3[i]] = i;
        }
        while (i2 < 27) {
            lZv[iArr4[i2]] = i2;
            i2++;
        }
    }
}
