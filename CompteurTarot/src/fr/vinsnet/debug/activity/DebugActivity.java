package fr.vinsnet.debug.activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

public class DebugActivity extends Activity {

	private static final String TAG = "DebugActivity";

	@Override
	public void addContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		Log.v(TAG,"addContentView");
		super.addContentView(view, params);
	}

	@Override
	public void closeContextMenu() {
		// TODO Auto-generated method stub
		Log.v(TAG,"closeContextMenu");
		super.closeContextMenu();
	}

	@Override
	public void closeOptionsMenu() {
		// TODO Auto-generated method stub
		Log.v(TAG,"closeOptionsMenu");
		super.closeOptionsMenu();
	}

	@Override
	public PendingIntent createPendingResult(int requestCode, Intent data,
			int flags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"createPendingResult");
		return super.createPendingResult(requestCode, data, flags);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"dispatchKeyEvent");
		return super.dispatchKeyEvent(event);
	}

	@Override
	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"dispatchPopulateAccessibilityEvent");
		return super.dispatchPopulateAccessibilityEvent(event);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.v(TAG,"dispatchTouchEvent");
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public boolean dispatchTrackballEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		Log.v(TAG,"dispatchTrackballEvent");
		return super.dispatchTrackballEvent(ev);
	}

	@Override
	public View findViewById(int id) {
		// TODO Auto-generated method stub
		Log.v(TAG,"findViewById");
		return super.findViewById(id);
	}

	@Override
	public void finish() {
		// TODO Auto-generated method stub
		Log.v(TAG,"finish");
		super.finish();
	}

	@Override
	public void finishActivity(int requestCode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"finishActivity");
		super.finishActivity(requestCode);
	}

	@Override
	public void finishActivityFromChild(Activity child, int requestCode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"finishActivityFromChild");
		super.finishActivityFromChild(child, requestCode);
	}

	@Override
	public void finishFromChild(Activity child) {
		// TODO Auto-generated method stub
		Log.v(TAG,"finishFromChild");
		super.finishFromChild(child);
	}

	@Override
	public ComponentName getCallingActivity() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getCallingActivity");
		return super.getCallingActivity();
	}

	@Override
	public String getCallingPackage() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getCallingPackage");
		return super.getCallingPackage();
	}

	@Override
	public int getChangingConfigurations() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getChangingConfigurations");
		return super.getChangingConfigurations();
	}

	@Override
	public ComponentName getComponentName() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getComponentName");
		return super.getComponentName();
	}

	@Override
	public View getCurrentFocus() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getCurrentFocus");
		return super.getCurrentFocus();
	}

	@Override
	public Intent getIntent() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getIntent");
		return super.getIntent();
	}

	@Override
	public Object getLastNonConfigurationInstance() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getLastNonConfigurationInstance");
		return super.getLastNonConfigurationInstance();
	}

	@Override
	public LayoutInflater getLayoutInflater() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getLayoutInflater");
		return super.getLayoutInflater();
	}

	@Override
	public String getLocalClassName() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getLocalClassName");
		return super.getLocalClassName();
	}

	@Override
	public MenuInflater getMenuInflater() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getMenuInflater");
		return super.getMenuInflater();
	}

	@Override
	public SharedPreferences getPreferences(int mode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getPreferences");
		return super.getPreferences(mode);
	}

	@Override
	public int getRequestedOrientation() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getRequestedOrientation");
		return super.getRequestedOrientation();
	}

	@Override
	public Object getSystemService(String name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getSystemService");
		return super.getSystemService(name);
	}

	@Override
	public int getTaskId() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getTaskId");
		return super.getTaskId();
	}

	@Override
	public int getWallpaperDesiredMinimumHeight() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getWallpaperDesiredMinimumHeight");
		return super.getWallpaperDesiredMinimumHeight();
	}

	@Override
	public int getWallpaperDesiredMinimumWidth() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getWallpaperDesiredMinimumWidth");
		return super.getWallpaperDesiredMinimumWidth();
	}

	@Override
	public Window getWindow() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getWindow");
		return super.getWindow();
	}

	@Override
	public WindowManager getWindowManager() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getWindowManager");
		return super.getWindowManager();
	}

	@Override
	public boolean hasWindowFocus() {
		// TODO Auto-generated method stub
		Log.v(TAG,"hasWindowFocus");
		return super.hasWindowFocus();
	}

	@Override
	public boolean isFinishing() {
		// TODO Auto-generated method stub
		Log.v(TAG,"isFinishing");
		return super.isFinishing();
	}

	@Override
	public boolean isTaskRoot() {
		// TODO Auto-generated method stub
		Log.v(TAG,"isTaskRoot");
		return super.isTaskRoot();
	}

	@Override
	public boolean moveTaskToBack(boolean nonRoot) {
		// TODO Auto-generated method stub
		Log.v(TAG,"moveTaskToBack");
		return super.moveTaskToBack(nonRoot);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onActivityResult");
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected void onApplyThemeResource(Theme theme, int resid, boolean first) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onApplyThemeResource");
		super.onApplyThemeResource(theme, resid, first);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onAttachedToWindow");
		super.onAttachedToWindow();
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onBackPressed");
		super.onBackPressed();
	}

	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onChildTitleChanged");
		super.onChildTitleChanged(childActivity, title);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onConfigurationChanged");
		super.onConfigurationChanged(newConfig);
	}

	@Override
	public void onContentChanged() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onContentChanged");
		super.onContentChanged();
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onContextItemSelected");
		return super.onContextItemSelected(item);
	}

	@Override
	public void onContextMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onContextMenuClosed");
		super.onContextMenuClosed(menu);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreate");
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateContextMenu");
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	@Override
	public CharSequence onCreateDescription() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateDescription");
		return super.onCreateDescription();
	}

	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateDialog");
		return super.onCreateDialog(id, args);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateDialog");
		return super.onCreateDialog(id);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateOptionsMenu");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onCreatePanelMenu(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreatePanelMenu");
		return super.onCreatePanelMenu(featureId, menu);
	}

	@Override
	public View onCreatePanelView(int featureId) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreatePanelView");
		return super.onCreatePanelView(featureId);
	}

	@Override
	public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateThumbnail");
		return super.onCreateThumbnail(outBitmap, canvas);
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onCreateView");
		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onDestroy");
		super.onDestroy();
	}

	@Override
	public void onDetachedFromWindow() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onDetachedFromWindow");
		super.onDetachedFromWindow();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onKeyDown");
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onKeyLongPress");
		return super.onKeyLongPress(keyCode, event);
	}

	@Override
	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onKeyMultiple");
		return super.onKeyMultiple(keyCode, repeatCount, event);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onKeyUp");
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onLowMemory");
		super.onLowMemory();
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onMenuItemSelected");
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onMenuOpened");
		return super.onMenuOpened(featureId, menu);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onNewIntent");
		super.onNewIntent(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onOptionsItemSelected");
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onOptionsMenuClosed");
		super.onOptionsMenuClosed(menu);
	}

	@Override
	public void onPanelClosed(int featureId, Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPanelClosed");
		super.onPanelClosed(featureId, menu);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPause");
		super.onPause();
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPostCreate");
		super.onPostCreate(savedInstanceState);
	}

	@Override
	protected void onPostResume() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPostResume");
		super.onPostResume();
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPrepareDialog");
		super.onPrepareDialog(id, dialog, args);
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPrepareDialog");
		super.onPrepareDialog(id, dialog);
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPrepareOptionsMenu");
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onPreparePanel(int featureId, View view, Menu menu) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onPreparePanel");
		return super.onPreparePanel(featureId, view, menu);
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onRestart");
		super.onRestart();
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onResume");
		super.onResume();
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onRetainNonConfigurationInstance");
		return super.onRetainNonConfigurationInstance();
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onSearchRequested");
		return super.onSearchRequested();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onStop");
		super.onStop();
	}

	@Override
	protected void onTitleChanged(CharSequence title, int color) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onTitleChanged");
		super.onTitleChanged(title, color);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onTouchEvent");
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onTrackballEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onTrackballEvent");
		return super.onTrackballEvent(event);
	}

	@Override
	public void onUserInteraction() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onUserInteraction");
		super.onUserInteraction();
	}

	@Override
	protected void onUserLeaveHint() {
		// TODO Auto-generated method stub
		Log.v(TAG,"onUserLeaveHint");
		super.onUserLeaveHint();
	}

	@Override
	public void onWindowAttributesChanged(
			android.view.WindowManager.LayoutParams params) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onWindowAttributesChanged");
		super.onWindowAttributesChanged(params);
	}

	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		Log.v(TAG,"onWindowFocusChanged");
		super.onWindowFocusChanged(hasFocus);
	}

	@Override
	public void openContextMenu(View view) {
		// TODO Auto-generated method stub
		Log.v(TAG,"openContextMenu");
		super.openContextMenu(view);
	}

	@Override
	public void openOptionsMenu() {
		// TODO Auto-generated method stub
		Log.v(TAG,"openOptionsMenu");
		super.openOptionsMenu();
	}

	@Override
	public void overridePendingTransition(int enterAnim, int exitAnim) {
		// TODO Auto-generated method stub
		Log.v(TAG,"overridePendingTransition");
		super.overridePendingTransition(enterAnim, exitAnim);
	}

	@Override
	public void registerForContextMenu(View view) {
		// TODO Auto-generated method stub
		Log.v(TAG,"registerForContextMenu");
		super.registerForContextMenu(view);
	}

	@Override
	public void setContentView(int layoutResID) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setContentView");
		super.setContentView(layoutResID);
	}

	@Override
	public void setContentView(View view, LayoutParams params) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setContentView");
		super.setContentView(view, params);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setContentView");
		super.setContentView(view);
	}

	@Override
	public void setIntent(Intent newIntent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setIntent");
		super.setIntent(newIntent);
	}

	@Override
	public void setPersistent(boolean isPersistent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setPersistent");
		super.setPersistent(isPersistent);
	}

	@Override
	public void setRequestedOrientation(int requestedOrientation) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setRequestedOrientation");
		super.setRequestedOrientation(requestedOrientation);
	}

	@Override
	public void setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setTitle");
		super.setTitle(title);
	}

	@Override
	public void setTitle(int titleId) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setTitle");
		super.setTitle(titleId);
	}

	@Override
	public void setTitleColor(int textColor) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setTitleColor");
		super.setTitleColor(textColor);
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setVisible");
		super.setVisible(visible);
	}

	@Override
	public void startActivity(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startActivity");
		super.startActivity(intent);
	}

	@Override
	public void startActivityForResult(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startActivityForResult");
		super.startActivityForResult(intent, requestCode);
	}

	@Override
	public void startActivityFromChild(Activity child, Intent intent,
			int requestCode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startActivityFromChild");
		super.startActivityFromChild(child, intent, requestCode);
	}

	@Override
	public boolean startActivityIfNeeded(Intent intent, int requestCode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startActivityIfNeeded");
		return super.startActivityIfNeeded(intent, requestCode);
	}

	@Override
	public void startIntentSender(IntentSender intent, Intent fillInIntent,
			int flagsMask, int flagsValues, int extraFlags)
			throws SendIntentException {
		// TODO Auto-generated method stub
		Log.v(TAG,"startIntentSender");
		super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues,
				extraFlags);
	}

	@Override
	public void startIntentSenderForResult(IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		Log.v(TAG,"startIntentSenderForResult");
		super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask,
				flagsValues, extraFlags);
	}

	@Override
	public void startIntentSenderFromChild(Activity child, IntentSender intent,
			int requestCode, Intent fillInIntent, int flagsMask,
			int flagsValues, int extraFlags) throws SendIntentException {
		// TODO Auto-generated method stub
		Log.v(TAG,"startIntentSenderFromChild");
		super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent,
				flagsMask, flagsValues, extraFlags);
	}

	@Override
	public void startManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startManagingCursor");
		super.startManagingCursor(c);
	}

	@Override
	public boolean startNextMatchingActivity(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startNextMatchingActivity");
		return super.startNextMatchingActivity(intent);
	}

	@Override
	public void startSearch(String initialQuery, boolean selectInitialQuery,
			Bundle appSearchData, boolean globalSearch) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startSearch");
		super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
	}

	@Override
	public void stopManagingCursor(Cursor c) {
		// TODO Auto-generated method stub
		Log.v(TAG,"stopManagingCursor");
		super.stopManagingCursor(c);
	}

	@Override
	public void takeKeyEvents(boolean get) {
		// TODO Auto-generated method stub
		Log.v(TAG,"takeKeyEvents");
		super.takeKeyEvents(get);
	}

	@Override
	public void triggerSearch(String query, Bundle appSearchData) {
		// TODO Auto-generated method stub
		Log.v(TAG,"triggerSearch");
		super.triggerSearch(query, appSearchData);
	}

	@Override
	public void unregisterForContextMenu(View view) {
		// TODO Auto-generated method stub
		Log.v(TAG,"unregisterForContextMenu");
		super.unregisterForContextMenu(view);
	}

	@Override
	protected void attachBaseContext(Context newBase) {
		// TODO Auto-generated method stub
		Log.v(TAG,"attachBaseContext");
		super.attachBaseContext(newBase);
	}

	@Override
	public Theme getTheme() {
		// TODO Auto-generated method stub
		//Log.v(TAG,"getTheme");
		return super.getTheme();
	}

	@Override
	public void setTheme(int resid) {
		// TODO Auto-generated method stub
		Log.v(TAG,"setTheme");
		super.setTheme(resid);
	}

	@Override
	public boolean bindService(Intent service, ServiceConnection conn, int flags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"bindService");
		return super.bindService(service, conn, flags);
	}

	@Override
	public int checkCallingOrSelfPermission(String permission) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkCallingOrSelfPermission");
		return super.checkCallingOrSelfPermission(permission);
	}

	@Override
	public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkCallingOrSelfUriPermission");
		return super.checkCallingOrSelfUriPermission(uri, modeFlags);
	}

	@Override
	public int checkCallingPermission(String permission) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkCallingPermission");
		return super.checkCallingPermission(permission);
	}

	@Override
	public int checkCallingUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkCallingUriPermission");
		return super.checkCallingUriPermission(uri, modeFlags);
	}

	@Override
	public int checkPermission(String permission, int pid, int uid) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkPermission");
		return super.checkPermission(permission, pid, uid);
	}

	@Override
	public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkUriPermission");
		return super.checkUriPermission(uri, pid, uid, modeFlags);
	}

	@Override
	public int checkUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"checkUriPermission");
		return super.checkUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags);
	}

	@Override
	public void clearWallpaper() throws IOException {
		// TODO Auto-generated method stub
		Log.v(TAG,"clearWallpaper");
		super.clearWallpaper();
	}

	@Override
	public Context createPackageContext(String packageName, int flags)
			throws NameNotFoundException {
		// TODO Auto-generated method stub
		Log.v(TAG,"createPackageContext");
		return super.createPackageContext(packageName, flags);
	}

	@Override
	public String[] databaseList() {
		// TODO Auto-generated method stub
		Log.v(TAG,"databaseList");
		return super.databaseList();
	}

	@Override
	public boolean deleteDatabase(String name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"deleteDatabase");
		return super.deleteDatabase(name);
	}

	@Override
	public boolean deleteFile(String name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"deleteFile");
		return super.deleteFile(name);
	}

	@Override
	public void enforceCallingOrSelfPermission(String permission, String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceCallingOrSelfPermission");
		super.enforceCallingOrSelfPermission(permission, message);
	}

	@Override
	public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceCallingOrSelfUriPermission");
		super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
	}

	@Override
	public void enforceCallingPermission(String permission, String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceCallingPermission");
		super.enforceCallingPermission(permission, message);
	}

	@Override
	public void enforceCallingUriPermission(Uri uri, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceCallingUriPermission");
		super.enforceCallingUriPermission(uri, modeFlags, message);
	}

	@Override
	public void enforcePermission(String permission, int pid, int uid,
			String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforcePermission");
		super.enforcePermission(permission, pid, uid, message);
	}

	@Override
	public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceUriPermission");
		super.enforceUriPermission(uri, pid, uid, modeFlags, message);
	}

	@Override
	public void enforceUriPermission(Uri uri, String readPermission,
			String writePermission, int pid, int uid, int modeFlags,
			String message) {
		// TODO Auto-generated method stub
		Log.v(TAG,"enforceUriPermission");
		super.enforceUriPermission(uri, readPermission, writePermission, pid, uid,
				modeFlags, message);
	}

	@Override
	public String[] fileList() {
		// TODO Auto-generated method stub
		Log.v(TAG,"fileList");
		return super.fileList();
	}

	@Override
	public Context getApplicationContext() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getApplicationContext");
		return super.getApplicationContext();
	}

	@Override
	public ApplicationInfo getApplicationInfo() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getApplicationInfo");
		return super.getApplicationInfo();
	}

	@Override
	public AssetManager getAssets() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getAssets");
		return super.getAssets();
	}

	@Override
	public Context getBaseContext() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getBaseContext");
		return super.getBaseContext();
	}

	@Override
	public File getCacheDir() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getCacheDir");
		return super.getCacheDir();
	}

	@Override
	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getClassLoader");
		return super.getClassLoader();
	}

	@Override
	public ContentResolver getContentResolver() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getContentResolver");
		return super.getContentResolver();
	}

	@Override
	public File getDatabasePath(String name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getDatabasePath");
		return super.getDatabasePath(name);
	}

	@Override
	public File getDir(String name, int mode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getDir");
		return super.getDir(name, mode);
	}

	@Override
	public File getExternalCacheDir() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getExternalCacheDir");
		return super.getExternalCacheDir();
	}

	@Override
	public File getExternalFilesDir(String type) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getExternalFilesDir");
		return super.getExternalFilesDir(type);
	}

	@Override
	public File getFileStreamPath(String name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getFileStreamPath");
		return super.getFileStreamPath(name);
	}

	@Override
	public File getFilesDir() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getFilesDir");
		return super.getFilesDir();
	}

	@Override
	public Looper getMainLooper() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getMainLooper");
		return super.getMainLooper();
	}

	@Override
	public String getPackageCodePath() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getPackageCodePath");
		return super.getPackageCodePath();
	}

	@Override
	public PackageManager getPackageManager() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getPackageManager");
		return super.getPackageManager();
	}

	@Override
	public String getPackageName() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getPackageName");
		return super.getPackageName();
	}

	@Override
	public String getPackageResourcePath() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getPackageResourcePath");
		return super.getPackageResourcePath();
	}

	@Override
	public Resources getResources() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getResources");
		return super.getResources();
	}

	@Override
	public SharedPreferences getSharedPreferences(String name, int mode) {
		// TODO Auto-generated method stub
		Log.v(TAG,"getSharedPreferences");
		return super.getSharedPreferences(name, mode);
	}

	@Override
	public Drawable getWallpaper() {
		// TODO Auto-generated method stub
		Log.v(TAG,"getWallpaper");
		return super.getWallpaper();
	}

	@Override
	public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"grantUriPermission");
		super.grantUriPermission(toPackage, uri, modeFlags);
	}

	@Override
	public boolean isRestricted() {
		// TODO Auto-generated method stub
		Log.v(TAG,"isRestricted");
		return super.isRestricted();
	}

	@Override
	public FileInputStream openFileInput(String name)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		Log.v(TAG,"openFileInput");
		return super.openFileInput(name);
	}

	@Override
	public FileOutputStream openFileOutput(String name, int mode)
			throws FileNotFoundException {
		// TODO Auto-generated method stub
		Log.v(TAG,"openFileOutput");
		return super.openFileOutput(name, mode);
	}

	@Override
	public SQLiteDatabase openOrCreateDatabase(String name, int mode,
			CursorFactory factory) {
		// TODO Auto-generated method stub
		Log.v(TAG,"openOrCreateDatabase");
		return super.openOrCreateDatabase(name, mode, factory);
	}

	@Override
	public Drawable peekWallpaper() {
		// TODO Auto-generated method stub
		Log.v(TAG,"peekWallpaper");
		return super.peekWallpaper();
	}

	@Override
	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter) {
		// TODO Auto-generated method stub
		Log.v(TAG,"registerReceiver");
		return super.registerReceiver(receiver, filter);
	}

	@Override
	public Intent registerReceiver(BroadcastReceiver receiver,
			IntentFilter filter, String broadcastPermission, Handler scheduler) {
		// TODO Auto-generated method stub
		Log.v(TAG,"registerReceiver");
		return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
	}

	@Override
	public void removeStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"removeStickyBroadcast");
		super.removeStickyBroadcast(intent);
	}

	@Override
	public void revokeUriPermission(Uri uri, int modeFlags) {
		// TODO Auto-generated method stub
		Log.v(TAG,"revokeUriPermission");
		super.revokeUriPermission(uri, modeFlags);
	}

	@Override
	public void sendBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendBroadcast");
		super.sendBroadcast(intent);
	}

	@Override
	public void sendBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendBroadcast");
		super.sendBroadcast(intent, receiverPermission);
	}

	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendOrderedBroadcast");
		super.sendOrderedBroadcast(intent, receiverPermission);
	}

	@Override
	public void sendOrderedBroadcast(Intent intent, String receiverPermission,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendOrderedBroadcast");
		super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver,
				scheduler, initialCode, initialData, initialExtras);
	}

	@Override
	public void sendStickyBroadcast(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendStickyBroadcast");
		super.sendStickyBroadcast(intent);
	}

	@Override
	public void sendStickyOrderedBroadcast(Intent intent,
			BroadcastReceiver resultReceiver, Handler scheduler,
			int initialCode, String initialData, Bundle initialExtras) {
		// TODO Auto-generated method stub
		Log.v(TAG,"sendStickyOrderedBroadcast");
		super.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler,
				initialCode, initialData, initialExtras);
	}

	@Override
	public void setWallpaper(Bitmap bitmap) throws IOException {
		// TODO Auto-generated method stub
		Log.v(TAG,"setWallpaper");
		super.setWallpaper(bitmap);
	}

	@Override
	public void setWallpaper(InputStream data) throws IOException {
		// TODO Auto-generated method stub
		Log.v(TAG,"setWallpaper");
		super.setWallpaper(data);
	}

	@Override
	public boolean startInstrumentation(ComponentName className,
			String profileFile, Bundle arguments) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startInstrumentation");
		return super.startInstrumentation(className, profileFile, arguments);
	}

	@Override
	public ComponentName startService(Intent service) {
		// TODO Auto-generated method stub
		Log.v(TAG,"startService");
		return super.startService(service);
	}

	@Override
	public boolean stopService(Intent name) {
		// TODO Auto-generated method stub
		Log.v(TAG,"stopService");
		return super.stopService(name);
	}

	@Override
	public void unbindService(ServiceConnection conn) {
		// TODO Auto-generated method stub
		Log.v(TAG,"unbindService");
		super.unbindService(conn);
	}

	@Override
	public void unregisterReceiver(BroadcastReceiver receiver) {
		// TODO Auto-generated method stub
		Log.v(TAG,"unregisterReceiver");
		super.unregisterReceiver(receiver);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Log.v(TAG,"clone");
		return super.clone();
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Log.v(TAG,"equals");
		return super.equals(o);
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		Log.v(TAG,"finalize");
		super.finalize();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		Log.v(TAG,"hashCode");
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Log.v(TAG,"toString");
		return super.toString();
	}
	
}