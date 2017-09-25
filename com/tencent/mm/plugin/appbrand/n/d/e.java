package com.tencent.mm.plugin.appbrand.n.d;

import com.tencent.mm.plugin.appbrand.n.d.d.a;
import com.tencent.mm.plugin.appbrand.n.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e implements c {
    protected static byte[] jpK = new byte[0];
    protected boolean jpL;
    protected a jpM;
    private ByteBuffer jpN;
    protected boolean jpO;

    public e(a aVar) {
        this.jpM = aVar;
        this.jpN = ByteBuffer.wrap(jpK);
    }

    public e(d dVar) {
        this.jpL = dVar.XX();
        this.jpM = dVar.XZ();
        this.jpN = dVar.XW();
        this.jpO = dVar.XY();
    }

    public final boolean XX() {
        return this.jpL;
    }

    public final a XZ() {
        return this.jpM;
    }

    public final boolean XY() {
        return this.jpO;
    }

    public ByteBuffer XW() {
        return this.jpN;
    }

    public final void cj(boolean z) {
        this.jpL = z;
    }

    public final void a(a aVar) {
        this.jpM = aVar;
    }

    public void l(ByteBuffer byteBuffer) {
        this.jpN = byteBuffer;
    }

    public final void ck(boolean z) {
        this.jpO = z;
    }

    public final void e(d dVar) {
        ByteBuffer XW = dVar.XW();
        if (this.jpN == null) {
            this.jpN = ByteBuffer.allocate(XW.remaining());
            XW.mark();
            this.jpN.put(XW);
            XW.reset();
        } else {
            XW.mark();
            this.jpN.position(this.jpN.limit());
            this.jpN.limit(this.jpN.capacity());
            if (XW.remaining() > this.jpN.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(XW.remaining() + this.jpN.capacity());
                this.jpN.flip();
                allocate.put(this.jpN);
                allocate.put(XW);
                this.jpN = allocate;
            } else {
                this.jpN.put(XW);
            }
            this.jpN.rewind();
            XW.reset();
        }
        this.jpL = dVar.XX();
    }

    public String toString() {
        return "Framedata{ optcode:" + this.jpM + ", fin:" + this.jpL + ", payloadlength:[pos:" + this.jpN.position() + ", len:" + this.jpN.remaining() + "], payload:" + Arrays.toString(b.re(new String(this.jpN.array()))) + "}";
    }
}
