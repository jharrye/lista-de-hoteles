package unal.todosalau.listadehoteles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Item> list=new ArrayList<>();

    TextInputLayout name,color,city,value;
    Button register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register=findViewById(R.id.btnRegister);
        name=findViewById(R.id.tiName);
        color=findViewById(R.id.tiColor);
        city=findViewById(R.id.tiCity);
        value=findViewById(R.id.tiValue);


        listConstructor();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item item= new Item(name.getEditText().getText().toString(),
                                    city.getEditText().getText().toString(),
                                    color.getEditText().getText().toString(),
                                    Integer.parseInt(value.getEditText().getText().toString()));

                //aqui arriba creamos el Item ahora lo agregamos a la lista acontinuacion
                // y volvemos a limpiar:

                list.add(item);
                init();//aqui realiza el proceso
                //limpiar
                name.getEditText().setText("");
                color.getEditText().setText("");
                city.getEditText().setText("");
                value.getEditText().setText("");
            }
        });
    }


    public void listConstructor(){
        list.add(new Item("Hotel Estelar", "Manizales", "#fff44336", 175000));
        list.add(new Item("Hotel Windson", "Barranquilla", "f2e98d",220000));
        list.add(new Item("Hotel Hilton", "Bogota", "#1e2c53",300000));
        list.add(new Item("Hotel Tequendama", "Medellin", "#0cabda",290000));
        list.add(new Item("Hotel Sophia", "Cartagena", "#ffe038",245000));
        list.add(new Item("Hotel Casablanca", "San andres", "#00feff",265000));
        list.add(new Item("Hotel Decameron", "Leticia", "#123e07",350000));

        init();
    }

    public void init(){
        ItemAdapter itemAdapter= new ItemAdapter(list,this);
        RecyclerView recyclerView=findViewById(R.id.rvItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(itemAdapter);
    }
}