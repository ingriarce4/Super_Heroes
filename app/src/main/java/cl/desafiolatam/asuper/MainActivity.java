package cl.desafiolatam.asuper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import cl.desafiolatam.asuper.adapter.HeroeAdapter;
import cl.desafiolatam.asuper.databinding.ActivityMainBinding;
import cl.desafiolatam.asuper.viewmodel.HeroeViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private HeroeViewModel viewModel;
    private HeroeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //crear el ViewModel
        viewModel = new ViewModelProvider(this).get(HeroeViewModel.class);

        viewModel.llamarApi();

    }
}