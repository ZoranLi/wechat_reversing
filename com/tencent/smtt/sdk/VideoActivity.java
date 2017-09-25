package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.VideoView;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.wcdb.database.SQLiteDatabase;

public class VideoActivity extends Activity {
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        u.gy(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        Intent intent = super.getIntent();
        Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            u gy = u.gy(super.getApplicationContext());
            if (bundleExtra == null) {
                bundleExtra = new Bundle();
            }
            if (!TextUtils.isEmpty(null)) {
                bundleExtra.putString("videoUrl", null);
            }
            bundleExtra.putInt("callMode", 1);
            v vVar = gy.wWm;
            vVar.setBackgroundColor(WebView.NIGHT_MODE_COLOR);
            if (vVar.wWo == null) {
                d.mb(true).a(vVar.getContext().getApplicationContext(), null);
                w cdS = d.mb(true).cdS();
                DexLoader dexLoader = cdS != null ? cdS.wWu : null;
                if (dexLoader != null && QbSdk.canLoadVideo(vVar.getContext())) {
                    vVar.wWo = new z(dexLoader);
                }
            }
            if (vVar.wWo != null && vVar.wWn == null) {
                vVar.wWn = vVar.wWo.gz(vVar.getContext().getApplicationContext());
            }
            boolean z = false;
            if (vVar.ceU()) {
                bundleExtra.putInt("callMode", bundleExtra.getInt("callMode"));
                z = vVar.wWo.a(vVar.wWn, bundleExtra, vVar, null);
            }
            if (!z) {
                if (vVar.wWp != null) {
                    vVar.wWp.stopPlayback();
                }
                if (vVar.wWp == null) {
                    vVar.wWp = new VideoView(vVar.getContext());
                }
                vVar.mUrl = bundleExtra.getString("videoUrl");
                vVar.wWp.setVideoURI(Uri.parse(vVar.mUrl));
                vVar.wWp.setOnErrorListener(vVar);
                intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Context applicationContext = vVar.getContext().getApplicationContext();
                intent.setPackage(applicationContext.getPackageName());
                applicationContext.startActivity(intent);
            }
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        u.gy(this).k(this, 4);
    }

    protected void onPause() {
        super.onPause();
        u.gy(this).k(this, 3);
    }

    protected void onResume() {
        super.onResume();
        u.gy(this).k(this, 2);
    }

    protected void onStop() {
        super.onStop();
        u.gy(this).k(this, 1);
    }
}
