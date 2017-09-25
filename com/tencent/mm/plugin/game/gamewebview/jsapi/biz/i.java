package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.gamewebview.a.d;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.GameWebViewBaseActivity;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.l;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class i extends a {
    public static final int CTRL_BYTE = 254;
    public static final String NAME = "chooseMedia";
    public int iLf;
    private MMActivity.a mjv = new MMActivity.a(this) {
        final /* synthetic */ i mko;

        {
            this.mko = r1;
        }

        public final void a(int i, int i2, Intent intent) {
            if (i == (this.mko.hashCode() & 65535)) {
                switch (i2) {
                    case -1:
                        if (intent == null) {
                            w.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                            this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:fail", null));
                            return;
                        }
                        int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        String stringExtra;
                        Map hashMap;
                        if (intExtra == 1) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            w.i("MicroMsg.GameJsApiChooseMedia", "video localId:%s", new Object[]{stringExtra});
                            w.i("MicroMsg.GameJsApiChooseMedia", "video thumbLocalId:%s", new Object[]{stringExtra2});
                            if (bg.mA(stringExtra)) {
                                w.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:fail", null));
                                return;
                            }
                            WebViewJSSDKFileItem xu = d.xu(stringExtra);
                            if (xu == null || !(xu instanceof WebViewJSSDKVideoItem)) {
                                w.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                break;
                            }
                            WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) xu;
                            w.i("MicroMsg.GameJsApiChooseMedia", "after parse to json data : %s", new Object[]{ah.a(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size)});
                            hashMap = new HashMap();
                            hashMap.put(Columns.TYPE, Integer.valueOf(1));
                            hashMap.put("localIds", stringExtra);
                            this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:ok", hashMap));
                            return;
                        } else if (intExtra == 2) {
                            stringExtra = intent.getStringExtra("key_pick_local_media_local_ids");
                            w.i("MicroMsg.GameJsApiChooseMedia", "chooseMedia localIds:%s", new Object[]{stringExtra});
                            if (bg.mA(stringExtra)) {
                                w.e("MicroMsg.GameJsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:fail", null));
                                return;
                            }
                            hashMap = new HashMap();
                            hashMap.put(Columns.TYPE, Integer.valueOf(2));
                            hashMap.put("localIds", stringExtra);
                            this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:ok", hashMap));
                            return;
                        } else {
                            w.e("MicroMsg.GameJsApiChooseMedia", "type:%d is error", new Object[]{Integer.valueOf(intExtra)});
                            this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:fail", null));
                            return;
                        }
                        break;
                    case 0:
                        this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:cancel", null));
                        return;
                }
                this.mko.mkn.x(this.mko.iLf, d.d("chooseMedia:fail", null));
            }
        }
    };
    public GameWebViewBaseActivity mkm;
    public com.tencent.mm.plugin.game.gamewebview.ui.d mkn;

    public final void a(final com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, final int i) {
        w.i("MicroMsg.GameJsApiChooseMedia", "invoke");
        if (jSONObject == null) {
            w.i("MicroMsg.GameJsApiChooseMedia", "data is null");
            dVar.x(i, a.d("doChooseMedia:fail_invalid_data", null));
            return;
        }
        this.mkn = dVar;
        this.iLf = i;
        this.mkm = dVar.azK();
        w.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkcamera[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.mkm, "android.permission.CAMERA", 119, "", ""))});
        w.i("MicroMsg.GameJsApiChooseMedia", " checkPermission checkMicroPhone[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.mkm, "android.permission.RECORD_AUDIO", 120, "", ""))});
        if (com.tencent.mm.pluginsdk.i.a.a(this.mkm, "android.permission.RECORD_AUDIO", 120, "", "") && r0) {
            String str;
            String mz = bg.mz(jSONObject.optString("sourceType"));
            String optString = jSONObject.optString("mediaType", "");
            int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
            final String optString2 = jSONObject.optString("camera", "");
            int optInt = jSONObject.optInt("count", 1);
            String optString3 = jSONObject.optString("sizeType", "");
            w.i("MicroMsg.GameJsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", new Object[]{mz, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3});
            final Intent intent = new Intent();
            intent.putExtra("key_pick_local_pic_count", optInt);
            if (min <= 0) {
                min = 10;
            }
            intent.putExtra("key_pick_local_media_duration", min);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("key_pick_local_media_video_type", 2);
            intent.putExtra("key_pick_local_media_sight_type", optString);
            intent.putExtra("key_pick_local_pic_query_source_type", (optString3.contains("original") ^ optString3.contains("compressed")) != 0 ? 7 : 8);
            intent.putExtra("key_pick_local_pic_send_raw", Boolean.valueOf(optString3.contains("compressed")));
            if (bg.mA(mz)) {
                str = "album|camera";
            } else {
                str = mz;
            }
            if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
                l lVar = new l(this.mkm);
                lVar.b(null, new OnCreateContextMenuListener(this) {
                    final /* synthetic */ i mko;

                    {
                        this.mko = r1;
                    }

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                        contextMenu.add(0, 1, 0, this.mko.mkm.getString(R.l.dHa));
                        contextMenu.add(0, 2, 1, this.mko.mkm.getString(R.l.dHe));
                    }
                }, new n.d(this) {
                    final /* synthetic */ i mko;

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                this.mko.a(optString2, intent);
                                return;
                            case 2:
                                this.mko.E(intent);
                                return;
                            default:
                                return;
                        }
                    }
                });
                lVar.e(new OnCancelListener(this) {
                    final /* synthetic */ i mko;

                    public final void onCancel(DialogInterface dialogInterface) {
                        com.tencent.mm.plugin.game.gamewebview.ui.d dVar = dVar;
                        int i = i;
                        i iVar = this.mko;
                        dVar.x(i, a.d("doChooseMedia:cancel", null));
                    }
                });
                lVar.blb();
                return;
            } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                E(intent);
                return;
            } else if (str.contains("camera")) {
                a(optString2, intent);
                return;
            } else {
                dVar.x(i, a.d("chooseMedia:fail_sourceType_error", null));
                return;
            }
        }
        dVar.x(i, a.d("doChooseMedia:fail_no_user_permission", null));
    }

    public final void a(String str, Intent intent) {
        int i;
        w.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i = 16;
        } else {
            i = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i);
        this.mkm.uSV = this.mjv;
        com.tencent.mm.bb.d.a(this.mkm, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }

    public final void E(Intent intent) {
        w.i("MicroMsg.GameJsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", Downloads.RECV_BUFFER_SIZE);
        this.mkm.uSV = this.mjv;
        com.tencent.mm.bb.d.a(this.mkm, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
    }
}
