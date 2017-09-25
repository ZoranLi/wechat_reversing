package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class ad extends Resources {
    private final Resources Cu;

    public ad(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.Cu = resources;
    }

    public CharSequence getText(int i) {
        return this.Cu.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.Cu.getQuantityText(i, i2);
    }

    public String getString(int i) {
        return this.Cu.getString(i);
    }

    public String getString(int i, Object... objArr) {
        return this.Cu.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.Cu.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) {
        return this.Cu.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.Cu.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        return this.Cu.getTextArray(i);
    }

    public String[] getStringArray(int i) {
        return this.Cu.getStringArray(i);
    }

    public int[] getIntArray(int i) {
        return this.Cu.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.Cu.obtainTypedArray(i);
    }

    public float getDimension(int i) {
        return this.Cu.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.Cu.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.Cu.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.Cu.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) {
        return this.Cu.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) {
        return this.Cu.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.Cu.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.Cu.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) {
        return this.Cu.getMovie(i);
    }

    public int getColor(int i) {
        return this.Cu.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.Cu.getColorStateList(i);
    }

    public boolean getBoolean(int i) {
        return this.Cu.getBoolean(i);
    }

    public int getInteger(int i) {
        return this.Cu.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.Cu.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) {
        return this.Cu.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) {
        return this.Cu.getXml(i);
    }

    public InputStream openRawResource(int i) {
        return this.Cu.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.Cu.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.Cu.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.Cu.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.Cu.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.Cu.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.Cu.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.Cu != null) {
            this.Cu.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.Cu.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.Cu.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.Cu.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) {
        return this.Cu.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.Cu.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.Cu.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) {
        return this.Cu.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.Cu.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.Cu.parseBundleExtra(str, attributeSet, bundle);
    }
}
