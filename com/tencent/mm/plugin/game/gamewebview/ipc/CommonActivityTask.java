package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.i.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.storage.a.c;
import com.tencent.wcdb.database.SQLiteDatabase;

public class CommonActivityTask extends GameProcessActivityTask {
    public static final Creator<CommonActivityTask> CREATOR = new Creator<CommonActivityTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonActivityTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonActivityTask[i];
        }
    };
    public Bundle lHw = new Bundle();
    public int type;

    public final void a(Context context, final a aVar) {
        String string;
        String string2;
        switch (this.type) {
            case 1:
                string = this.lHw.getString("result");
                if (!bg.mA(string)) {
                    string2 = this.lHw.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    int i = this.lHw.getInt("codeType");
                    int i2 = this.lHw.getInt("codeVersion");
                    Intent intent = new Intent();
                    intent.setClass(context, WebviewScanImageActivity.class);
                    intent.setFlags(603979776);
                    intent.putExtra("key_string_for_scan", string);
                    intent.putExtra("key_string_for_url", string2);
                    intent.putExtra("key_codetype_for_scan", i);
                    intent.putExtra("key_codeversion_for_scan", i2);
                    context.startActivity(intent);
                    aVar.TP();
                    return;
                }
                return;
            case 2:
                string2 = this.lHw.getString("img_path");
                Intent intent2;
                if (o.Pj(string2)) {
                    c ub = ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(g.aV(string2));
                    c ub2 = (ub == null || !ub.bNr()) ? ((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(((com.tencent.mm.plugin.emoji.b.c) h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uc(string2)) : ub;
                    boolean aN = ub2 == null ? false : e.aN(ub2.eN(ub2.field_groupId, ub2.EP()));
                    string = ub2 == null ? string2 : ub2.eN(ub2.field_groupId, ub2.EP());
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    boolean z = (d.decodeFile(string, options) != null && options.outHeight > b.sB()) || options.outWidth > b.sB();
                    if (aN > b.sC() || z) {
                        com.tencent.mm.ui.base.g.a(context, context.getString(R.l.ecw), "", context.getString(R.l.esq), null);
                        com.tencent.mm.ui.base.g.a(context, context.getString(R.l.ecw), "", context.getString(R.l.esq), "", false, new OnClickListener(this) {
                            final /* synthetic */ CommonActivityTask mjq;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.TP();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ CommonActivityTask mjq;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                aVar.TP();
                            }
                        });
                        return;
                    }
                    intent2 = new Intent();
                    intent2.putExtra("Retr_File_Name", ub2.EP());
                    intent2.putExtra("Retr_Msg_Type", 5);
                    intent2.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.plugin.webview.a.a.imv.l(intent2, context);
                    aVar.TP();
                    return;
                }
                intent2 = new Intent();
                intent2.putExtra("Retr_File_Name", string2);
                intent2.putExtra("Retr_Compress_Type", 0);
                intent2.putExtra("Retr_Msg_Type", 0);
                intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                com.tencent.mm.plugin.webview.a.a.imv.l(intent2, context);
                aVar.TP();
                return;
            default:
                return;
        }
    }

    public final void SK() {
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.lHw = parcel.readBundle(getClass().getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.lHw);
    }

    public CommonActivityTask(Context context) {
        super(context);
    }

    public CommonActivityTask(Parcel parcel) {
        f(parcel);
    }
}
