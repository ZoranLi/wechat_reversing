package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.a;

public final class m extends k implements j {
    private String clientId = null;
    private String fOu;
    private b gUA;
    private e gUD;
    private f hGt;
    private int hrs = 0;
    private int hrt = 0;
    private String oAb = null;
    private String oAc;
    private int oAd = 0;

    public m(java.lang.String r7, java.lang.String r8, java.lang.String[] r9, int r10, com.tencent.mm.y.f r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IndexOutOfBoundsException: bitIndex < 0: -1
	at java.util.BitSet.get(BitSet.java:623)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.usedArgAssign(CodeShrinker.java:138)
	at jadx.core.dex.visitors.CodeShrinker$ArgsInfo.access$300(CodeShrinker.java:43)
	at jadx.core.dex.visitors.CodeShrinker.canMoveBetweenBlocks(CodeShrinker.java:282)
	at jadx.core.dex.visitors.CodeShrinker.shrinkBlock(CodeShrinker.java:230)
	at jadx.core.dex.visitors.CodeShrinker.shrinkMethod(CodeShrinker.java:38)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkArrayForEach(LoopRegionVisitor.java:196)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.checkForIndexedLoop(LoopRegionVisitor.java:119)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.processLoopRegion(LoopRegionVisitor.java:65)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.enterRegion(LoopRegionVisitor.java:52)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:56)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:58)
	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:18)
	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:46)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = 0;
        r1 = 0;
        r6.<init>();
        r6.oAb = r0;
        r6.hrs = r1;
        r6.clientId = r0;
        r6.hrt = r1;
        r6.oAd = r1;
        r6.oAb = r7;
        r6.oAd = r10;
        r6.hGt = r11;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
        if (r0 != 0) goto L_0x005e;
    L_0x001b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r2 = r7.getBytes();
        r2 = com.tencent.mm.a.g.n(r2);
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = java.lang.System.nanoTime();
        r0 = r0.append(r2);
        r2 = "_";
        r0 = r0.append(r2);
        r2 = new java.util.Random;
        r2.<init>();
        r2 = r2.nextInt();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r6.clientId = r0;
        r0 = r7.getBytes();
        r0 = r0.length;
        r6.hrs = r0;
        r6.hrt = r1;
    L_0x005e:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r6.fOu = r8;
    L_0x0066:
        if (r9 == 0) goto L_0x00a2;
    L_0x0068:
        r0 = "";
        r6.oAc = r0;
        r2 = r9.length;
        r0 = r1;
    L_0x006f:
        if (r0 >= r2) goto L_0x0092;
    L_0x0071:
        r3 = r9[r0];
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = r6.oAc;
        r4 = r4.append(r5);
        r3 = r4.append(r3);
        r4 = ",";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r6.oAc = r3;
        r0 = r0 + 1;
        goto L_0x006f;
    L_0x0092:
        r0 = r6.oAc;
        r2 = r6.oAc;
        r2 = r2.length();
        r2 = r2 + -1;
        r0 = r0.substring(r1, r2);
        r6.oAc = r0;
    L_0x00a2:
        r0 = "MicroMsg.NetSceneComposeSend";
        r2 = "NetSceneComposeSend, clientId: %s, totalLen: %d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = r6.clientId;
        r3[r1] = r4;
        r1 = 1;
        r4 = r6.hrs;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r2, r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.b.m.<init>(java.lang.String, java.lang.String, java.lang.String[], int, com.tencent.mm.y.f):void");
    }

    protected final int ub() {
        return 100;
    }

    protected final int a(p pVar) {
        if (!bg.mA(this.oAb)) {
            return k.b.hsT;
        }
        w.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
        return k.b.hsU;
    }

    protected final void a(a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.hrt = ((mc) ((b) pVar).hsk.hsr).tgK;
            if (this.gUD != null) {
                this.gUD.a(i2, i3, str, this);
            }
            if (this.hGt != null) {
                this.hGt.a(this.hrt, this.hrs, this);
            }
            if (this.hrt < this.hrs) {
                w.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[]{Integer.valueOf(this.hrt), Integer.valueOf(this.hrs)});
                if (a(this.hsD, this.gUD) < 0) {
                    w.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
                    return;
                }
                return;
            }
            w.i("MicroMsg.NetSceneComposeSend", "finished upload");
        } else if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 485;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        if (bg.mA(this.oAb)) {
            w.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
            return -1;
        }
        int min = Math.min(this.hrs - this.hrt, WXMediaMessage.THUMB_LENGTH_LIMIT);
        w.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[]{Integer.valueOf(min)});
        byte[] bArr = new byte[min];
        byte[] bytes = this.oAb.getBytes();
        int i = 0;
        for (int i2 = this.hrt; i2 < this.hrt + min; i2++) {
            bArr[i] = bytes[i2];
            i++;
        }
        if (bg.bm(bArr)) {
            w.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
            return -1;
        }
        b.a aVar = new b.a();
        aVar.hsm = new mb();
        aVar.hsn = new mc();
        aVar.uri = "/cgi-bin/micromsg-bin/composesend";
        aVar.hsl = 485;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        mb mbVar = (mb) this.gUA.hsj.hsr;
        mbVar.teW = this.clientId;
        mbVar.tgJ = this.hrs;
        mbVar.tgK = this.hrt;
        mbVar.tgL = min;
        mbVar.tsl = this.fOu;
        mbVar.tsm = this.oAc;
        mbVar.tsn = (int) (((float) this.hrs) + (((float) this.oAd) * 1.3333334f));
        w.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[]{Integer.valueOf(mbVar.tsn)});
        mbVar.tsk = n.G(bArr);
        w.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[]{Integer.valueOf(a(eVar, this.gUA, this))});
        return a(eVar, this.gUA, this);
    }
}
