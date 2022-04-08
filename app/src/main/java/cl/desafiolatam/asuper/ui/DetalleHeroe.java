package cl.desafiolatam.asuper.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import cl.desafiolatam.asuper.R;
import cl.desafiolatam.asuper.databinding.FragmentDetalleHeroeBinding;
import cl.desafiolatam.asuper.modelo.HeroesItem;
import cl.desafiolatam.asuper.viewmodel.HeroeViewModel;


public class DetalleHeroe extends Fragment {

    private FragmentDetalleHeroeBinding binding;
    private HeroeViewModel viewModel;
    private List<HeroesItem> lista;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDetalleHeroeBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(HeroeViewModel.class);
        //observar
        viewModel.getDetalle().observe(getViewLifecycleOwner(), heroesItem -> {
            binding.setLifecycleOwner(getViewLifecycleOwner());
            binding.setHeroe(heroesItem);
            Picasso.get().load(heroesItem.getImages().getMd()).into(binding.imageView4);

        });


        return binding.getRoot();
    }
}
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        binding.textView2.setText(lista.get(0).getAppearance().getWeight());
//    }
//}