package com.bruyere.tpappwidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class MyWidget extends AppWidgetProvider {

    public static final String LIFE_CYCLE_CKECKER = "LIFE_CYCLE_CKECKER";

    public static void updateWidget(Context context, AppWidgetManager appWidgetManager, int appWidgetId, String text) {
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget);
        views.setTextViewText(R.id.textView, text);

        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        Log.i(LIFE_CYCLE_CKECKER, "OnUpdate");
        for (int appWidgetId :
                appWidgetIds) {
            updateWidget(context, appWidgetManager, appWidgetId, "Text");
        }
    }

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        super.onDeleted(context, appWidgetIds);
        Log.i(LIFE_CYCLE_CKECKER, "onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        Log.i(LIFE_CYCLE_CKECKER, "onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        super.onDisabled(context);
        Log.i(LIFE_CYCLE_CKECKER, "onDisabled");
    }
}
