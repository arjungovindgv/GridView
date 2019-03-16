package com.myapp.test.gridview;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.zip.ZipInputStream;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    GridView mygrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mygrid = findViewById(R.id.gridView);
        mygrid.setAdapter(new VickzAdapter(this));
        mygrid.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("StatusCountry","clicked > "+position);

        Intent intent = new Intent(this, Mydialog.class);
        Log.d("StatusCountry","intent created");
        ViewHolder holder = (ViewHolder) view.getTag();

        Country tempCountry = (Country) holder.imageView.getTag();
        Log.d("StatusCountry","counter"+tempCountry.countryName);
        intent.putExtra("CountryName",tempCountry.countryName);
        intent.putExtra("CountryImage",tempCountry.imageId);
        startActivity(intent);
    }
}


class Country{
    int imageId;
    String countryName;
    Country(int imageId,String countryName){
        this.imageId=imageId;
        this.countryName=countryName;

    }

}
class ViewHolder{
    ImageView imageView;
    ViewHolder(View v){
        imageView = v.findViewById(R.id.imageView);

    }
}
class VickzAdapter extends BaseAdapter{
   ArrayList<Country> list;
   Context c;
        VickzAdapter(Context context){
            this.c = context;
            list = new ArrayList<Country>();
            Resources res = context.getResources();
            String[] tempCountryName = res.getStringArray(R.array.country_name);
            int[] tempImages={R.drawable.india,R.drawable.bangladesh,R.drawable.bhutan,R.drawable.china,R.drawable.cyprus,R.drawable.israel,R.drawable.japan,R.drawable.pakistan,R.drawable.south_korea,R.drawable.sri_lanka,R.drawable.yemen,R.drawable.azerbaijan,R.drawable.cambodia,R.drawable.kazakhstan,R.drawable.kyrgyzstan,R.drawable.zimbabwe};
            for (int i=0;i<tempImages.length;i++){
                Country tempCountry = new Country(tempImages[i],tempCountryName[i]);
                list.add(tempCountry);
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }



        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
                View row=convertView;
                ViewHolder holder =null;
                if(row==null) {
                    LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     row = inflater.inflate(R.layout.single_item, (ViewGroup) convertView, false);
                     holder = new ViewHolder(row);
                     row.setTag(holder);
                }
                else {
                    holder = (ViewHolder) row.getTag();
                }
           Country temp = list.get(position);
            holder.imageView.setImageResource(temp.imageId);
            holder.imageView.setTag(temp);
            return row;
        }
    }