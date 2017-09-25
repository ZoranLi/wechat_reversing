package com.tencent.mm.plugin.appbrand.performance;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.RandomAccessFile;

public final class c {
    private final int jeS;
    private volatile RandomAccessFile jeT;
    private volatile RandomAccessFile jeU;
    private long jeV;
    private long jeW;
    private long jeX;

    public c(int i) {
        this.jeS = i;
    }

    public final double Wh() {
        double max;
        Object e;
        try {
            if (this.jeU == null) {
                this.jeU = new RandomAccessFile("/proc/" + this.jeS + "/stat", "r");
            }
            this.jeU.seek(0);
            String readLine = this.jeU.readLine();
            if (bg.mA(readLine)) {
                return 0.0d;
            }
            String[] split = readLine.split(" ");
            if (split.length < 17) {
                return 0.0d;
            }
            long j;
            long parseLong;
            if (this.jeT == null) {
                this.jeT = new RandomAccessFile("/proc/stat", "r");
            }
            this.jeT.seek(0);
            readLine = this.jeT.readLine();
            if (bg.mA(readLine)) {
                j = 0;
            } else {
                String[] split2 = readLine.split(" ");
                if (split2.length < 9) {
                    j = 0;
                } else {
                    j = Long.parseLong(split2[2]);
                    parseLong = Long.parseLong(split2[3]);
                    long parseLong2 = Long.parseLong(split2[4]);
                    long parseLong3 = Long.parseLong(split2[5]);
                    long parseLong4 = Long.parseLong(split2[6]);
                    long parseLong5 = Long.parseLong(split2[7]);
                    j = Long.parseLong(split2[9]) + ((((((j + parseLong) + parseLong2) + parseLong3) + parseLong4) + parseLong5) + Long.parseLong(split2[8]));
                }
            }
            parseLong = Long.parseLong(split[13]);
            long parseLong6 = Long.parseLong(split[14]);
            if (this.jeV != 0) {
                max = Math.max(0.0d, ((double) ((parseLong - this.jeW) * 100)) / ((double) (j - this.jeV))) + Math.max(0.0d, ((double) ((parseLong6 - this.jeX) * 100)) / ((double) (j - this.jeV)));
            } else {
                max = 0.0d;
            }
            try {
                this.jeV = j;
                this.jeW = parseLong;
                this.jeX = parseLong6;
                return max;
            } catch (Exception e2) {
                e = e2;
                w.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
                return max;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            max = 0.0d;
            Exception exception2 = exception;
            w.e(" MicroMsg.CpuSampler", "read pid stat file error: " + e);
            return max;
        }
    }
}
