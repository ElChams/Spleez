package com.slpeez.spleez.Menu;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.slpeez.spleez.Activity.R;

/**
 * Created by LeClem on 11/07/2016.
 */
public class NavigationDrawer {
    private DrawerLayout drawer;
    private ListView activity_items;
    private ListView settings_items;
    private ImageButton menu_button;
    private Activity activity;

    private Bitmap bmp;
    private ImageView photo;

    public NavigationDrawer(Activity act, DrawerLayout drawer, ImageButton menu_button, Bitmap bmp, ImageView photo) {
        this.drawer = drawer;
        this.menu_button = menu_button;
        this.activity = act;
        this.bmp = bmp;
        this.photo = photo;
    }

    public NavigationDrawer navigationDrawerInitialize(){
        this.setActivityItemsAdaptater();
        this.setSettingsItemsAdaptater();
        this.profilePhotoCrop();
        this.setOnClickButtonListener();
        return this;
    }

    /* Permet d'afficher une partie du menu latéral */
    private void setActivityItemsAdaptater(){
        String drawerItemsList[] = new String[4];
        drawerItemsList[0] = "Mes activités";
        drawerItemsList[1] = "Créer activité";
        drawerItemsList[2] = "Participer activité";
        drawerItemsList[3] = "Amis";
        activity_items  = (ListView) activity.findViewById(R.id.profile_list);
        activity_items.setAdapter(new ArrayAdapter<String>(activity.getApplicationContext(),
                R.layout.navigation_drawer_item_adaptater, drawerItemsList));
    }

    /* Permet d'afficher une autre partie du menu latéral */
    private void setSettingsItemsAdaptater(){
        String drawerItemsList[] = new String[4];
        drawerItemsList[0] = "Paramètres";
        drawerItemsList[1] = "Préférences";
        drawerItemsList[2] = "Règlement";
        drawerItemsList[3] = "Déconnexion";
        settings_items = (ListView) activity.findViewById(R.id.setting_list);
        settings_items.setAdapter(new ArrayAdapter<String>(activity.getApplicationContext(),
                R.layout.navigation_drawer_item_adaptater, drawerItemsList));
    }

    /* Listener pour afficher le menu latéral quand on appuie sur le boutton */
    private void setOnClickButtonListener(){
        if(menu_button!= null)
        {
            menu_button.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    if(!drawer.isDrawerOpen(Gravity.LEFT))
                    {
                        drawer.openDrawer(Gravity.LEFT);
                    }
                }
            });
        }
    }

    /* Arrondi le bitmap et la met dans l'imageview */
    private void profilePhotoCrop(){
        this.bmp = this.getRoundedBitmap(this.bmp);
        this.photo.setImageBitmap(this.bmp);
    }


    /* Arrondi le bitmap */
    private Bitmap getRoundedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawOval(rectF, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }

}
