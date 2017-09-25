package com.qq.wx.voice.embed.recognizer;

import com.tencent.mm.plugin.appbrand.jsapi.map.m;

public final class e {
    public Grammar aIT;
    g aIU;
    public byte[] c;
    public boolean d;
    public boolean e;

    private class a implements Runnable {
        private /* synthetic */ e aIM;

        public a(e eVar) {
            this.aIM = eVar;
        }

        public final void run() {
            if (this.aIM.aIT.begin() != 0) {
                this.aIM.aIU.a(-102);
            } else if (this.aIM.aIT.recognize(this.aIM.c, this.aIM.c.length) != 0) {
                this.aIM.aIU.a(-103);
            } else if (this.aIM.aIT.end() != 0) {
                this.aIM.aIU.a(-104);
            } else {
                a aVar = new a();
                if (this.aIM.aIT.getResult(aVar) != 0) {
                    this.aIM.aIU.a(-105);
                }
                g gVar = this.aIM.aIU;
                gVar.aIW.sendMessage(gVar.aIW.obtainMessage(m.CTRL_INDEX, aVar));
            }
        }
    }

    public e() {
        this.aIT = null;
        this.aIU = new g();
        this.c = null;
        this.d = false;
        this.e = false;
        this.aIT = new Grammar();
    }

    public final int a(c cVar, byte[] bArr) {
        if (!this.d) {
            return -304;
        }
        if (!this.e) {
            return -302;
        }
        this.aIU.aIV = cVar;
        this.c = bArr;
        if (this.c == null) {
            return -301;
        }
        try {
            new Thread(new a(this)).start();
            return 0;
        } catch (Exception e) {
            return -302;
        }
    }
}
