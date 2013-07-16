package com.alorma.multialarm.ui.adapters;

import android.content.Context;
import android.database.Cursor;
import android.provider.BaseColumns;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CursorAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.alorma.multialarm.R;
import com.alorma.multialarm.bbdd.cursors.AlarmCursor;
import com.alorma.multialarm.bean.Alarm;

public class AlarmsAdapter extends CursorAdapter implements OnCheckedChangeListener {

    private Context context;

    private OnAlarmStateListener onAlarmStateListener;

    public AlarmsAdapter(Context context, Cursor c) {
        super(context, c, 0);
        this.context = context;
    }

    @Override
    public void bindView(View view, final Context context, Cursor c) {

        ViewHolder vh = (ViewHolder) view.getTag();

        // GetData
        Alarm alarm = new AlarmCursor().read(c);

        // SetData
        vh.textName.setText(alarm.getName());

    }

    private String getStringTime(int hour, int minutes) {

        String hourStr = "";
        if (hour <= 9) {
            hourStr = "0";
        }
        hourStr = hourStr + hour;

        String minuteStr = "";
        if (minutes <= 9) {
            minuteStr = "0";
        }
        minuteStr = minuteStr + minutes;

        return String.format(
                context.getResources().getString(R.string.formatHoraAdapter),
                hourStr, minuteStr);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_alarma, parent, false);
        view.setTag(ViewHolder.create(view));
        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        long id = (Long) compoundButton.getTag();
        if (onAlarmStateListener != null) {
            if (b) {
                onAlarmStateListener.onAlarmEnabled(id);
            } else {
                onAlarmStateListener.onAlarmDisabled(id);
            }
        }
    }

    private static class ViewHolder {
        public final TextView textName;

        private ViewHolder(TextView textName) {
            this.textName = textName;
        }

        public static ViewHolder create(View v) {
            TextView textName = (TextView) v.findViewById(R.id.textName);
            return new ViewHolder(textName);
        }
    }

    public void setOnAlarmStateListener(OnAlarmStateListener onAlarmStateListener) {
        this.onAlarmStateListener = onAlarmStateListener;
    }

    public interface OnAlarmStateListener {
        void onAlarmEnabled(long id);

        void onAlarmDisabled(long id);
    }
}