package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.am;
import android.support.v4.app.am.a;
import android.support.v4.app.u;
import android.support.v4.view.g;
import android.support.v7.widget.ar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.database.SQLiteDatabase;

public class AppCompatActivity extends FragmentActivity implements a, c {
    private Resources Cu;
    private d Gp;
    private int Gq = 0;
    private boolean Gr;

    public void onCreate(Bundle bundle) {
        d cO = cO();
        cO.cR();
        cO.onCreate(bundle);
        if (cO.cS() && this.Gq != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.Gq, false);
            } else {
                setTheme(this.Gq);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.Gq = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        cO().cQ();
    }

    public MenuInflater getMenuInflater() {
        return cO().getMenuInflater();
    }

    public void setContentView(int i) {
        cO().setContentView(i);
    }

    public void setContentView(View view) {
        cO().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        cO().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        cO().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cO().onConfigurationChanged(configuration);
        if (this.Cu != null) {
            this.Cu.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onStop() {
        super.onStop();
        cO().onStop();
    }

    protected void onPostResume() {
        super.onPostResume();
        cO().onPostResume();
    }

    public View findViewById(int i) {
        return cO().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar cP = cO().cP();
        if (menuItem.getItemId() != 16908332 || cP == null || (cP.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return cN();
    }

    public void onDestroy() {
        super.onDestroy();
        cO().onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        cO().setTitle(charSequence);
    }

    public final boolean aq(int i) {
        return cO().requestWindowFeature(i);
    }

    public void aQ() {
        cO().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        cO().invalidateOptionsMenu();
    }

    private boolean cN() {
        int i = 0;
        Intent a = u.a(this);
        if (a == null) {
            return false;
        }
        if (u.a((Activity) this, a)) {
            Intent a2;
            am j = am.j(this);
            if (this instanceof a) {
                a = bo();
            } else {
                a = null;
            }
            if (a == null) {
                a2 = u.a(this);
            } else {
                a2 = a;
            }
            if (a2 != null) {
                ComponentName component = a2.getComponent();
                if (component == null) {
                    component = a2.resolveActivity(j.tk.getPackageManager());
                }
                j.a(component);
                j.tj.add(a2);
            }
            if (j.tj.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) j.tj.toArray(new Intent[j.tj.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = j.tk;
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                context.startActivities(intentArr, null);
                i = 1;
            } else if (i2 >= 11) {
                context.startActivities(intentArr);
                i = 1;
            }
            if (i == 0) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                j.tk.startActivity(intent);
            }
            try {
                if (VERSION.SDK_INT >= 16) {
                    finishAffinity();
                } else {
                    finish();
                }
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            u.b((Activity) this, a);
        }
        return true;
    }

    public final Intent bo() {
        return u.a(this);
    }

    public void onContentChanged() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        cO().onSaveInstanceState(bundle);
    }

    public final d cO() {
        if (this.Gp == null) {
            this.Gp = d.a((Activity) this, (c) this);
        }
        return this.Gp;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (g.a(keyEvent, Downloads.RECV_BUFFER_SIZE) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                ActionBar cP = cO().cP();
                if (cP != null && cP.isShowing() && cP.requestFocus()) {
                    this.Gr = true;
                    return true;
                }
            } else if (action == 1 && this.Gr) {
                this.Gr = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.Cu == null && ar.hd()) {
            this.Cu = new ar(this, super.getResources());
        }
        return this.Cu == null ? super.getResources() : this.Cu;
    }
}
