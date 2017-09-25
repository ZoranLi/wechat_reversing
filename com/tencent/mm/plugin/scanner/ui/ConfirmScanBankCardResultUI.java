package com.tencent.mm.plugin.scanner.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;

@a(3)
public class ConfirmScanBankCardResultUI extends MMActivity {
    protected static final Map<String, Bitmap> oYy = new HashMap();
    protected Bitmap mBmp = null;
    private EditText oYA;
    private String oYx = null;
    private ImageView oYz;

    public static void b(Bitmap bitmap, String str) {
        if (bitmap != null && !bitmap.isRecycled() && !bg.mA(str)) {
            Intent intent = new Intent();
            intent.setClass(ab.getContext(), ConfirmScanBankCardResultUI.class);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.putExtra("_card_num_", str);
            String str2 = "_image_cache_key_" + str;
            oYy.put(str2, bitmap);
            intent.putExtra("_image_cache_key_", str2);
            ab.getContext().startActivity(intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        zi(R.l.ffg);
        if (getIntent() == null) {
            w.e("MicroMsg.ConfirmScanBankCardResultUI", "intent is null, return");
            obj = null;
        } else {
            this.oYx = getIntent().getStringExtra("_image_cache_key_");
            if (bg.mA(this.oYx)) {
                w.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp cache key is null or nil");
                obj = null;
            } else {
                this.mBmp = (Bitmap) oYy.get(this.oYx);
                if (this.mBmp == null || this.mBmp.isRecycled()) {
                    w.e("MicroMsg.ConfirmScanBankCardResultUI", "bmp invalid, return");
                    obj = null;
                } else {
                    obj = 1;
                }
            }
        }
        if (obj == null) {
            finish();
            return;
        }
        CharSequence stringExtra = getIntent().getStringExtra("_card_num_");
        if (bg.mA(stringExtra)) {
            w.e("MicroMsg.ConfirmScanBankCardResultUI", "cardNum is null or nil");
            finish();
            return;
        }
        this.oYz = (ImageView) findViewById(R.h.bWC);
        this.oYA = (EditText) findViewById(R.h.bKF);
        this.oYz.setImageBitmap(this.mBmp);
        this.oYA.setText(stringExtra);
        findViewById(R.h.bvD).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ConfirmScanBankCardResultUI oYB;

            {
                this.oYB = r1;
            }

            public final void onClick(View view) {
                if (this.oYB.oYA != null) {
                    String obj = this.oYB.oYA.getEditableText().toString();
                    if (!bg.mA(obj)) {
                        b nmVar = new nm();
                        nmVar.fUD.action = 1;
                        nmVar.fUD.cardNum = obj;
                        com.tencent.mm.sdk.b.a.urY.m(nmVar);
                        super.finish();
                    }
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ConfirmScanBankCardResultUI oYB;

            {
                this.oYB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oYB.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.oYz != null) {
            this.oYz.setImageBitmap(null);
        }
        if (!bg.mA(this.oYx)) {
            oYy.remove(this.oYx);
        }
        if (this.mBmp != null) {
            this.mBmp.recycle();
        }
    }

    public void finish() {
        Intent intent = new Intent();
        intent.putExtra("BaseScanUI_select_scan_mode", 7);
        intent.putExtra("scan_bankcard_with_confirm_ui", true);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setClass(this, BaseScanUI.class);
        startActivity(intent);
        super.finish();
    }

    protected final int getLayoutId() {
        return R.i.cZr;
    }

    protected final int Ol() {
        return 1;
    }
}
