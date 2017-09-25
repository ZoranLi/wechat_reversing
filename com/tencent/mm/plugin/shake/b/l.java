package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

public final class l {
    protected static long pon = 16000;
    protected static int poo = 54158;
    public int pop;
    public b poq;

    public interface a {
        void a(int i, e eVar, long j);

        void d(List<d> list, long j);
    }

    public static abstract class b {
        public a por;
        protected boolean pot = false;
        protected long pou = l.pon;
        private ae pov = new ae(new com.tencent.mm.sdk.platformtools.ae.a(this) {
            final /* synthetic */ b pow;

            {
                this.pow = r1;
            }

            public final boolean handleMessage(Message message) {
                if (!(message.what != l.poo || this.pow.pot || this.pow.por == null)) {
                    this.pow.por.d(null, 5);
                }
                return false;
            }
        });

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public b(a aVar) {
            this.por = aVar;
        }

        public void baF() {
            reset();
            this.por = null;
        }
    }
}
