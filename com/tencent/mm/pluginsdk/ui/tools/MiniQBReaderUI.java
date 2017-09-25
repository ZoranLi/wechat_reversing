package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.smtt.sdk.QbSdk;

@a(3)
public class MiniQBReaderUI extends MMActivity {
    private int ret = -1;
    private String sWy = Integer.toString(hashCode());

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        w.i("MicroMsg.MiniQBReaderUI", "onCreate");
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("file_path");
        String stringExtra2 = intent.getStringExtra("file_ext");
        this.ret = r.a(this, stringExtra, stringExtra2, this.sWy, new ValueCallback<String>(this) {
            final /* synthetic */ MiniQBReaderUI sWz;

            {
                this.sWz = r1;
            }

            public final /* synthetic */ void onReceiveValue(Object obj) {
                w.i("MicroMsg.MiniQBReaderUI", "startMiniQBToLoadUrl, onReceiveValue: %s", new Object[]{(String) obj});
                if ("fileReaderClosed".equals((String) obj)) {
                    this.sWz.finish();
                }
            }
        });
        w.i("MicroMsg.MiniQBReaderUI", "tryOpenByQbSdk , ret:%b", new Object[]{Integer.valueOf(this.ret)});
        new StringBuilder("tryOpenByQbSdk , ret:").append(this.ret);
        Intent intent2 = new Intent();
        intent2.setAction("MINIQB_OPEN_RET");
        intent2.putExtra("file_path", stringExtra);
        intent2.putExtra("file_ext", stringExtra2);
        stringExtra2 = "MINIQB_OPEN_RET_VAL";
        if (this.ret != 0) {
            z = false;
        }
        intent2.putExtra(stringExtra2, z);
        sendBroadcast(intent2, WXApp.WXAPP_BROADCAST_PERMISSION);
        if (this.ret != 0) {
            finish();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        w.i("MicroMsg.MiniQBReaderUI", "onNewIntent");
    }

    protected void onDestroy() {
        w.i("MicroMsg.MiniQBReaderUI", "onDestroy");
        if (this.ret == 0) {
            try {
                QbSdk.closeFileReader(this);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MiniQBReaderUI", e, "", new Object[0]);
            }
        }
        super.onDestroy();
    }
}
