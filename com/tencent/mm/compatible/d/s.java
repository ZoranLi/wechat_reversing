package com.tencent.mm.compatible.d;

public final class s {
    public int gRq;
    public int gRr;
    public int gRs;
    public int gRt;
    public int gRu;
    public int gRv;
    public int gRw;
    public int gRx;

    public s() {
        reset();
    }

    public final void reset() {
        this.gRq = -1;
        this.gRr = -1;
        this.gRs = -1;
        this.gRt = -1;
        this.gRu = -1;
        this.gRv = -1;
        this.gRw = -1;
        this.gRx = -1;
    }

    public final String toString() {
        return String.format("MMSightRecorderInfo, recorderType: %s, needRotateEachFrame: %s, enableHighResolutionRecord: %s, landscapeRecordModeEnable: %s, transcodeDecoderType: %s, mediaPlayerType : %s strategybit: %s, recorderOption: %s", new Object[]{Integer.valueOf(this.gRq), Integer.valueOf(this.gRr), Integer.valueOf(this.gRs), Integer.valueOf(this.gRt), Integer.valueOf(this.gRu), Integer.valueOf(this.gRv), Integer.valueOf(this.gRw), Integer.valueOf(this.gRx)});
    }
}
