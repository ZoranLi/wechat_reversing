package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] jBB = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    public int xeA;
    public int xeB;
    public int xeC;
    public int xeD;
    public int xeE;
    public int xeF;
    public int xeG;
    public int xeH;
    public int xeI;
    public int xeJ;
    public int xeK;
    public int xeL;
    public int xeM;
    public int xeN;
    public int xeO;
    public int xeP;
    public int xeQ;
    public byte[] xeR;
    public final com.tencent.tinker.a.a.a.a xew;
    private short xex;
    public int xey;
    private int xez;

    public a(InputStream inputStream) {
        this.xew = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.g(inputStream)));
        byte[] Dm = this.xew.Dm(jBB.length);
        if (c.l(Dm, jBB) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(Dm));
        }
        this.xex = this.xew.xcn.getShort();
        if (c.a(this.xex, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.xex + ", expected: 2");
        }
        this.xey = this.xew.xcn.getInt();
        this.xez = this.xew.xcn.getInt();
        this.xeA = this.xew.xcn.getInt();
        this.xeB = this.xew.xcn.getInt();
        this.xeC = this.xew.xcn.getInt();
        this.xeD = this.xew.xcn.getInt();
        this.xeE = this.xew.xcn.getInt();
        this.xeF = this.xew.xcn.getInt();
        this.xeG = this.xew.xcn.getInt();
        this.xeH = this.xew.xcn.getInt();
        this.xeI = this.xew.xcn.getInt();
        this.xeJ = this.xew.xcn.getInt();
        this.xeK = this.xew.xcn.getInt();
        this.xeL = this.xew.xcn.getInt();
        this.xeM = this.xew.xcn.getInt();
        this.xeN = this.xew.xcn.getInt();
        this.xeO = this.xew.xcn.getInt();
        this.xeP = this.xew.xcn.getInt();
        this.xeQ = this.xew.xcn.getInt();
        this.xeR = this.xew.Dm(20);
        com.tencent.tinker.a.a.a.a aVar = this.xew;
        aVar.xcn.position(this.xez);
    }
}
