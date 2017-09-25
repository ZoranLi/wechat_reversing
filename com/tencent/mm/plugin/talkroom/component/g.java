package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.talkroom.component.a.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.QbSdk;

class g extends a {
    private final ae handler = new ae(Looper.getMainLooper());
    private final v2engine qXc = new v2engine();

    static {
        int rl = l.rl();
        w.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(rl)});
        if ((rl & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != 0) {
            d.u(ab.getContext(), "libvoipCodec_v7a.so");
        } else if ((rl & 512) != 0) {
            d.u(ab.getContext(), "libvoipCodec.so");
        } else {
            d.u(ab.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", g.class.getClassLoader());
    }

    public final int uninitLive() {
        return ((Integer) new bb<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.qXg.qXc.uninitLive());
            }
        }.b(this.handler)).intValue();
    }

    public final int SetCurrentMicId(final int i) {
        return ((Integer) new bb<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.qXg.qXc.SetCurrentMicId(i));
            }
        }.b(this.handler)).intValue();
    }

    public final int Close() {
        return ((Integer) new bb<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.qXg.qXc.Close());
            }
        }.b(this.handler)).intValue();
    }

    public final int bnu() {
        return ((Integer) new bb<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                w.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(l.rl())});
                w.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", new Object[]{Integer.valueOf(this.qXg.qXc.initLive(r0, e.hgp + "app_lib/"))});
                return Integer.valueOf(this.qXg.qXc.initLive(r0, e.hgp + "app_lib/"));
            }
        }.b(this.handler)).intValue();
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        final short[] sArr = new short[iArr2.length];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        final b bVar2 = bVar;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final long j2 = j;
        final int[] iArr3 = iArr;
        final int i9 = i4;
        return ((Integer) new bb<Integer>(this, Integer.valueOf(QbSdk.EXTENSION_INIT_FAILURE)) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                return Integer.valueOf(this.qXg.qXc.Open(bVar2, i6, i7, i8, j2, iArr3, sArr, i9));
            }
        }.b(this.handler)).intValue();
    }

    public final byte[] d(final int[] iArr, final String str) {
        return (byte[]) new bb<byte[]>(this) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                PByteArray pByteArray = new PByteArray();
                iArr[0] = this.qXg.qXc.GetStatis(pByteArray, str);
                return pByteArray.value;
            }
        }.b(this.handler);
    }

    public final e a(final c cVar) {
        return (e) new bb<e>(this) {
            final /* synthetic */ g qXg;

            protected final /* synthetic */ Object run() {
                return new h(this.qXg.qXc, cVar);
            }
        }.b(this.handler);
    }

    public final d bnv() {
        return (d) new bb<d>(this) {
            final /* synthetic */ g qXg;

            {
                this.qXg = r4;
            }

            protected final /* synthetic */ Object run() {
                return new f(this.qXg.qXc);
            }
        }.b(this.handler);
    }
}
