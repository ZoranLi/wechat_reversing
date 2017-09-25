package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.plugin.sport.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class h {
    public static g bmx() {
        if (ab.bJb()) {
            return new g(a.qRj);
        }
        if (ab.bJe()) {
            return new g(a.qRi);
        }
        return null;
    }

    public static long F(int i, long j) {
        if (ab.bJb()) {
            return ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().getLong(i, j);
        }
        return new g(a.qRj).getLong(i, j);
    }

    public static void G(int i, long j) {
        if (ab.bJb()) {
            ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else {
            throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ab.um()}));
        }
    }

    public static long uu(int i) {
        if (ab.bJe()) {
            return ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().getLong(i, 0);
        }
        if (ab.bJb()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getDeviceStepManager().qRo;
            if (aVar != null) {
                try {
                    return aVar.getLong(i, 0);
                } catch (RemoteException e) {
                }
            }
        }
        return new g(a.qRi).getLong(i, 0);
    }

    public static void H(int i, long j) {
        if (ab.bJe()) {
            ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getSportFileStorage().setLong(i, j);
        } else if (ab.bJb()) {
            com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) com.tencent.mm.kernel.h.j(PluginSport.class)).getDeviceStepManager().qRo;
            if (aVar != null) {
                try {
                    aVar.D(i, j);
                } catch (RemoteException e) {
                }
            }
        }
    }
}
