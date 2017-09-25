package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.i.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.l.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private Cursor Bo;
    private ae mHandler;
    private RingtoneManager plP;
    LayoutInflater plQ;
    private int plR = -1;
    private int plS = -1;
    private Ringtone plT;

    private class a extends BaseAdapter {
        int count = 0;
        Cursor fIu;
        int padding = 0;
        final /* synthetic */ SettingsRingtoneUI plU;

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public a(SettingsRingtoneUI settingsRingtoneUI, Cursor cursor) {
            this.plU = settingsRingtoneUI;
            this.fIu = cursor;
            this.count = cursor.getCount() + 1;
            w.d("RingtonePickerActivity", "count = " + this.count);
            this.padding = settingsRingtoneUI.getResources().getDimensionPixelSize(R.f.aXH);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) this.plU.plQ.inflate(R.i.select_dialog_singlechoice, null);
            if (i == 0) {
                checkedTextView.setBackgroundResource(R.g.beo);
                checkedTextView.setText(R.l.eTj);
            } else {
                checkedTextView.setBackgroundResource(R.g.beo);
                checkedTextView.setText(hO(i));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(R.g.bjb);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String hO(int i) {
            if (this.fIu.isClosed() || !this.fIu.moveToPosition(i - 1)) {
                return "";
            }
            return this.fIu.getString(this.fIu.getColumnIndex("title"));
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ae();
        this.plQ = LayoutInflater.from(this);
        this.plP = new RingtoneManager(this);
        this.plP.setType(2);
        setVolumeControlStream(5);
        this.plT = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        zi(R.l.eTk);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsRingtoneUI plU;

            {
                this.plU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plU.aHf();
                this.plU.finish();
                return true;
            }
        });
        a(0, getString(R.l.eSG), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsRingtoneUI plU;

            {
                this.plU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String uri;
                Editor edit = this.plU.getSharedPreferences(ab.bIX(), 0).edit();
                if (this.plU.plS != 0) {
                    Uri a = this.plU.plP.getRingtoneUri(this.plU.plS - 1);
                    w.d("RingtonePickerActivity", "set ringtone to " + a);
                    if (a != null) {
                        uri = a.toString();
                        String a2 = RingtoneManager.getRingtone(this.plU, a).getTitle(this.plU);
                        edit.putString("settings.ringtone.name", a2);
                        w.d("RingtonePickerActivity", "ringtone name: " + a2);
                    } else {
                        uri = f.gTd;
                        edit.putString("settings.ringtone.name", this.plU.getString(R.l.eTj));
                        w.d("RingtonePickerActivity", "set ringtone follow system");
                    }
                } else {
                    uri = f.gTd;
                    edit.putString("settings.ringtone.name", this.plU.getString(R.l.eTj));
                    w.d("RingtonePickerActivity", "set ringtone follow system");
                }
                edit.commit();
                f.dA(uri);
                this.plU.finish();
                return true;
            }
        }, b.uTY);
        ListView listView = (ListView) findViewById(R.h.cDv);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXt);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.Bo = this.plP.getCursor();
        listView.setAdapter(new a(this, this.Bo));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String sp = f.sp();
        if (sp != f.gTd) {
            int ringtonePosition = this.plP.getRingtonePosition(Uri.parse(sp));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.plR = ringtonePosition;
            if (this.plR == 1) {
                getSharedPreferences(ab.bIX(), 0).edit().putString("settings.ringtone.name", getString(R.l.eTj)).commit();
                w.d("RingtonePickerActivity", "set ringtone follow system");
            }
            this.plS = this.plR - 1;
        } else {
            this.plR = 1;
        }
        listView.setItemChecked(this.plR, true);
        listView.setSelection(this.plR);
    }

    protected final int getLayoutId() {
        return R.i.doe;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mHandler.removeCallbacks(this);
        this.plS = i - 1;
        this.mHandler.postDelayed(this, 300);
    }

    public void run() {
        if (!isFinishing()) {
            Ringtone ringtone;
            if (this.plS == 0) {
                ringtone = this.plT;
            } else {
                ringtone = this.plP.getRingtone(this.plS - 1);
            }
            if (ringtone != null) {
                try {
                    ringtone.play();
                } catch (Throwable e) {
                    w.printErrStackTrace("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
                }
            }
        }
    }

    protected void onStop() {
        this.plP.stopPreviousRingtone();
        super.onStop();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacks(this);
        if (!(this.Bo == null || this.Bo.isClosed())) {
            this.Bo.close();
            this.Bo = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
