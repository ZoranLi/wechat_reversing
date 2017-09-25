package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import java.util.ArrayList;

@a(7)
public final class GalleryEntryUI extends ActionBarActivity {
    private boolean jjz = false;
    private boolean kJl = false;
    private int mgH;
    private int mgf;

    protected final void onCreate(Bundle bundle) {
        w.i("MicroMsg.GalleryEntryUI", "on create");
        super.onCreate(bundle);
        w.i("MicroMsg.GalleryEntryUI", "checktask onCreate:%s#0x%x task:%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(hashCode()), bg.eq(this)});
        c.initialize();
        this.mgf = getIntent().getIntExtra("query_source_type", 3);
        this.mgH = getIntent().getIntExtra("query_media_type", 1);
        w.i("MicroMsg.GalleryEntryUI", "query souce: " + this.mgf + ", queryType: " + this.mgH);
        c.ayk().nc(this.mgH);
        c.ayk().nd(this.mgf);
    }

    protected final void onRestoreInstanceState(Bundle bundle) {
        w.d("MicroMsg.GalleryEntryUI", "onRestoreInstanceState");
        super.onRestoreInstanceState(bundle);
        this.kJl = true;
    }

    protected final void onResume() {
        w.i("MicroMsg.GalleryEntryUI", "on resume, init %B", new Object[]{Boolean.valueOf(this.kJl)});
        super.onResume();
        if (!this.kJl) {
            w.e("MicroMsg.GalleryEntryUI", "doRedirect %s", new Object[]{bg.bJZ()});
            Intent intent = getIntent();
            if (intent.getBooleanExtra("preview_image", false)) {
                w.d("MicroMsg.GalleryEntryUI", "jump to preview ui directly");
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                Intent intent2 = new Intent(this, ImagePreviewUI.class);
                intent2.addFlags(67108864);
                intent2.putExtra("max_select_count", intent.getIntExtra("max_select_count", 9));
                intent2.putExtra("query_source_type", this.mgf);
                intent2.putExtra("isPreviewPhoto", intent.getBooleanExtra("isPreviewPhoto", false));
                intent2.putExtra("preview_image", intent.getBooleanExtra("preview_image", false));
                String stringExtra = getIntent().getStringExtra("GalleryUI_FromUser");
                String stringExtra2 = getIntent().getStringExtra("GalleryUI_ToUser");
                if (!bg.mA(stringExtra)) {
                    intent2.putExtra("GalleryUI_FromUser", stringExtra);
                }
                if (!bg.mA(stringExtra2)) {
                    intent2.putExtra("GalleryUI_ToUser", stringExtra2);
                }
                intent2.putStringArrayListExtra("preview_image_list", stringArrayListExtra);
                startActivityForResult(intent2, 1);
            } else {
                intent.setClass(this, AlbumPreviewUI.class);
                intent.addFlags(67108864);
                intent.putExtra("send_btn_string", getIntent().getStringExtra("send_btn_string"));
                intent.putExtra("max_select_count", getIntent().getIntExtra("max_select_count", 9));
                intent.putExtra("GalleryUI_FromUser", getIntent().getStringExtra("GalleryUI_FromUser"));
                intent.putExtra("GalleryUI_ToUser", getIntent().getStringExtra("GalleryUI_ToUser"));
                intent.putExtra("key_send_raw_image", getIntent().getBooleanExtra("key_send_raw_image", false));
                startActivityForResult(intent, 0);
            }
            this.kJl = true;
        }
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        w.d("MicroMsg.GalleryEntryUI", "on new intent, #0x%x", new Object[]{Integer.valueOf(hashCode())});
    }

    protected final void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.GalleryEntryUI";
        String str2 = "on activity result, requestCode %d resultCode %d, data:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = intent == null ? "" : intent.toString();
        w.i(str, str2, objArr);
        this.jjz = true;
        switch (i2) {
            case -1:
                if (intent != null) {
                    setResult(-1, intent);
                    break;
                }
                return;
            case 0:
                w.d("MicroMsg.GalleryEntryUI", "user choose canceld");
                setResult(0);
                break;
            case 1:
                setResult(1);
                break;
        }
        if (this.jjz) {
            finish();
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.GalleryEntryUI", "onDestroy %B", new Object[]{Boolean.valueOf(this.jjz)});
        c.er(this.jjz);
        w.i("MicroMsg.GalleryEntryUI", "checktask onDestroy:%s#0x%x task:%s ", new Object[]{getClass().getSimpleName(), Integer.valueOf(hashCode()), bg.eq(this)});
    }
}
