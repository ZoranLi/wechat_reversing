package com.tencent.mm.plugin.emoji.ui;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

public abstract class EmojiBaseActivity extends MMActivity {
    a kPD;
    b kPE;
    private HandlerThread mHandlerThread;

    private class a extends ae {
        final /* synthetic */ EmojiBaseActivity kPF;

        a(EmojiBaseActivity emojiBaseActivity, Looper looper) {
            this.kPF = emojiBaseActivity;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.kPF.g(message);
        }
    }

    private class b extends ae {
        final /* synthetic */ EmojiBaseActivity kPF;

        b(EmojiBaseActivity emojiBaseActivity, Looper looper) {
            this.kPF = emojiBaseActivity;
            super(looper);
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.kPF.h(message);
        }
    }

    public abstract void g(Message message);

    public abstract void h(Message message);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandlerThread = e.Qu("EmojiBaseActivity_handlerThread");
        this.mHandlerThread.start();
        this.kPD = new a(this, this.mHandlerThread.getLooper());
        this.kPE = new b(this, getMainLooper());
    }

    protected void onDestroy() {
        super.onDestroy();
        if (!(this.kPD == null || this.kPD.getLooper() == null)) {
            this.kPD.getLooper().quit();
        }
        this.mHandlerThread = null;
        this.kPD = null;
        this.kPE = null;
    }

    public final void bP(int i, int i2) {
        if (this.kPE != null) {
            this.kPE.sendEmptyMessageDelayed(i, (long) i2);
        }
    }

    public final void i(Message message) {
        if (this.kPE != null) {
            this.kPE.sendMessage(message);
        }
    }

    public final void ang() {
        if (this.kPE != null) {
            this.kPE.removeMessages(131074);
        }
    }
}
