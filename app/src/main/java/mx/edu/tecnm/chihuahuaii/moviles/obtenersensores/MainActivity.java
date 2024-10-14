package mx.edu.tecnm.chihuahuaii.moviles.obtenersensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Objeto para gestión de sensores, cualquier sensor
    SensorManager sensorManager;
    // Lista de sensores
    ListView listView_sensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Vincular objetos
        listView_sensores = findViewById(R.id.listView_sensores);

        // Obtener referencia al servicio de sensores
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Obtener Una lista de los sensores del dispositivo
        List<Sensor> deviceSensors = sensorManager.getSensorList(Sensor.TYPE_ALL);

        // Crear un adaptador para asignar datos y vincular a ListView
        final ArrayAdapter<Sensor> adapter = new ArrayAdapter<Sensor>(MainActivity.this, android.R.layout.simple_list_item_1, deviceSensors);

        // Asociar adaptador a ListView
        listView_sensores.setAdapter(adapter);

    }
}