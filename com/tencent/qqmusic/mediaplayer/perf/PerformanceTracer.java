package com.tencent.qqmusic.mediaplayer.perf;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class PerformanceTracer {
    private long lastTimeStampNanoSecond = 0;
    private File mediaFile;
    private long playStartTimestampNanoSec = 0;
    private final Map<String, SpeedCheck> speedMap = new LinkedHashMap();
    private long totalPcmInByte;
    private long totalTimeCostInNanoSec = 0;

    private static class BufferSizeCheck {
        private int lastSize = 0;
        private int maxMismatch = 0;
        private final String name;
        private int sizeMismatchCount = 0;

        public BufferSizeCheck(String str) {
            this.name = str;
        }

        void onStart(int i) {
            this.lastSize = i;
        }

        void onEnd(int i) {
            if (i != this.lastSize) {
                int i2 = this.lastSize - i;
                if (Math.abs(i2) > this.maxMismatch) {
                    this.maxMismatch = i2;
                }
                this.sizeMismatchCount++;
            }
        }

        public int getMaxMismatch() {
            return this.maxMismatch;
        }

        public String getName() {
            return this.name;
        }

        public int getSizeMismatchCount() {
            return this.sizeMismatchCount;
        }
    }

    public static class OverallInfo {
        public final File mediaFile;
        public final long timeCostInMs;
        public final long totalPcmToBePlayed;

        public OverallInfo(File file, long j, long j2) {
            this.mediaFile = file;
            this.timeCostInMs = j;
            this.totalPcmToBePlayed = j2;
        }
    }

    public static class SpeedCheck {
        private static final double f = 1000000.0d;
        private double avg;
        private double max;
        private double min;
        private final String name;
        private long totalBufferLength;
        private long totalTimeNanoSecond;

        public String getName() {
            return this.name;
        }

        public double getAvg() {
            return this.avg;
        }

        public double getMax() {
            return this.max;
        }

        public double getMin() {
            return this.min;
        }

        public long getTotalTimeMs() {
            return Math.round(((double) this.totalTimeNanoSecond) / f);
        }

        public long getTotalBufferLength() {
            return this.totalBufferLength;
        }

        public SpeedCheck(String str) {
            this.name = str;
        }

        public void update(int i, long j) {
            this.totalBufferLength += (long) i;
            this.totalTimeNanoSecond += j;
            double d = (((double) i) * f) / ((double) j);
            if (d > this.max || this.max == 0.0d) {
                this.max = d;
            } else if (d < this.min || this.min == 0.0d) {
                this.min = d;
            }
        }

        public void compute() {
            this.avg = (((double) this.totalBufferLength) * f) / ((double) this.totalTimeNanoSecond);
        }

        void reset() {
            this.avg = 0.0d;
            this.max = 0.0d;
            this.min = 0.0d;
            this.totalTimeNanoSecond = 0;
            this.totalBufferLength = 0;
        }

        public String toString() {
            compute();
            return String.format(Locale.getDefault(), "%10s%15.2f%15.2f%15.2f%10d%15d", new Object[]{this.name, Double.valueOf(this.avg), Double.valueOf(this.max), Double.valueOf(this.min), Long.valueOf(this.totalTimeNanoSecond), Long.valueOf(this.totalBufferLength)});
        }
    }

    public interface Visitor {
        void visitSpeedCheck(List<SpeedCheck> list, OverallInfo overallInfo);
    }

    public void init(File file) {
        this.mediaFile = file;
        this.lastTimeStampNanoSecond = 0;
        for (SpeedCheck reset : this.speedMap.values()) {
            reset.reset();
        }
    }

    public void playStart() {
        this.totalPcmInByte = 0;
    }

    public void playEnd() {
    }

    public void roundStart() {
        this.playStartTimestampNanoSec = System.nanoTime();
    }

    public void roundEnd(int i) {
        this.totalPcmInByte += (long) i;
        this.totalTimeCostInNanoSec += System.nanoTime() - this.playStartTimestampNanoSec;
    }

    public void start(String str) {
        getSpeedCheck(str);
        this.lastTimeStampNanoSecond = System.nanoTime();
    }

    public void end(String str, int i) {
        getSpeedCheck(str).update(i, System.nanoTime() - this.lastTimeStampNanoSecond);
    }

    public void accept(Visitor visitor) {
        List<SpeedCheck> arrayList = new ArrayList(this.speedMap.values());
        for (SpeedCheck compute : arrayList) {
            compute.compute();
        }
        visitor.visitSpeedCheck(arrayList, new OverallInfo(this.mediaFile, Math.round(((double) this.totalTimeCostInNanoSec) / 1000000.0d), this.totalPcmInByte));
    }

    private SpeedCheck getSpeedCheck(String str) {
        SpeedCheck speedCheck = (SpeedCheck) this.speedMap.get(str);
        if (speedCheck != null) {
            return speedCheck;
        }
        speedCheck = new SpeedCheck(str);
        this.speedMap.put(str, speedCheck);
        return speedCheck;
    }
}
