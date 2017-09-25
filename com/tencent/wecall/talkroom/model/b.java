package com.tencent.wecall.talkroom.model;

import com.tencent.mm.plugin.multi.talk;
import com.tencent.pb.common.a.a;
import com.tencent.pb.common.c.d;
import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    talk xjC = new talk();

    public b() {
        d.d("simon:TalkRoomContext", "construct");
    }

    public final int uninitLive() {
        if (!a.wKA) {
            return 0;
        }
        int uninit;
        try {
            uninit = this.xjC.uninit();
        } catch (Throwable th) {
            d.k("simon:TalkRoomContext", "uninitLive ", th);
            uninit = 0;
        }
        d.d("simon:TalkRoomContext", "uninitLive ret: ", Integer.valueOf(uninit));
        return uninit;
    }

    public final int Close() {
        if (!a.wKA) {
            return 0;
        }
        int close;
        try {
            close = this.xjC.close();
        } catch (Throwable th) {
            d.k("simon:TalkRoomContext", "Close ", th);
            close = 0;
        }
        d.d("simon:TalkRoomContext", "Close ret: ", Integer.valueOf(close));
        return close;
    }

    public final void OnMembersChanged(int[] iArr) {
        if (a.wKA) {
            this.xjC.OnMembersChanged(iArr);
        }
    }

    public final byte[] chq() {
        if (a.wKA) {
            return this.xjC.field_capInfo;
        }
        return new byte[0];
    }

    public final int chr() {
        int i = 0;
        try {
            if (a.wKA) {
                AtomicInteger atomicInteger = new AtomicInteger();
                AtomicInteger atomicInteger2 = new AtomicInteger();
                this.xjC.getChannelBytes(atomicInteger, atomicInteger2);
                i = atomicInteger2.get();
            }
        } catch (Throwable th) {
            d.k("simon:TalkRoomContext", "getTotalWWANBytes: ", th);
        }
        return i;
    }
}
