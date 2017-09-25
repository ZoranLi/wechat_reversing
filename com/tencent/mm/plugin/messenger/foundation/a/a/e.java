package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;

public interface e {

    public static class b {
        public byte[] buffer;
        public int cmdId;
        public int fRW = -1;
        public long hDC;
        public int id;
        public int nyU;
        public long nyV;
        public String nyW;
        public String nyX;
        public com.tencent.mm.bd.a nyY;

        public b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final byte[] getBuffer() {
            if (this.buffer == null && this.nyY != null) {
                try {
                    this.buffer = this.nyY.toByteArray();
                } catch (IOException e) {
                    w.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            return this.buffer;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.bd.a aVar) {
            super(i);
            this.cmdId = i;
            this.nyY = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
