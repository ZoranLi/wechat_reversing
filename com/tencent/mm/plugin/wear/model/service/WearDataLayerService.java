package com.tencent.mm.plugin.wear.model.service;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.e;
import com.google.android.gms.wearable.f;
import com.google.android.gms.wearable.j;
import com.google.android.gms.wearable.l;
import com.google.android.gms.wearable.m;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.wear.a.b;
import com.tencent.mm.plugin.wear.model.a.a;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@JgClassChecked(author = 100, fComment = "checked", lastDate = "20141125", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class WearDataLayerService extends WearableListenerService {
    public void onCreate() {
        super.onCreate();
        w.i("MicroMsg.Wear.WearDataLayerService", "onCreate");
    }

    public void onDestroy() {
        w.i("MicroMsg.Wear.WearDataLayerService", "onDestroy");
        super.onDestroy();
    }

    public final void a(e eVar) {
        w.i("MicroMsg.Wear.WearDataLayerService", "onDataChanged %d %s", Integer.valueOf(eVar.getCount()), eVar.aFq);
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.getType() == 1) {
                Uri uri = dVar.mC().getUri();
                if (b.IK(uri.getPath())) {
                    f mC = dVar.mC();
                    if (mC == null) {
                        throw new IllegalStateException("provided dataItem is null");
                    }
                    Asset as = new j(mC).aFP.as("key_data");
                    if (as != null) {
                        try {
                            w.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(new a().a(as).length));
                            com.tencent.mm.plugin.wear.model.b.a.I(aR(r0));
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode data error", new Object[0]);
                        }
                    }
                    new a().g(uri);
                } else {
                    continue;
                }
            }
        }
        eVar.release();
    }

    private static Bundle aR(byte[] bArr) {
        Bundle bundle = new Bundle();
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        bundle.putInt("key_connecttype", dataInputStream.readInt());
        bundle.putInt("key_sessionid", dataInputStream.readInt());
        bundle.putInt("key_funid", dataInputStream.readInt());
        int readInt = dataInputStream.readInt();
        if (readInt > 0 && readInt < bArr.length) {
            byte[] bArr2 = new byte[readInt];
            dataInputStream.readFully(bArr2);
            bundle.putByteArray("key_data", bArr2);
        } else if (readInt >= bArr.length) {
            throw new IOException("contentLength too large " + readInt);
        }
        w.i("MicroMsg.Wear.WearDataLayerService", "receive data connectType=%d sessionId=%d funId=%d contentLength=%d", Integer.valueOf(r2), Integer.valueOf(r3), Integer.valueOf(r4), Integer.valueOf(readInt));
        return bundle;
    }

    public final void a(l lVar) {
        w.i("MicroMsg.Wear.WearDataLayerService", "onMessageReceived %s", lVar.getPath());
        if (b.IK(lVar.getPath())) {
            try {
                w.i("MicroMsg.Wear.WearDataLayerService", "receive data = %d", Integer.valueOf(lVar.getData().length));
                com.tencent.mm.plugin.wear.model.b.a.I(aR(r0));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "decode message error", new Object[0]);
            }
        }
    }

    public final void a(m mVar) {
        w.i("MicroMsg.Wear.WearDataLayerService", "onPeerConnected %s", mVar.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", 1);
        bundle.putByteArray("key_data", mVar.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.I(bundle);
    }

    public final void b(m mVar) {
        w.i("MicroMsg.Wear.WearDataLayerService", "onPeerDisconnected %s", mVar.getId());
        Bundle bundle = new Bundle();
        bundle.putInt("key_connecttype", 3);
        bundle.putInt("key_funid", -1);
        bundle.putByteArray("key_data", mVar.getId().getBytes());
        com.tencent.mm.plugin.wear.model.b.a.I(bundle);
    }

    public final void a(Channel channel) {
        String path = channel.getPath();
        String mB = channel.mB();
        File file = new File(com.tencent.mm.compatible.util.e.gSy, g.n(path.getBytes()));
        w.i("MicroMsg.Wear.WearDataLayerService", "onChannelOpened %s %s %s", path, mB, file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Wear.WearDataLayerService", e, "onChannelOpened", new Object[0]);
        }
        channel.a(new a().bvS(), Uri.fromFile(file));
    }

    public final void b(Channel channel, int i, int i2) {
        String path = channel.getPath();
        String mB = channel.mB();
        w.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s %s %d %d", path, mB, Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            w.i("MicroMsg.Wear.WearDataLayerService", "onInputClosed %s, %d", r2.getAbsolutePath(), Long.valueOf(new File(com.tencent.mm.compatible.util.e.gSy, g.n(path.getBytes())).length()));
            Bundle bundle = new Bundle();
            bundle.putInt("key_connecttype", 1);
            bundle.putInt("key_funid", b.IL(path));
            bundle.putInt("key_sessionid", 0);
            bundle.putByteArray("key_data", r2.getAbsolutePath().getBytes());
            com.tencent.mm.plugin.wear.model.b.a.I(bundle);
        }
    }

    public final void c(Channel channel, int i, int i2) {
        String path = channel.getPath();
        String mB = channel.mB();
        w.i("MicroMsg.Wear.WearDataLayerService", "onOutputClosed %s %s %d %d", path, mB, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void a(Channel channel, int i, int i2) {
        String path = channel.getPath();
        String mB = channel.mB();
        w.i("MicroMsg.Wear.WearDataLayerService", "onChannelClosed %s %s %d %d", path, mB, Integer.valueOf(i), Integer.valueOf(i2));
    }
}
