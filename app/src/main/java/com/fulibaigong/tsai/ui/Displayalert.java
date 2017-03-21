package com.fulibaigong.tsai.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

/**
 * Created by User on 2016/8/21.
 */

public final class Displayalert {
    private static Context context;

    public Displayalert(Context context2) {

        this.context = context2;
    }

    public void displayalert() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("發現寶物，是否進入？");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (IndexActivity.place == "Chao_SC")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",1);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Chen_KK")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",2);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Chen_MT")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",3);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Chen_YF")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",4);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Chou_MW")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",5);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Huang_CC")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",6);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Liao_SW")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",7);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Shih_CH")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",8);
                            context.startActivity(it);

                        }
                        else if (IndexActivity.place == "Tsai_JY")
                        {
                            Intent it = new Intent(context,ImageTargets.class);
                            it.putExtra("number",9);
                            context.startActivity(it);

                        }

                        // code here
                        dialog.cancel();
                    }
                });

        builder.setNegativeButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        // AlertDialogActivity.this.finish();
                        dialog.cancel();
                    }
                });
        builder.show();

    }

}
