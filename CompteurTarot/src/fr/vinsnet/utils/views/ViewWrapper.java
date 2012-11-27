/*******************************************************************************
 * Copyright (c) 2012 vinsnet<vinsnet@gmail.com>.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     vinsnet<vinsnet@gmail.com> - initial API and implementation
 ******************************************************************************/
package fr.vinsnet.utils.views;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Animation;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

public abstract class ViewWrapper<T,V extends View> extends View  {

	private static final View DEFAULT_VIEW = null;
	protected T object;
	protected V view;
	
	public V getView() {
		return view;
	}

	public T getObject() {
		return object;
	}
	
	protected abstract void inflate();
	
	public void addFocusables(ArrayList<View> views, int direction,
			int focusableMode) {
		view.addFocusables(views, direction, focusableMode);
	}

	public void addFocusables(ArrayList<View> views, int direction) {
		view.addFocusables(views, direction);
	}

	public void addTouchables(ArrayList<View> views) {
		view.addTouchables(views);
	}

	public void bringToFront() {
		view.bringToFront();
	}

	public void buildDrawingCache() {
		view.buildDrawingCache();
	}

	public void buildDrawingCache(boolean autoScale) {
		view.buildDrawingCache(autoScale);
	}

	public void cancelLongPress() {
		view.cancelLongPress();
	}

	public boolean checkInputConnectionProxy(View view) {
		return view.checkInputConnectionProxy(view);
	}

	public void clearAnimation() {
		view.clearAnimation();
	}

	public void clearFocus() {
		view.clearFocus();
	}

	public void computeScroll() {
		view.computeScroll();
	}

	public void createContextMenu(ContextMenu menu) {
		view.createContextMenu(menu);
	}

	public void destroyDrawingCache() {
		view.destroyDrawingCache();
	}

	public void dispatchConfigurationChanged(Configuration newConfig) {
		view.dispatchConfigurationChanged(newConfig);
	}

	public void dispatchDisplayHint(int hint) {
		view.dispatchDisplayHint(hint);
	}

	public boolean dispatchKeyEvent(KeyEvent event) {
		return view.dispatchKeyEvent(event);
	}

	public boolean dispatchKeyEventPreIme(KeyEvent event) {
		return view.dispatchKeyEventPreIme(event);
	}

	public boolean dispatchKeyShortcutEvent(KeyEvent event) {
		return view.dispatchKeyShortcutEvent(event);
	}

	public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
		return view.dispatchPopulateAccessibilityEvent(event);
	}

	public boolean dispatchTouchEvent(MotionEvent event) {
		return view.dispatchTouchEvent(event);
	}

	public boolean dispatchTrackballEvent(MotionEvent event) {
		return view.dispatchTrackballEvent(event);
	}

	public boolean dispatchUnhandledMove(View focused, int direction) {
		return view.dispatchUnhandledMove(focused, direction);
	}

	public void dispatchWindowFocusChanged(boolean hasFocus) {
		view.dispatchWindowFocusChanged(hasFocus);
	}

	public void dispatchWindowVisibilityChanged(int visibility) {
		view.dispatchWindowVisibilityChanged(visibility);
	}

	public void draw(Canvas canvas) {
		view.draw(canvas);
	}

	public boolean equals(Object o) {
		return view.equals(o);
	}

	public View findFocus() {
		return view.findFocus();
	}

	public View focusSearch(int direction) {
		return view.focusSearch(direction);
	}

	public void forceLayout() {
		view.forceLayout();
	}

	public Animation getAnimation() {
		return view.getAnimation();
	}

	public IBinder getApplicationWindowToken() {
		return view.getApplicationWindowToken();
	}

	public Drawable getBackground() {
		return view.getBackground();
	}

	public int getBaseline() {
		return view.getBaseline();
	}

	public CharSequence getContentDescription() {
		return view.getContentDescription();
	}

	public Bitmap getDrawingCache() {
		return view.getDrawingCache();
	}

	public Bitmap getDrawingCache(boolean autoScale) {
		return view.getDrawingCache(autoScale);
	}

	public int getDrawingCacheBackgroundColor() {
		return view.getDrawingCacheBackgroundColor();
	}

	public int getDrawingCacheQuality() {
		return view.getDrawingCacheQuality();
	}

	public void getDrawingRect(Rect outRect) {
		view.getDrawingRect(outRect);
	}

	public long getDrawingTime() {
		return view.getDrawingTime();
	}



	public ArrayList<View> getFocusables(int direction) {
		return view.getFocusables(direction);
	}

	public void getFocusedRect(Rect r) {
		view.getFocusedRect(r);
	}

	public boolean getGlobalVisibleRect(Rect r, Point globalOffset) {
		return view.getGlobalVisibleRect(r, globalOffset);
	}

	public Handler getHandler() {
		return view.getHandler();
	}

	public void getHitRect(Rect outRect) {
		view.getHitRect(outRect);
	}

	public int getHorizontalFadingEdgeLength() {
		return view.getHorizontalFadingEdgeLength();
	}

	public int getId() {
		return view.getId();
	}

	public boolean getKeepScreenOn() {
		return view.getKeepScreenOn();
	}

	public DispatcherState getKeyDispatcherState() {
		return view.getKeyDispatcherState();
	}

	public LayoutParams getLayoutParams() {
		return view.getLayoutParams();
	}

	public void getLocationInWindow(int[] location) {
		view.getLocationInWindow(location);
	}

	public void getLocationOnScreen(int[] location) {
		view.getLocationOnScreen(location);
	}

	public int getNextFocusDownId() {
		return view.getNextFocusDownId();
	}

	public int getNextFocusLeftId() {
		return view.getNextFocusLeftId();
	}

	public int getNextFocusRightId() {
		return view.getNextFocusRightId();
	}

	public int getNextFocusUpId() {
		return view.getNextFocusUpId();
	}

	public OnFocusChangeListener getOnFocusChangeListener() {
		return view.getOnFocusChangeListener();
	}



	public int getPaddingBottom() {
		return view.getPaddingBottom();
	}

	public int getPaddingLeft() {
		return view.getPaddingLeft();
	}

	public int getPaddingRight() {
		return view.getPaddingRight();
	}

	public int getPaddingTop() {
		return view.getPaddingTop();
	}

	public Resources getResources() {
		return view.getResources();
	}

	public View getRootView() {
		return view.getRootView();
	}

	public int getScrollBarStyle() {
		return view.getScrollBarStyle();
	}

	public int getSolidColor() {
		return view.getSolidColor();
	}

	public Object getTag() {
		return view.getTag();
	}

	public Object getTag(int key) {
		return view.getTag(key);
	}

	public TouchDelegate getTouchDelegate() {
		return view.getTouchDelegate();
	}

	public ArrayList<View> getTouchables() {
		return view.getTouchables();
	}

	public int getVerticalFadingEdgeLength() {
		return view.getVerticalFadingEdgeLength();
	}

	public int getVerticalScrollbarWidth() {
		return view.getVerticalScrollbarWidth();
	}

	public ViewTreeObserver getViewTreeObserver() {
		return view.getViewTreeObserver();
	}

	public int getVisibility() {
		return view.getVisibility();
	}

	public IBinder getWindowToken() {
		return view.getWindowToken();
	}

	public int getWindowVisibility() {
		return view.getWindowVisibility();
	}

	public void getWindowVisibleDisplayFrame(Rect outRect) {
		view.getWindowVisibleDisplayFrame(outRect);
	}

	public boolean hasFocus() {
		return view.hasFocus();
	}

	public boolean hasFocusable() {
		return view.hasFocusable();
	}

	public boolean hasWindowFocus() {
		return view.hasWindowFocus();
	}

	public int hashCode() {
		return view.hashCode();
	}

	public void invalidate() {
		view.invalidate();
	}

	public void invalidate(int l, int t, int r, int b) {
		view.invalidate(l, t, r, b);
	}

	public void invalidate(Rect dirty) {
		view.invalidate(dirty);
	}

	public void invalidateDrawable(Drawable drawable) {
		view.invalidateDrawable(drawable);
	}

	public boolean isClickable() {
		return view.isClickable();
	}

	public boolean isDrawingCacheEnabled() {
		return view.isDrawingCacheEnabled();
	}

	public boolean isDuplicateParentStateEnabled() {
		return view.isDuplicateParentStateEnabled();
	}

	public boolean isEnabled() {
		return view.isEnabled();
	}

	public boolean isFocused() {
		return view.isFocused();
	}

	public boolean isHapticFeedbackEnabled() {
		return view.isHapticFeedbackEnabled();
	}

	public boolean isHorizontalFadingEdgeEnabled() {
		return view.isHorizontalFadingEdgeEnabled();
	}

	public boolean isHorizontalScrollBarEnabled() {
		return view.isHorizontalScrollBarEnabled();
	}

	public boolean isInEditMode() {
		return view.isInEditMode();
	}

	public boolean isInTouchMode() {
		return view.isInTouchMode();
	}

	public boolean isLayoutRequested() {
		return view.isLayoutRequested();
	}

	public boolean isLongClickable() {
		return view.isLongClickable();
	}

	public boolean isOpaque() {
		return view.isOpaque();
	}

	public boolean isPressed() {
		return view.isPressed();
	}

	public boolean isSaveEnabled() {
		return view.isSaveEnabled();
	}

	public boolean isScrollbarFadingEnabled() {
		return view.isScrollbarFadingEnabled();
	}

	public boolean isSelected() {
		return view.isSelected();
	}

	public boolean isShown() {
		return view.isShown();
	}

	public boolean isSoundEffectsEnabled() {
		return view.isSoundEffectsEnabled();
	}

	public boolean isVerticalFadingEdgeEnabled() {
		return view.isVerticalFadingEdgeEnabled();
	}

	public boolean isVerticalScrollBarEnabled() {
		return view.isVerticalScrollBarEnabled();
	}

	public void offsetLeftAndRight(int offset) {
		view.offsetLeftAndRight(offset);
	}

	public void offsetTopAndBottom(int offset) {
		view.offsetTopAndBottom(offset);
	}

	public boolean onCheckIsTextEditor() {
		return view.onCheckIsTextEditor();
	}

	public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
		return view.onCreateInputConnection(outAttrs);
	}



	public void onFinishTemporaryDetach() {
		view.onFinishTemporaryDetach();
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return view.onKeyDown(keyCode, event);
	}

	public boolean onKeyLongPress(int keyCode, KeyEvent event) {
		return view.onKeyLongPress(keyCode, event);
	}

	public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
		return view.onKeyMultiple(keyCode, repeatCount, event);
	}

	public boolean onKeyPreIme(int keyCode, KeyEvent event) {
		return view.onKeyPreIme(keyCode, event);
	}

	public boolean onKeyShortcut(int keyCode, KeyEvent event) {
		return view.onKeyShortcut(keyCode, event);
	}

	public boolean onKeyUp(int keyCode, KeyEvent event) {
		return view.onKeyUp(keyCode, event);
	}

	public void onStartTemporaryDetach() {
		view.onStartTemporaryDetach();
	}

	public boolean onTouchEvent(MotionEvent event) {
		return view.onTouchEvent(event);
	}

	public boolean onTrackballEvent(MotionEvent event) {
		return view.onTrackballEvent(event);
	}

	public void onWindowFocusChanged(boolean hasWindowFocus) {
		view.onWindowFocusChanged(hasWindowFocus);
	}

	public boolean performClick() {
		return view.performClick();
	}

	public boolean performHapticFeedback(int feedbackConstant, int flags) {
		return view.performHapticFeedback(feedbackConstant, flags);
	}

	public boolean performHapticFeedback(int feedbackConstant) {
		return view.performHapticFeedback(feedbackConstant);
	}

	public boolean performLongClick() {
		return view.performLongClick();
	}

	public void playSoundEffect(int soundConstant) {
		view.playSoundEffect(soundConstant);
	}

	public boolean post(Runnable action) {
		return view.post(action);
	}

	public boolean postDelayed(Runnable action, long delayMillis) {
		return view.postDelayed(action, delayMillis);
	}

	public void postInvalidate() {
		view.postInvalidate();
	}

	public void postInvalidate(int left, int top, int right, int bottom) {
		view.postInvalidate(left, top, right, bottom);
	}

	public void postInvalidateDelayed(long delayMilliseconds, int left,
			int top, int right, int bottom) {
		view.postInvalidateDelayed(delayMilliseconds, left, top, right, bottom);
	}

	public void postInvalidateDelayed(long delayMilliseconds) {
		view.postInvalidateDelayed(delayMilliseconds);
	}

	public void refreshDrawableState() {
		view.refreshDrawableState();
	}

	public boolean removeCallbacks(Runnable action) {
		return view.removeCallbacks(action);
	}

	public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
		return view.requestFocus(direction, previouslyFocusedRect);
	}

	public void requestLayout() {
		view.requestLayout();
	}

	public boolean requestRectangleOnScreen(Rect rectangle, boolean immediate) {
		return view.requestRectangleOnScreen(rectangle, immediate);
	}

	public boolean requestRectangleOnScreen(Rect rectangle) {
		return view.requestRectangleOnScreen(rectangle);
	}

	public void restoreHierarchyState(SparseArray<Parcelable> container) {
		view.restoreHierarchyState(container);
	}

	public void saveHierarchyState(SparseArray<Parcelable> container) {
		view.saveHierarchyState(container);
	}

	public void scheduleDrawable(Drawable who, Runnable what, long when) {
		view.scheduleDrawable(who, what, when);
	}

	public void scrollBy(int x, int y) {
		view.scrollBy(x, y);
	}

	public void scrollTo(int x, int y) {
		view.scrollTo(x, y);
	}

	public void sendAccessibilityEvent(int eventType) {
		view.sendAccessibilityEvent(eventType);
	}

	public void sendAccessibilityEventUnchecked(AccessibilityEvent event) {
		view.sendAccessibilityEventUnchecked(event);
	}

	public void setAnimation(Animation animation) {
		view.setAnimation(animation);
	}

	public void setBackgroundColor(int color) {
		view.setBackgroundColor(color);
	}

	public void setBackgroundDrawable(Drawable background) {
		view.setBackgroundDrawable(background);
	}

	public void setBackgroundResource(int resid) {
		view.setBackgroundResource(resid);
	}

	public void setClickable(boolean clickable) {
		view.setClickable(clickable);
	}

	public void setContentDescription(CharSequence contentDescription) {
		view.setContentDescription(contentDescription);
	}

	public void setDrawingCacheBackgroundColor(int color) {
		view.setDrawingCacheBackgroundColor(color);
	}

	public void setDrawingCacheEnabled(boolean enabled) {
		view.setDrawingCacheEnabled(enabled);
	}

	public void setDrawingCacheQuality(int quality) {
		view.setDrawingCacheQuality(quality);
	}

	public void setDuplicateParentStateEnabled(boolean enabled) {
		view.setDuplicateParentStateEnabled(enabled);
	}

	public void setEnabled(boolean enabled) {
		view.setEnabled(enabled);
	}

	public void setFadingEdgeLength(int length) {
		view.setFadingEdgeLength(length);
	}



	public void setFocusable(boolean focusable) {
		view.setFocusable(focusable);
	}

	public void setFocusableInTouchMode(boolean focusableInTouchMode) {
		view.setFocusableInTouchMode(focusableInTouchMode);
	}

	public void setHapticFeedbackEnabled(boolean hapticFeedbackEnabled) {
		view.setHapticFeedbackEnabled(hapticFeedbackEnabled);
	}

	public void setHorizontalFadingEdgeEnabled(
			boolean horizontalFadingEdgeEnabled) {
		view.setHorizontalFadingEdgeEnabled(horizontalFadingEdgeEnabled);
	}

	public void setHorizontalScrollBarEnabled(boolean horizontalScrollBarEnabled) {
		view.setHorizontalScrollBarEnabled(horizontalScrollBarEnabled);
	}

	public void setId(int id) {
		view.setId(id);
	}

	public void setKeepScreenOn(boolean keepScreenOn) {
		view.setKeepScreenOn(keepScreenOn);
	}

	public void setLayoutParams(LayoutParams params) {
		view.setLayoutParams(params);
	}

	public void setLongClickable(boolean longClickable) {
		view.setLongClickable(longClickable);
	}

	public void setMinimumHeight(int minHeight) {
		view.setMinimumHeight(minHeight);
	}

	public void setMinimumWidth(int minWidth) {
		view.setMinimumWidth(minWidth);
	}

	public void setNextFocusDownId(int nextFocusDownId) {
		view.setNextFocusDownId(nextFocusDownId);
	}

	public void setNextFocusLeftId(int nextFocusLeftId) {
		view.setNextFocusLeftId(nextFocusLeftId);
	}

	public void setNextFocusRightId(int nextFocusRightId) {
		view.setNextFocusRightId(nextFocusRightId);
	}

	public void setNextFocusUpId(int nextFocusUpId) {
		view.setNextFocusUpId(nextFocusUpId);
	}

	public void setOnClickListener(OnClickListener l) {
		view.setOnClickListener(l);
	}

	public void setOnCreateContextMenuListener(OnCreateContextMenuListener l) {
		view.setOnCreateContextMenuListener(l);
	}

	public void setOnFocusChangeListener(OnFocusChangeListener l) {
		view.setOnFocusChangeListener(l);
	}

	public void setOnKeyListener(OnKeyListener l) {
		view.setOnKeyListener(l);
	}

	public void setOnLongClickListener(OnLongClickListener l) {
		view.setOnLongClickListener(l);
	}

	public void setOnTouchListener(OnTouchListener l) {
		view.setOnTouchListener(l);
	}



	public void setPadding(int left, int top, int right, int bottom) {
		view.setPadding(left, top, right, bottom);
	}

	public void setPressed(boolean pressed) {
		view.setPressed(pressed);
	}

	public void setSaveEnabled(boolean enabled) {
		view.setSaveEnabled(enabled);
	}

	public void setScrollBarStyle(int style) {
		view.setScrollBarStyle(style);
	}

	public void setScrollContainer(boolean isScrollContainer) {
		view.setScrollContainer(isScrollContainer);
	}

	public void setScrollbarFadingEnabled(boolean fadeScrollbars) {
		view.setScrollbarFadingEnabled(fadeScrollbars);
	}

	public void setSelected(boolean selected) {
		view.setSelected(selected);
	}

	public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
		view.setSoundEffectsEnabled(soundEffectsEnabled);
	}

	public void setTag(int key, Object tag) {
		view.setTag(key, tag);
	}

	public void setTag(Object tag) {
		view.setTag(tag);
	}

	public void setTouchDelegate(TouchDelegate delegate) {
		view.setTouchDelegate(delegate);
	}

	public void setVerticalFadingEdgeEnabled(boolean verticalFadingEdgeEnabled) {
		view.setVerticalFadingEdgeEnabled(verticalFadingEdgeEnabled);
	}

	public void setVerticalScrollBarEnabled(boolean verticalScrollBarEnabled) {
		view.setVerticalScrollBarEnabled(verticalScrollBarEnabled);
	}

	public void setVisibility(int visibility) {
		view.setVisibility(visibility);
	}

	public void setWillNotCacheDrawing(boolean willNotCacheDrawing) {
		view.setWillNotCacheDrawing(willNotCacheDrawing);
	}

	public void setWillNotDraw(boolean willNotDraw) {
		view.setWillNotDraw(willNotDraw);
	}

	public boolean showContextMenu() {
		return view.showContextMenu();
	}

	public void startAnimation(Animation animation) {
		view.startAnimation(animation);
	}

	public String toString() {
		return view.toString();
	}

	public void unscheduleDrawable(Drawable who, Runnable what) {
		view.unscheduleDrawable(who, what);
	}

	public void unscheduleDrawable(Drawable who) {
		view.unscheduleDrawable(who);
	}

	public boolean willNotCacheDrawing() {
		return view.willNotCacheDrawing();
	}

	public boolean willNotDraw() {
		return view.willNotDraw();
	}

	public ViewWrapper(Context context,V view, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.view=view;
		inflate();
	}

	public ViewWrapper(Context context,V view, AttributeSet attrs) {
		super(context, attrs);
		this.view=view;
		inflate();
	}
	public ViewWrapper(Context context,V view) {
		super(context);
		this.view=view;
		inflate();
	}

	@SuppressWarnings("unchecked")
	public ViewWrapper(Context context, AttributeSet attrs, int defStyle) {
		this(context,(V)DEFAULT_VIEW, attrs, defStyle);
	}

	@SuppressWarnings("unchecked")
	public ViewWrapper(Context context, AttributeSet attrs) {
		this(context,(V)DEFAULT_VIEW, attrs);
	}
	
	@SuppressWarnings("unchecked")
	public ViewWrapper(Context context) {
		this(context,(V)DEFAULT_VIEW);
	}


	public void setObject(T o){
		this.object = o;	
		onObjectUpdate();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		onObjectUpdate();
		super.onDraw(canvas);
	}
	
	
	
	protected abstract void onObjectUpdate() ;

}
