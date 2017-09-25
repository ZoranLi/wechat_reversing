package com.tencent.mm.network;

import com.tencent.mm.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.f.d.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class x {
    private static final byte[] ifj = n.cP(7);
    public l ifk;

    public final void onPush(int i, byte[] bArr) {
        w.i("MicroMsg.MMNativeNetNotifyAdapter", "onNotify, datalen=" + (bArr == null ? 0 : bArr.length) + " cmd= " + i);
        switch (i) {
            case 5:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "old notify");
                this.ifk.d(138, ifj);
                return;
            case 8:
                if (bArr.length > 0) {
                    this.ifk.d(10, bArr);
                    return;
                }
                return;
            case 24:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush new notify [%s]", bg.bl(bArr));
                this.ifk.d(138, bArr);
                return;
            case 39:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do synccheck");
                this.ifk.d(39, null);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.ifk.d(GameJsApiOperateGameCenterMsg.CTRL_BYTE, bArr);
                return;
            case 120:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "MM_PKT_VOIP_REQ");
                if (bArr.length > 0) {
                    this.ifk.d(120, bArr);
                    return;
                }
                return;
            case 122:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush MM_PKT_PUSH_DATA_REQ");
                if (bArr.length > 0) {
                    this.ifk.d(268369921, bArr);
                    return;
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.bg.CTRL_INDEX /*192*/:
                this.ifk.d(com.tencent.mm.plugin.appbrand.jsapi.bg.CTRL_INDEX, bArr);
                return;
            case GameJsApiGetGameCommInfo.CTRL_BYTE /*241*/:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "jacks do voice notify PUSH");
                this.ifk.d(GameJsApiGetGameCommInfo.CTRL_BYTE, bArr);
                return;
            case a.CTRL_INDEX /*244*/:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "pandy do gamesync notify");
                this.ifk.d(a.CTRL_INDEX, bArr);
                return;
            case 311:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "on notify F2F data");
                this.ifk.d(311, bArr);
                return;
            case 318:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "summerbadcr on silence notify");
                this.ifk.d(318, bArr);
                return;
            case 319:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "hy: on notify new year shake");
                this.ifk.d(319, bArr);
                return;
            case 268369923:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush do oob do notify");
                this.ifk.d(268369923, bArr);
                return;
            case 1000000205:
                this.ifk.d(1000000205, bArr);
                return;
            case 2147480001:
                w.i("MicroMsg.MMNativeNetNotifyAdapter", "dkpush GCM notify [%s]", bg.bl(bArr));
                this.ifk.d(2147480001, bArr);
                return;
            default:
                return;
        }
    }
}
