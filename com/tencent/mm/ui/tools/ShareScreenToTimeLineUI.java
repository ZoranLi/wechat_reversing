package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.account.SimpleLoginUI;
import com.tencent.mm.ui.base.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

@a(3)
@JgClassChecked(author = 12, fComment = "checked", lastDate = "20141031", reviewer = 20, vComment = {EType.ACTIVITYCHECK})
public class ShareScreenToTimeLineUI extends MMActivity {
    String filePath = null;
    Uri uri = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP("");
        int a = s.a(getIntent(), "wizard_activity_result_code", 0);
        switch (a) {
            case -1:
            case 0:
                NotifyReceiver.pX();
                ap.vd().a(new bb(new bb.a(this) {
                    final /* synthetic */ ShareScreenToTimeLineUI wox;

                    {
                        this.wox = r1;
                    }

                    public final void a(e eVar) {
                    }
                }), 0);
                KC();
                return;
            case 1:
                finish();
                return;
            default:
                w.e("MicroMsg.ShareScreenToTimeLineUI", "onCreate, should not reach here, resultCode = " + a);
                finish();
                return;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void KC() {
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, intent is null");
            bZx();
            finish();
            return;
        }
        String action = intent.getAction();
        this.uri = intent.getData();
        if (bg.mA(action)) {
            w.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, action is null");
            bZx();
            finish();
            return;
        }
        String i = s.i(intent, "Kdescription");
        String resolveType = getIntent().resolveType(this);
        if (bg.mA(resolveType)) {
            bZx();
            finish();
        } else if (!resolveType.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            bZx();
            finish();
        } else if (action.equals("android.intent.action.VIEW")) {
            w.i("MicroMsg.ShareScreenToTimeLineUI", "send signal: " + action);
            if (bg.l(this.uri)) {
                this.filePath = bg.f(this, this.uri);
                if (!bg.mA(this.filePath) && bg.Ql(this.filePath)) {
                    String str = this.filePath;
                    DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                    boolean a = o.a(str, decodeResultLogger);
                    if (!a && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                        g.oUh.A(12712, KVStatHelper.getKVStatString(str, 4, decodeResultLogger));
                    }
                    if (a) {
                        eX(this.filePath, i);
                        return;
                    }
                    bZx();
                    finish();
                    return;
                } else if (s.a(intent, "Ksnsupload_empty_img", false)) {
                    eX(this.filePath, i);
                    return;
                } else {
                    bZx();
                    finish();
                    return;
                }
            }
            w.e("MicroMsg.ShareScreenToTimeLineUI", "fail, not accepted: %s", new Object[]{this.uri});
            bZx();
            finish();
        } else {
            w.e("MicroMsg.ShareScreenToTimeLineUI", "launch : fail, uri is null");
            bZx();
            finish();
        }
    }

    private void eX(String str, String str2) {
        Intent intent = new Intent();
        if (!bg.mA(str)) {
            intent.putExtra("sns_kemdia_path", str);
            intent.putExtra("KFilterId", -1);
        }
        if (!bg.mA(str2)) {
            intent.putExtra("Kdescription", str2);
        }
        if (ap.za() && !ap.uP()) {
            intent.putExtra("K_go_to_SnsTimeLineUI", true);
            d.b(this, "sns", ".ui.En_c4f742e5", intent);
        } else if (bg.mA(str)) {
            bZx();
        } else {
            intent = new Intent(this, ShareToTimeLineUI.class);
            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str)));
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND");
            MMWizardActivity.b(this, new Intent(this, SimpleLoginUI.class).addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY), intent);
        }
        finish();
    }

    private void bZx() {
        Toast.makeText(this, R.l.eWp, 1).show();
    }
}
